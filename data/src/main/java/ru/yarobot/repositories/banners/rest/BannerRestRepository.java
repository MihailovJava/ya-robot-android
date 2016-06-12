package ru.yarobot.repositories.banners.rest;

import ru.yarobot.entities.model.Banner;
import ru.yarobot.entities.model.BannerInfo;
import ru.yarobot.entities.model.BannerInfoPage;
import ru.yarobot.entities.model.BannerPage;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public interface BannerRestRepository {
    Observable<BannerInfoPage> getInfoPage(int page);

    Observable<Banner> getBanner(int id);

    Observable<BannerInfo> getBannerInfo(long id);

    Observable<BannerPage> getBanners(int campaignId,int page);
}
