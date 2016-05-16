package ru.yarobot.usecase;

import rx.Observable;

/**
 * Created by Nixy on 16.05.2016.
 */
public class BaseInteractor<T> {
    Observable.Transformer<T, T> schedulersTransformer;

    public BaseInteractor(Observable.Transformer schedulersTransformer) {
        this.schedulersTransformer = schedulersTransformer;
    }

    /**
     * Method decorate Observable by adding Schedulers
     *
     * @param observable observable
     * @return observable with scheduler
     * @see rx.Scheduler
     * @see Observable
     */
    protected Observable<T> applySchedulers(Observable<T> observable) {
        return observable.compose(schedulersTransformer);
    }
}