package ru.yarobot.repositories.banners.rest;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.yarobot.entities.model.Banner;
import ru.yarobot.entities.model.BannerInfo;
import ru.yarobot.entities.model.BannerPage;
import rx.Observable;

/**
 * Created by Nixy on 15.05.2016.
 */
public interface BannerApi {

    String BANNER_LIST_URL = "/v1/banners/list";
    String BANNER_BY_ID_URL = "/v1/banners/{bannerId}";
    String INFO_BY_ID_URL = "/v1/banners/{bannerId}/info";
    String INFO_BY_CAMPAIGN_ID_URL = "/v1/campaigns/{campaignId}/banners";


    @GET(BANNER_LIST_URL)
    Observable<BannerPage> getPage(@Query("page") int page);

    @GET(BANNER_BY_ID_URL)
    Observable<Banner> getBanner(@Path("bannerId") int id);

    @GET(INFO_BY_ID_URL)
    Observable<BannerInfo> getBannerInfo(@Path("bannerId") long id);

    @GET(INFO_BY_CAMPAIGN_ID_URL)
    Observable<BannerPage> getBanners(@Path("campaignId") int id,@Query("page") int page);
}
