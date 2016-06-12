package ru.yarobot.android.adapters.campaigns;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.yarobot.android.R;

/**
 * Created by Nixy on 12.06.2016.
 */
public class CampaginsItemDecorator extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        outRect.bottom = parent.getContext().getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin_2);
    }

}
