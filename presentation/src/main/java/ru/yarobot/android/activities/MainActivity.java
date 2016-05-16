package ru.yarobot.android.activities;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.yarobot.android.R;
import ru.yarobot.android.di.YarobotApp;
import ru.yarobot.android.presenter.bus.banner.BannerInfoCommunicationBus;
import ru.yarobot.android.view.BannerInfoView;
import ru.yarobot.entities.BannerPositionEntity;

public class MainActivity extends AppCompatActivity implements BannerInfoView {

    @Inject
    BannerInfoCommunicationBus bus;

    @Bind(R.id.progress)
    ProgressBar progressBar;

    @Bind(R.id.banner_piechart)
    PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        YarobotApp.component().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.attach(this);
        bus.onGetBannerInfo();
    }

    @Override
    public void showBannerInfo(BannerPositionEntity bannerPositionEntity) {
        Log.d("INFO in search", String.valueOf(bannerPositionEntity.getCountInSearch()));
        Log.d("INFO not in search", String.valueOf(bannerPositionEntity.getCountNotInSearch()));

        mChart.setUsePercentValues(true);
        mChart.setDescription("");
        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

        //    tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

        //   mChart.setCenterTextTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
        mChart.setCenterText("Banner info");

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        //   mChart.setOnChartValueSelectedListener(this);

        setData(bannerPositionEntity);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
    }

    private void setData(BannerPositionEntity bannerPositionEntity) {

        ArrayList<Entry> yVals1 = new ArrayList<>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.

        String[] description = new String[]{"In search", "Not in search"};

        yVals1.add(new Entry(bannerPositionEntity.getCountInSearch(), 0));
        yVals1.add(new Entry(bannerPositionEntity.getCountNotInSearch(), 1));


        ArrayList<String> xVals = new ArrayList<>();

        xVals.add(description[0]);
        xVals.add(description[1]);

        PieDataSet dataSet = new PieDataSet(yVals1, "Banner info");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();


         colors.add(Color.parseColor("#76FF03"));
         colors.add(Color.parseColor("#F4511E"));



        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bus.detach();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showNetworkLostError() {

    }

    @Override
    public void showLoading(boolean flag) {
        progressBar.setVisibility(flag ? View.VISIBLE : View.GONE);

    }

    @Override
    public void showToastString(String s) {

    }

    @Override
    public void onViewDestroy() {

    }
}
