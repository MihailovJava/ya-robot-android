package ru.yarobot.android.view;


import android.content.Context;

/**
 * All Views(MVP) should implement this interface
 */
public interface ViewModel {
    Context getContext();

    void showNetworkLostError();

    void showLoading(boolean flag);

    void showToastString(String s);

    void onViewDestroy();
}
