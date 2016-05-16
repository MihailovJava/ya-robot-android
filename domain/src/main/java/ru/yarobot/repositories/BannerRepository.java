package ru.yarobot.repositories;

import ru.yarobot.entities.model.BannerInfoPage;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public interface BannerRepository {
    Observable<BannerInfoPage> getBannerInfo(int page);
}
