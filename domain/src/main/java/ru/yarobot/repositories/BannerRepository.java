package ru.yarobot.repositories;

import java.util.List;

import ru.yarobot.entities.model.Banner;
import ru.yarobot.entities.model.BannerInfo;
import ru.yarobot.entities.model.BannerInfoPage;
import ru.yarobot.entities.model.BannerPage;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public interface BannerRepository {

    Observable<Banner> getBanner(int id);

    Observable<BannerPage> getBannersList(int campaignId, int page);

    Observable<BannerInfo> getBannerInfo(long id);
}
