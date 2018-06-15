package com.bawei.myyikezhong.Tuijian.ui.module;

import com.bawei.myyikezhong.Tuijian.ui.net.DainzanApiServoce;
import com.bawei.myyikezhong.Tuijian.ui.net.DianzanApi;
import com.bawei.myyikezhong.Tuijian.ui.net.DuanziApi;
import com.bawei.myyikezhong.Tuijian.ui.net.DuanziApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.FujinApi;
import com.bawei.myyikezhong.Tuijian.ui.net.FujinApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.GuanzhuApi;
import com.bawei.myyikezhong.Tuijian.ui.net.GuanzhuApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.MuGuanzhuApi;
import com.bawei.myyikezhong.Tuijian.ui.net.MyGuanzhuApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.MyInterceptor;
import com.bawei.myyikezhong.Tuijian.ui.net.MyScApi;
import com.bawei.myyikezhong.Tuijian.ui.net.MyScApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.RemenAoiService;
import com.bawei.myyikezhong.Tuijian.ui.net.RemenApi;
import com.bawei.myyikezhong.Tuijian.ui.net.SousuoApi;
import com.bawei.myyikezhong.Tuijian.ui.net.SousuoApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.SuijiApi;
import com.bawei.myyikezhong.Tuijian.ui.net.SuijiApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.UserjmApi;
import com.bawei.myyikezhong.Tuijian.ui.net.UserjmApiService;
import com.bawei.myyikezhong.Tuijian.ui.net.XqApi;
import com.bawei.myyikezhong.Tuijian.ui.net.XqApiService;

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

    @Provides
    RemenApi provideRemenApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        RemenAoiService remenAoiService = retrofit.create(RemenAoiService.class);
        return  RemenApi.getRemenApi(remenAoiService);
    }

    @Provides
    XqApi provideXqApi(OkHttpClient.Builder builder){



        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        XqApiService xqApiService = retrofit.create(XqApiService.class);

        return XqApi.getXqApi(xqApiService);
    }


    @Provides
    FujinApi provideFujinApi(OkHttpClient.Builder builder){

      //  builder.addInterceptor(new MyInterceptor());

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        FujinApiService fujinApiService = retrofit.create(FujinApiService.class);
        return  FujinApi.getFujinApi(fujinApiService);

    }



    @Provides
    UserjmApi provideUserjmApi(OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        UserjmApiService userjmApiService = retrofit.create(UserjmApiService.class);
        return UserjmApi.getUserjmApi(userjmApiService);

    }

    @Provides
    MuGuanzhuApi provideMuGuanzhuApi(OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        MyGuanzhuApiService myGuanzhuApiService = retrofit.create(MyGuanzhuApiService.class);
        return MuGuanzhuApi.getMuGuanzhuApi(myGuanzhuApiService);

    }

    @Provides
    MyScApi provideMyScApi(OkHttpClient.Builder builder){
       // builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        MyScApiService myScApiService = retrofit.create(MyScApiService.class);
        return MyScApi.getMyScApi(myScApiService);

    }

    @Provides
    SousuoApi provideSousuoApi (OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        SousuoApiService sousuoApiService = retrofit.create(SousuoApiService.class);
        return SousuoApi.getSousuoApi(sousuoApiService);

    }

    @Provides
    SuijiApi provideSuijiApi (OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        SuijiApiService suijiApiService = retrofit.create(SuijiApiService.class);

        return  SuijiApi.getSuijiApi(suijiApiService);
    }


    @Provides
    DianzanApi provideDianzanApi (OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        DainzanApiServoce dainzanApiServoce = retrofit.create(DainzanApiServoce.class);
        return DianzanApi.getDianzanApi(dainzanApiServoce);
    }


}
