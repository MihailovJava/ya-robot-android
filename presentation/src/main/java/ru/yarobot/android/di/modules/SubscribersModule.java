package ru.yarobot.android.di.modules;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * Provides base singleton instances for RxJava:
 *
 * @see Schedulers
 * @see Observable.Transformer
 * @see CompositeSubscription
 */
@Module
public class SubscribersModule {
    @Provides
    @Singleton
    @Named("UI_THREAD")
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named("IO_THREAD")
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Inject
    Observable.Transformer provideTransformer(
            @Named("UI_THREAD") Scheduler uiThread,
            @Named("IO_THREAD") Scheduler ioThread
    ) {
        return o -> ((Observable) o).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
