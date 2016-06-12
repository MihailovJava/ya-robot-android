package ru.yarobot.android.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.yarobot.android.R;
import ru.yarobot.android.adapters.banners.BannersItemDecorator;
import ru.yarobot.android.adapters.banners.BannersListAdapter;
import ru.yarobot.android.di.YarobotApp;
import ru.yarobot.android.presenter.bus.banner.BannerListCommunicationBus;
import ru.yarobot.android.view.BannerListView;
import ru.yarobot.entities.model.Banner;

/**
 * Created by Nixy on 12.06.2016.
 */
public class BannersListFragment extends Fragment implements BannerListView {


    public static final String CAMPAIGN_ID = "CAMPAIGN_ID";
    @Inject
    BannerListCommunicationBus presenter;

    @Bind(R.id.campaigns_list)
    RecyclerView recyclerView;

    @Bind(R.id.progress)
    ProgressBar progressBar;

    int campaignId;

    public static BannersListFragment newInstance(int campaignId) {
        Bundle args = new Bundle();
        args.putInt(CAMPAIGN_ID,campaignId);
        BannersListFragment fragment = new BannersListFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YarobotApp.newInstance().inject(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            campaignId = arguments.getInt(CAMPAIGN_ID);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.campaigns_list, container, false);
        ButterKnife.bind(this, inflate);

        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attach(this);
        presenter.onGetBannerList(campaignId);

    }



    @Override
    public void showNetworkLostError() {

    }

    @Override
    public void showLoading(boolean flag) {
        progressBar.setVisibility(flag ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void showToastString(String s) {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void showBannerList(List<Banner> banners) {
        recyclerView.setAdapter(new BannersListAdapter(banners));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new BannersItemDecorator());
    }
}
