package ru.yarobot.android.di.modules;

import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Module, that provides base classes for Network connections:
 * Recreated after clear account
 *
 * @see Retrofit
 * @see OkHttpClient

 */
@Module
public class RestModule {

    @Provides
    @Inject
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client, @Named("BASE_URL") HttpUrl baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client);
        return builder.build();
    }


    @Provides
    @Inject
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Inject
    @Singleton
    public OkHttpClient provideClient(  HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient okHttpClient = null;

        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .build();
        try {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                  //  .connectionSpecs(Collections.singletonList(spec))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return okHttpClient;
    }


    @Provides
    @Named("BASE_URL")
    @Inject
    @Singleton
    HttpUrl provideBaseUrl( ) {
       /* String baseUrl = "";
        String baseDomain = sharedPreferencesHelper.getBaseDomain();
        String subDomain = sharedPreferencesHelper.getSubDomain();
        return HttpUrl.parse(baseUrl
                .concat(AuthUtils.HTTPS)
                .concat(subDomain)
                .concat(TextUtils.isEmpty(subDomain) ? "" : ".")
                .concat(baseDomain));*/
        return HttpUrl.parse("http://178.33.182.149/");
    }


}
