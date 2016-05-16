package ru.yarobot.repositories.banners.rest;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import ru.yarobot.entities.model.BannerInfoPage;

/**
 * Created by Nixy on 15.05.2016.
 */
public interface BannerApi {

    public static final String BANNER_LIST_URL = "/v1/banners/list";
    @GET(BANNER_LIST_URL)
    Observable<BannerInfoPage> getPage(@Query("page") int page);
}
