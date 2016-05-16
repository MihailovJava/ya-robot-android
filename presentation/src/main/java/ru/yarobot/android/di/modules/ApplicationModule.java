package ru.yarobot.android.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Base module, that contains singleton instances:
 *
 * @see Context
 //* @see SharedPreferencesHelper
 * @see Singleton
 */
@Module
public class ApplicationModule {

    Context context;


    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return context;
    }

   /* @Provides
    @Singleton
    @Inject
    SharedPreferencesHelper providesSharedPreferencesHelper(Context context) {
        return new SharedPreferencesHelper(PreferenceManager.getDefaultSharedPreferences(context));
    }*/
}
