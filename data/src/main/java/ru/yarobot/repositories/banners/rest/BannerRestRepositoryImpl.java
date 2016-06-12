package ru.yarobot.repositories.banners.rest;

import ru.yarobot.entities.model.Banner;
import ru.yarobot.entities.model.BannerInfo;
import ru.yarobot.entities.model.BannerInfoPage;
import ru.yarobot.entities.model.BannerPage;
import ru.yarobot.util.RetrofitApiFactory;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public class BannerRestRepositoryImpl implements BannerRestRepository {


    BannerApi api;

    public BannerRestRepositoryImpl(RetrofitApiFactory factory) {
        this.api = factory.build(BannerApi.class);
    }

    @Override
    public Observable<BannerInfoPage> getInfoPage(int page) {
        return Observable.create(subscriber -> {
            try {
                api.getPage(page).subscribe(bannerInfoPage -> {
                   // subscriber.onNext(bannerInfoPage);
                });
            } catch (Exception e) {
                subscriber.onError(e);
            }

        });
    }



    @Override
    public Observable<Banner> getBanner(int id) {
        return Observable.create(subscriber -> {
            try {
                api.getBanner(id).subscribe(banner -> {
                    subscriber.onNext(banner);
                });
            } catch (Exception e) {
                subscriber.onError(e);
            }

        });
    }

    @Override
    public Observable<BannerInfo> getBannerInfo(long id) {
        return Observable.create(subscriber -> {
            try {
                api.getBannerInfo(id).subscribe(bannerInfo -> {
                    subscriber.onNext(bannerInfo);
                });
            } catch (Exception e) {
                subscriber.onError(e);
            }

        });
    }

    @Override
    public Observable<BannerPage> getBanners(int campaignId,int page) {
        return Observable.create(subscriber -> {
            try {
                api.getBanners(campaignId,page).subscribe(banners -> {
                    subscriber.onNext(banners);
                });
            } catch (Exception e) {
                subscriber.onError(e);
            }

        });
    }
}
