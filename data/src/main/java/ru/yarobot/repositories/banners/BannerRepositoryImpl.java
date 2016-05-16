package ru.yarobot.repositories.banners;

import ru.yarobot.entities.model.BannerInfoPage;
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
    public Observable<BannerInfoPage> getBannerInfo(int page) {
        return repository.getInfoPage(page);
    }
}
