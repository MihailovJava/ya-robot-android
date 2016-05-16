package ru.yarobot.android.view;

import ru.yarobot.entities.BannerPositionEntity;

/**
 * Created by Nixy on 16.05.2016.
 */
public interface BannerInfoView extends ViewModel {
    void showBannerInfo(BannerPositionEntity bannerPositionEntity);
}
