package ru.yarobot.repositories.campaigns;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.yarobot.entities.model.CampaignInfo;
import ru.yarobot.entities.model.CampaignPage;
import ru.yarobot.repositories.CampaignsRepository;
import ru.yarobot.repositories.campaigns.rest.CampaignsRestRepository;
import ru.yarobot.repositories.campaigns.rest.CampaignsRestRepositoryImpl;
import rx.Observable;

/**
 * Created by Nixy on 04.06.2016.
 */
@Singleton
public class CampaignsRepositoryImpl implements CampaignsRepository {

    private CampaignsRestRepository repository;

    @Inject
    public CampaignsRepositoryImpl(CampaignsRestRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Observable<CampaignPage> getCampaignsList(int page) {
        return repository.getCampaignsList(page);
    }

    @Override
    public Observable<CampaignInfo> getCampaignsInfo(int id) {
        return repository.getCampaignsInfo(id);
    }
}
