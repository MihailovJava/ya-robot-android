package ru.yarobot.android.presenter.bus.banner;

import javax.inject.Inject;

import ru.yarobot.android.presenter.banner.BannerInfoPresenter;
import ru.yarobot.android.presenter.banner.BannerInfoPresenterImpl;
import ru.yarobot.android.presenter.base.BasePresenter;
import ru.yarobot.android.presenter.bus.base.BaseCommunicationBus;
import ru.yarobot.android.view.BannerInfoView;
import ru.yarobot.android.view.ViewState;
import ru.yarobot.entities.BannerPositionEntity;

/**
 * Created by Nixy on 16.05.2016.
 */
public class BannerInfoCommunicationBus extends BaseCommunicationBus<BannerInfoView>
        implements BannerInfoPresenter,BannerInfoView {

    @Inject
    BannerInfoPresenterImpl presenter;

    BannerPositionEntity entity;


    public BannerInfoCommunicationBus(BannerInfoPresenterImpl presenter) {
        this.presenter = presenter;
        presenter.attach(this);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void apply() {
        switch (viewState){
            case ViewState.LOADED:
                view.showLoading(false);
                view.showBannerInfo(entity);
                break;
            case ViewState.LOADING:
                view.showLoading(true);
                break;
        }
    }

    @Override
    public void onGetBannerInfo() {
        if(viewState != ViewState.LOADED) {
            setViewState(ViewState.LOADING);
            presenter.onGetBannerInfo();
        } else {
            apply();
        }
    }

    @Override
    public void showBannerInfo(BannerPositionEntity bannerPositionEntity) {
        entity = bannerPositionEntity;
        setViewState(ViewState.LOADED);
    }
}
