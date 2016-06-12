package ru.yarobot.usecase.campaigns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.yarobot.entities.model.Campaign;
import ru.yarobot.entities.model.CampaignPage;
import ru.yarobot.repositories.CampaignsRepository;
import ru.yarobot.usecase.BaseInteractor;
import rx.Observable;


public class CampaignsInteractor extends BaseInteractor<CampaignPage> {

    private CampaignsRepository repository;

    public CampaignsInteractor(Observable.Transformer schedulersTransformer, CampaignsRepository repository) {
        super(schedulersTransformer);
        this.repository = repository;
    }

    public Observable<CampaignPage> getCampaignsList() {
        return applySchedulers(
                Observable.create(subscriber -> {
                    try {
                        CampaignPage entity = new CampaignPage(new ArrayList<>());
                        repository.getCampaignsList(0).subscribe(
                                campaignPage -> {
                                    collectData(entity, campaignPage.getCampaigns());
                                    for (int i = 1; i < campaignPage.getTotalPages(); i++) {
                                        repository.getCampaignsList(i).subscribe(
                                                campaignPage1 -> {
                                                    try {
                                                        collectData(entity, campaignPage1.getCampaigns());
                                                    } catch (Exception e) {
                                                        subscriber.onError(e);
                                                    }
                                                }
                                        );
                                    }
                                    subscriber.onNext(entity);
                                },
                                subscriber::onError
                        );
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }

                })
        );
    }


    private void collectData(CampaignPage entity, List<Campaign> page) {
        entity.getCampaigns().addAll(page);
        for (Campaign campaign : page) {
            repository.getCampaignsInfo(campaign.getCampaignID()).subscribe(
                    campaign::setCampaignInfo
            );
        }
    }
}
