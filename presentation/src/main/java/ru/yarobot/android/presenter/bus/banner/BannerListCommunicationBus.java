package ru.yarobot.android.presenter.bus.banner;

import java.util.List;

import javax.inject.Inject;

import ru.yarobot.android.presenter.banner.BannerInfoPresenter;
import ru.yarobot.android.presenter.banner.BannerInfoPresenterImpl;
import ru.yarobot.android.presenter.base.BasePresenter;
import ru.yarobot.android.presenter.bus.base.BaseCommunicationBus;
import ru.yarobot.android.view.BannerListView;
import ru.yarobot.android.view.ViewState;
import ru.yarobot.entities.model.Banner;

/**
 * Created by Nixy on 16.05.2016.
 */
public class BannerListCommunicationBus extends BaseCommunicationBus<BannerListView>
        implements BannerInfoPresenter,BannerListView {

    @Inject
    BannerInfoPresenterImpl presenter;

    List<Banner> entity;


    public BannerListCommunicationBus(BannerInfoPresenterImpl presenter) {
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
                view.showBannerList(entity);
                break;
            case ViewState.LOADING:
                view.showLoading(true);
                break;
        }
    }

    @Override
    public void onGetBannerList(int id) {
        if(viewState != ViewState.LOADED) {
            setViewState(ViewState.LOADING);
            presenter.onGetBannerList(id);
        } else {
            apply();
        }
    }

    @Override
    public void showBannerList(List<Banner> banners) {
        entity = banners;
        setViewState(ViewState.LOADED);
    }
}
