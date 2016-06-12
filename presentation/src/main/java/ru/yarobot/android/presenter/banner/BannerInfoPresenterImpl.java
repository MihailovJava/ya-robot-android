package ru.yarobot.android.presenter.banner;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.yarobot.android.presenter.base.BasePresenterImpl;
import ru.yarobot.android.view.BannerListView;
import ru.yarobot.usecase.banners.BannersInteractor;



@Singleton
public class BannerInfoPresenterImpl  extends BasePresenterImpl<BannerListView> implements BannerInfoPresenter {

    BannersInteractor interactor;


    @Inject
    public BannerInfoPresenterImpl(BannersInteractor interactor) {
        this.interactor = interactor;
    }



    @Override
    public void onGetBannerList(int campaignId) {
        interactor.getBanners(campaignId).subscribe(banners -> {
            view.showBannerList(banners);
        }, this::handleError);
    }

    private void handleError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
