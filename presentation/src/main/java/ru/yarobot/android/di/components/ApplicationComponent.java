package ru.yarobot.android.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.yarobot.android.activities.MainActivity;
import ru.yarobot.android.di.modules.ApplicationModule;
import ru.yarobot.android.di.modules.BannerInfoModule;
import ru.yarobot.android.di.modules.RestModule;
import ru.yarobot.android.di.modules.SubscribersModule;

/**
 * Created by Nixy on 16.05.2016.
 */
@Component(modules = {
        ApplicationModule.class,
        BannerInfoModule.class,
        RestModule.class,
        SubscribersModule.class
})
@Singleton
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
