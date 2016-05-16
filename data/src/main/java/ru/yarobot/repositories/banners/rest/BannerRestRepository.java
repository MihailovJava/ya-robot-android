package ru.yarobot.repositories.banners.rest;

import ru.yarobot.entities.model.BannerInfoPage;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public interface BannerRestRepository {
    Observable<BannerInfoPage> getInfoPage(int page);
}
