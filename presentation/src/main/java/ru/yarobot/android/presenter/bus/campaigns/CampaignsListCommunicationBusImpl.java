package ru.yarobot.android.presenter.bus.campaigns;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.yarobot.android.presenter.banner.BannerInfoPresenterImpl;
import ru.yarobot.android.presenter.base.BasePresenter;
import ru.yarobot.android.presenter.bus.base.BaseCommunicationBus;
import ru.yarobot.android.presenter.campaigns.CampaignsPresenter;
import ru.yarobot.android.presenter.campaigns.CampaignsPresenterImpl;
import ru.yarobot.android.view.CampaignsListView;
import ru.yarobot.android.view.ViewState;
import ru.yarobot.entities.model.Campaign;


@Singleton
public class CampaignsListCommunicationBusImpl extends BaseCommunicationBus<CampaignsListView> implements CampaignsListView, CampaignsPresenter {

    CampaignsPresenterImpl presenter;

    List<Campaign> entity;

    @Inject
    public CampaignsListCommunicationBusImpl(CampaignsPresenterImpl presenter) {
        this.presenter = presenter;
        presenter.attach(this);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void apply() {
        switch (viewState) {
            case ViewState.LOADED:
                view.showLoading(false);
                view.showCampaignsList(entity);
                break;
            case ViewState.LOADING:
                view.showLoading(true);
                break;
        }
    }


    @Override
    public void showCampaignsList(List<Campaign> campaignList) {
        entity = campaignList;
        setViewState(ViewState.LOADED);
    }

    @Override
    public void onGetCampaignsList() {
        if (viewState != ViewState.LOADED) {
            setViewState(ViewState.LOADING);
            presenter.onGetCampaignsList();
        } else {
            apply();
        }
    }

    @Override
    public void onCampaignSelected(int id) {
        view.onCampaignSelected(id);
    }
}
