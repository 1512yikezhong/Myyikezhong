package com.bawei.myyikezhong.Tuijian.ui.module;

import com.bawei.myyikezhong.Tuijian.ui.net.DuanziApi;
import com.bawei.myyikezhong.Tuijian.ui.net.DuanziApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.GuanzhuApi;
import com.bawei.myyikezhong.Tuijian.ui.net.GuanzhuApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    GuanzhuApi provideGuanzhuApi(OkHttpClient.Builder builder){

        GuanzhuApiService guanzhuApiService = new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GuanzhuApiService.class);
        return GuanzhuApi.getGuanzhuApi(guanzhuApiService);
    }


    @Provides
    DuanziApi provideDuanziApi(OkHttpClient.Builder builder){

        builder.addInterceptor(new MyInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();


        DuanziApiService duanziApiService = retrofit.create(DuanziApiService.class);

        return DuanziApi.getDuanziApi(duanziApiService);

    }
}
