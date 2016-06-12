package ru.yarobot.android.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.yarobot.android.activities.MainActivity;
import ru.yarobot.android.adapters.campaigns.CampaignsListAdapter;
import ru.yarobot.android.di.modules.ApplicationModule;
import ru.yarobot.android.di.modules.IntercatorsModule;
import ru.yarobot.android.di.modules.RestModule;
import ru.yarobot.android.di.modules.SubscribersModule;
import ru.yarobot.android.fragments.BannersListFragment;
import ru.yarobot.android.fragments.CampaignsListFragment;

/**
 * Created by Nixy on 16.05.2016.
 */
@Component(modules = {
        ApplicationModule.class,
        IntercatorsModule.class,
        RestModule.class,
        SubscribersModule.class
})
@Singleton
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(CampaignsListFragment campaignsListFragment);

    void inject(BannersListFragment bannersListFragment);

    void inject(CampaignsListAdapter campaignsListAdapter);
}
