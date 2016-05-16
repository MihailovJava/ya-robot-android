package ru.yarobot.android.di.modules;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import ru.yarobot.android.presenter.banner.BannerInfoPresenterImpl;
import ru.yarobot.android.presenter.bus.banner.BannerInfoCommunicationBus;
import ru.yarobot.repositories.BannerRepository;
import ru.yarobot.repositories.banners.BannerRepositoryImpl;
import ru.yarobot.repositories.banners.rest.BannerApi;
import ru.yarobot.repositories.banners.rest.BannerRestRepository;
import ru.yarobot.repositories.banners.rest.BannerRestRepositoryImpl;
import ru.yarobot.usecase.banners.BannersInteractor;
import ru.yarobot.util.RetrofitApiFactory;
import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
@Module
public class BannerInfoModule {

    @Provides
    @Singleton
    @Inject
    BannerInfoCommunicationBus bannerInfoCommunicationBus(BannerInfoPresenterImpl presenter){
        return new BannerInfoCommunicationBus(presenter);
    }

    @Provides
    @Singleton
    @Inject
    BannerInfoPresenterImpl bannerInfoPresenter(BannersInteractor interactor){
        return new BannerInfoPresenterImpl(interactor);
    }

    @Provides
    @Singleton
    @Inject
    BannersInteractor bannersInteractor(Observable.Transformer transformer, BannerRepository repository){
        return new BannersInteractor(transformer,repository);
    }

    @Provides
    @Singleton
    @Inject
    BannerRepository bannerRepository(BannerRestRepository repository){
        return new BannerRepositoryImpl(repository);
    }

    @Provides
    @Singleton
    @Inject
    BannerRestRepository bannerRestRepository(RetrofitApiFactory factory){
        return new BannerRestRepositoryImpl(factory);
    }

    @Provides
    @Singleton
    @Inject
    RetrofitApiFactory provideRetrofitApiFactory(Retrofit retrofit) {
        return new RetrofitApiFactory(retrofit);
    }


}
