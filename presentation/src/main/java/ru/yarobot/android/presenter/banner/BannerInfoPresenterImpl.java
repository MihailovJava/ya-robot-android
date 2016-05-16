package ru.yarobot.android.presenter.banner;

import ru.yarobot.android.presenter.base.BasePresenterImpl;
import ru.yarobot.android.view.BannerInfoView;
import ru.yarobot.usecase.banners.BannersInteractor;

/**
 * Created by Nixy on 16.05.2016.
 */
public class BannerInfoPresenterImpl  extends BasePresenterImpl<BannerInfoView> implements BannerInfoPresenter {

    BannersInteractor interactor;


    public BannerInfoPresenterImpl(BannersInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onGetBannerInfo() {
        interactor.getBannerPosition().subscribe(bannerPositionEntity -> {
                view.showBannerInfo(bannerPositionEntity);
        }, this::handleError);
    }

    private void handleError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
