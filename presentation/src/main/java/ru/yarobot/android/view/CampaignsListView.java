package ru.yarobot.android.view;

import java.util.List;

import ru.yarobot.entities.model.Campaign;

/**
 * Created by Nixy on 05.06.2016.
 */
public interface CampaignsListView extends ViewModel {
    void showCampaignsList(List<Campaign> campaignList);

    void onCampaignSelected(int id);
}
