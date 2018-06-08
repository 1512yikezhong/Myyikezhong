package com.bawei.myyikezhong.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;


/**
 * Created by 王利博 on 2018/6/5.
 */

public class Myapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        MobSDK.init(this);
    }
}
