package ru.yarobot.android.presenter.campaigns;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.yarobot.android.presenter.base.BasePresenterImpl;
import ru.yarobot.android.view.CampaignsListView;
import ru.yarobot.usecase.campaigns.CampaignsInteractor;


@Singleton
public class CampaignsPresenterImpl extends BasePresenterImpl<CampaignsListView> implements CampaignsPresenter {


    private CampaignsInteractor interactor;

    @Inject
    public CampaignsPresenterImpl(CampaignsInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onGetCampaignsList() {
        interactor.getCampaignsList().subscribe(campaignPage -> {
            view.showCampaignsList(campaignPage.getCampaigns());
        });
    }
}
