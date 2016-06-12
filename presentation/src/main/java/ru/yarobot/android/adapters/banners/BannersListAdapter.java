package ru.yarobot.android.adapters.banners;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.yarobot.android.R;
import ru.yarobot.android.utils.ColorConstans;
import ru.yarobot.entities.model.Banner;

/**
 * Created by Nixy on 05.06.2016.
 */
public class BannersListAdapter extends RecyclerView.Adapter<BannersListAdapter.BannerViewHolder> {


    private List<Banner> campaignList;

    public BannersListAdapter(List<Banner> campaignList) {

        this.campaignList = campaignList;
    }

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BannerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BannerViewHolder holder, int position) {
        holder.bind(campaignList.get(position));
    }

    @Override
    public int getItemCount() {
        return campaignList.size();
    }

    protected class BannerViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.campaigns_title)
        TextView title;

        @Bind(R.id.campaigns_id)
        TextView id;

        @Bind(R.id.campaigns_status)
        TextView status;

        public BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Banner banner) {
            title.setText(banner.getTitle());
            id.setText(String.format("%s : %s",
                    itemView.getContext().getResources().getString(R.string.id),
                    banner.getBannerId())
            );
            String message = banner.getBannerInfo().getStatusMessage();
            status.setText(
                    String.format("%s : %s \n%s",
                            itemView.getContext().getResources().getString(R.string.status),
                            banner.getBannerInfo().getStatus().name().toUpperCase(),
                            message != null ? message : "no message")
            );
            itemView.setBackgroundColor(
                    ColorConstans.getStatusColor(itemView.getContext(),banner.getBannerInfo().getStatus())
            );

        }
    }
}
