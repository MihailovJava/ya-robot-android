package ru.yarobot.repositories.banners.rest;

import ru.yarobot.entities.model.BannerInfoPage;
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
                    subscriber.onNext(bannerInfoPage);
                });
            } catch (Exception e) {
                subscriber.onError(e);
            }

        });
    }
}
