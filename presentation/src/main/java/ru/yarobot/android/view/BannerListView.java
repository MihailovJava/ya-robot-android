package ru.yarobot.android.view;

import java.util.List;

import ru.yarobot.entities.BannerPositionEntity;
import ru.yarobot.entities.model.Banner;

/**
 * Created by Nixy on 16.05.2016.
 */
public interface BannerListView extends ViewModel {
    void showBannerList(List<Banner> banners);
}
