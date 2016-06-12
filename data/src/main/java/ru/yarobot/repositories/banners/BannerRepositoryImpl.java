package ru.yarobot.repositories.banners;

import java.util.List;

import ru.yarobot.entities.model.Banner;
import ru.yarobot.entities.model.BannerInfo;
import ru.yarobot.entities.model.BannerInfoPage;
import ru.yarobot.entities.model.BannerPage;
import ru.yarobot.repositories.BannerRepository;
import ru.yarobot.repositories.banners.rest.BannerRestRepository;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public class BannerRepositoryImpl implements BannerRepository {


    BannerRestRepository repository;

    public BannerRepositoryImpl(BannerRestRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<Banner> getBanner(int id) {
        return repository.getBanner(id);
    }

    @Override
    public Observable<BannerInfo> getBannerInfo(long id) {
        return repository.getBannerInfo(id);
    }

    @Override
    public Observable<BannerPage> getBannersList(int campaignId, int page) {
        return repository.getBanners(campaignId,page);
    }
}
