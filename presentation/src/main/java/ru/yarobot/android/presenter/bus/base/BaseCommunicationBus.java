package ru.yarobot.android.presenter.bus.base;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayDeque;
import java.util.Queue;

import ru.yarobot.android.presenter.base.BasePresenter;
import ru.yarobot.android.presenter.base.BasePresenterImpl;
import ru.yarobot.android.view.ViewModel;
import ru.yarobot.android.view.ViewState;

public abstract class BaseCommunicationBus<T extends ViewModel>  extends BasePresenterImpl<T> implements ViewModel {
    protected int viewState = ViewState.DEFAULT;
    private Queue<String> strings = new ArrayDeque<>();

    @Override
    public void attach(T view) {
        this.view = view;
        apply();
        String s;
        while ((s = strings.poll()) != null) {
            view.showToastString(s);
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        getPresenter().onCreate(bundle);
    }

    public void onSaveInstance(Bundle bundle) {
        getPresenter().onSaveInstance(bundle);
    }

    @Override
    public void onDestroy() {
        getPresenter().onDestroy();
        super.onDestroy();
    }

    @Override
    public void showNetworkLostError() {
        view.showNetworkLostError();
    }

    public Context getContext() {
        return view != null ? view.getContext() : null;
    }

    public abstract BasePresenter getPresenter();

    public void setViewState(int viewState) {
        this.viewState = viewState;
        apply();
    }

    public abstract void apply();

    @Override
    public void showLoading(boolean flag) {
        if (view != null) {
            view.showLoading(flag);
        }
    }

    @Override
    public void showToastString(String s) {
        if (view == null) {
            strings.add(s);
        } else {
            view.showToastString(s);
        }
    }

    @Override
    public void onViewDestroy() {

    }
}