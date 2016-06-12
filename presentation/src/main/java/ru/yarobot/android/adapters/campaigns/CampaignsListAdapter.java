package ru.yarobot.android.adapters.campaigns;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.yarobot.android.R;
import ru.yarobot.android.di.YarobotApp;
import ru.yarobot.android.presenter.bus.campaigns.CampaignsListCommunicationBusImpl;
import ru.yarobot.android.utils.ColorConstans;
import ru.yarobot.entities.model.Campaign;

/**
 * Created by Nixy on 05.06.2016.
 */
public class CampaignsListAdapter extends RecyclerView.Adapter<CampaignsListAdapter.CampaignViewHolder> {

    @Inject
    CampaignsListCommunicationBusImpl presenter;


    private List<Campaign> campaignList;

    public CampaignsListAdapter(List<Campaign> campaignList) {
        this.campaignList = campaignList;
        YarobotApp.component().inject(this);
    }

    @Override
    public CampaignViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CampaignViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CampaignViewHolder holder, int position) {
        holder.bind(campaignList.get(position));
    }

    @Override
    public int getItemCount() {
        return campaignList.size();
    }

    protected class CampaignViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.campaigns_title)
        TextView title;

        @Bind(R.id.campaigns_id)
        TextView id;

        @Bind(R.id.campaigns_status)
        TextView status;

        public CampaignViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Campaign campaign) {
            title.setText(campaign.getName());
            id.setText(String.format("%s : %s",
                    itemView.getContext().getResources().getString(R.string.id),
                    campaign.getCampaignID())
            );
            String message = campaign.getCampaignInfo().getStatusMessage();
            status.setText(
                    String.format("%s : %s \n%s",
                            itemView.getContext().getResources().getString(R.string.status),
                            campaign.getCampaignInfo().getStatus().name().toUpperCase(),
                            message != null ? message : "no message")
            );
            itemView.setBackgroundColor(
                    ColorConstans.getStatusColor(itemView.getContext(),campaign.getCampaignInfo().getStatus())
            );
            itemView.setOnClickListener(v -> {
                presenter.onCampaignSelected(campaign.getCampaignID());
            });
        }
    }
}
