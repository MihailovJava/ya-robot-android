package ru.yarobot.android.di;

import android.app.Application;
import android.content.Context;

import ru.yarobot.android.di.components.ApplicationComponent;
import ru.yarobot.android.di.components.DaggerApplicationComponent;
import ru.yarobot.android.di.modules.ApplicationModule;
import ru.yarobot.android.di.modules.BannerInfoModule;
import ru.yarobot.android.di.modules.RestModule;
import ru.yarobot.android.di.modules.SubscribersModule;

/**
 * Created by Nixy on 15.05.2016.
 */
public class YarobotApp extends Application {
    static ApplicationComponent applicationComponent;
    private static Context context;

    public static ApplicationComponent component() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent
                    .builder()
                    .applicationModule(new ApplicationModule(context))
                    .bannerInfoModule(new BannerInfoModule())
                    .restModule(new RestModule())
                    .subscribersModule(new SubscribersModule())
                    .build();
        }
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
