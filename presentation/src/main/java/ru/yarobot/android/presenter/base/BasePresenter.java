package ru.yarobot.android.presenter.base;

import android.os.Bundle;

import ru.yarobot.android.view.ViewModel;


/**
 * All Presenters should implement this interface
 */
public interface BasePresenter<T extends ViewModel> {

    /**
     * Attach ViewModel to presenter
     *
     * @param view viewModel attached to Presenter
     */
    void attach(T view);

    /**
     * Detach ViewModel from presenter
     *
     * @see ViewModel
     */
    void detach();


    /**
     * Clean all resources here
     */
    void onDestroy();

    /**
     * init Presenter and restore it here
     */
    void onCreate(Bundle bundle);


    /**
     * @param bundle save all data to be restored here
     */
    void onSaveInstance(Bundle bundle);

    void onNetworkErrorException();
}
