package com.bawei.myyikezhong.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;


/**
 * Created by 王利博 on 2018/6/5.
 */

public class Myapp extends Application {
    {
        // PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setQQZone("1106791289", "aIWIYvo71fEGzrxg");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        MobSDK.init(this);
        UMConfigure.init(this,"5ae065ce8f4a9d0f3500012c"
                ,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
    }
}
