package ru.yarobot.repositories.banners.rest;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.yarobot.entities.model.Banner;
import ru.yarobot.entities.model.BannerInfo;
import rx.Observable;
import ru.yarobot.entities.model.BannerInfoPage;

/**
 * Created by Nixy on 15.05.2016.
 */
public interface BannerApi {

    String BANNER_LIST_URL = "/v1/banners/list";
    String BANNER_BY_ID_URL = "/v1/banners/{bannerId}";
    String INFO_BY_ID_URL = "/v1/banners/{bannerId}/info";


    @GET(BANNER_LIST_URL)
    Observable<BannerInfoPage> getPage(@Query("page") int page);

    @GET(BANNER_BY_ID_URL)
    Observable<Banner> getBanner(@Path("bannerId") int id);

    @GET(INFO_BY_ID_URL)
    Observable<BannerInfo> getBannerInfo(@Path("bannerId") int id);
}
