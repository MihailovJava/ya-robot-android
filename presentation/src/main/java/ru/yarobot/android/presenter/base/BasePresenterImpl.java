package ru.yarobot.android.presenter.base;

import android.os.Bundle;



import javax.inject.Inject;

import ru.yarobot.android.view.ViewModel;
import rx.subscriptions.CompositeSubscription;

/**
 * Implementation of Base Presenter
 *
 * @see ViewModel
 * @see CompositeSubscription
 */
public class BasePresenterImpl<T extends ViewModel> implements BasePresenter<T> {

    @Inject
    CompositeSubscription subscription;

    protected T view;

    @Override
    public void attach(T view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public void onDestroy() {
        detach();
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void onCreate(Bundle bundle) {

    }

    @Override
    public void onSaveInstance(Bundle bundle) {

    }

    @Override
    public void onNetworkErrorException() {
        view.showNetworkLostError();
    }
}
