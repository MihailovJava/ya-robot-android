package ru.yarobot.repositories.campaigns.rest;

import ru.yarobot.entities.model.BannerPage;
import ru.yarobot.entities.model.Campaign;
import ru.yarobot.entities.model.CampaignInfo;
import ru.yarobot.entities.model.CampaignPage;
import rx.Observable;


public interface CampaignsRestRepository {
    Observable<CampaignPage> getCampaignsList(int page);

    Observable<Campaign> getCampaigns(int id);

    Observable<BannerPage> getCampaignsBanners(int id);

    Observable<CampaignInfo> getCampaignsInfo(int id);
}
