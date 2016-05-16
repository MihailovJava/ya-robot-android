package ru.yarobot.util;

import retrofit2.Retrofit;

public class RetrofitApiFactory {


    Retrofit retrofit;

    /**
     * Constructor
     * @param retrofit retrofit instance
     */
    public RetrofitApiFactory(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    /**
     * Method for build retrofit REST API service
     * @param serviceClass specific REST API class
     * @param <S> REST API interface
     * @return Retrofit service
     * @see Retrofit
     */
    public <S> S build(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }


}