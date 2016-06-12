package ru.yarobot.repositories.campaigns.rest;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.yarobot.entities.model.BannerPage;
import ru.yarobot.entities.model.Campaign;
import ru.yarobot.entities.model.CampaignInfo;
import ru.yarobot.entities.model.CampaignPage;
import rx.Observable;

/**
 * Created by Nixy on 02.06.2016.
 */
public interface CampaignsApi {
    String CAMPAIGNS_LIST_URL = "/v1/campaigns/list";
    String CAMPAIGN_BY_ID_URL = "/v1/campaigns/{campaignId}";
    String INFO_BY_ID_URL = "/v1/campaigns/{campaignId}/info";
   String CAMPAIGN_BANNERS_BY_ID_URL = "/v1/campaigns/{campaignId}/banners";


    @GET(CAMPAIGNS_LIST_URL)
    Observable<CampaignPage> getCampaignsList(@Query("page") int page);

    @GET(CAMPAIGN_BY_ID_URL)
    Observable<Campaign> getCampagins(@Path("campaignId") int id);

    @GET(CAMPAIGN_BANNERS_BY_ID_URL)
    Observable<BannerPage> getCampaginsBanners(@Path("campaignId") int id);

    @GET(INFO_BY_ID_URL)
    Observable<CampaignInfo> getCampaginsInfo(@Path("campaignId") int id);
}
