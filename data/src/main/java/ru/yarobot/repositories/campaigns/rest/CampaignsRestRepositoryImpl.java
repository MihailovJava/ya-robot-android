package ru.yarobot.repositories.campaigns.rest;



import javax.inject.Inject;
import javax.inject.Singleton;

import ru.yarobot.entities.model.BannerPage;
import ru.yarobot.entities.model.Campaign;
import ru.yarobot.entities.model.CampaignInfo;
import ru.yarobot.entities.model.CampaignPage;
import ru.yarobot.util.RetrofitApiFactory;
import rx.Observable;

@Singleton
public class CampaignsRestRepositoryImpl implements CampaignsRestRepository {

    private CampaignsApi api;

    @Inject
    public CampaignsRestRepositoryImpl(RetrofitApiFactory factory) {
        this.api = factory.build(CampaignsApi.class);
    }

    @Override
    public Observable<CampaignPage> getCampaignsList(int page) {
        return api.getCampaignsList(page);
    }

    @Override
    public Observable<Campaign> getCampaigns(int id) {
        return null;
    }

    @Override
    public Observable<BannerPage> getCampaignsBanners(int id) {
        return null;
    }

    @Override
    public Observable<CampaignInfo> getCampaignsInfo(int id) {
        return api.getCampaginsInfo(id);
    }
}
