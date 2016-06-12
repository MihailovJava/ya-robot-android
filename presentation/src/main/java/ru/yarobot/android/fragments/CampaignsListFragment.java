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
import ru.yarobot.android.adapters.campaigns.CampaginsItemDecorator;
import ru.yarobot.android.adapters.campaigns.CampaignsListAdapter;
import ru.yarobot.android.di.YarobotApp;
import ru.yarobot.android.presenter.bus.campaigns.CampaignsListCommunicationBusImpl;
import ru.yarobot.android.view.CampaignsListView;
import ru.yarobot.entities.model.Campaign;

/**
 * Created by Nixy on 05.06.2016.
 */
public class CampaignsListFragment extends Fragment implements CampaignsListView {


    @Inject
    CampaignsListCommunicationBusImpl presenter;

    @Bind(R.id.campaigns_list)
    RecyclerView recyclerView;

    @Bind(R.id.progress)
    ProgressBar progressBar;

    public static CampaignsListFragment newInstance() {
        Bundle args = new Bundle();
        CampaignsListFragment fragment = new CampaignsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YarobotApp.component().inject(this);
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
        presenter.onGetCampaignsList();
    }

    @Override
    public void showCampaignsList(List<Campaign> campaignList) {
        recyclerView.setAdapter(new CampaignsListAdapter(campaignList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new CampaginsItemDecorator());
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
    public void onCampaignSelected(int id) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,BannersListFragment.newInstance(id))
                .addToBackStack(null)
                .commit();
    }
}
