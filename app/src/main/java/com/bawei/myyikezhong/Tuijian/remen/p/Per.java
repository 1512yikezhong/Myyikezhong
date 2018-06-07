package com.bawei.myyikezhong.Tuijian.remen.p;

import com.bawei.myyikezhong.SanRegLogin.reg.RegActivity;
import com.bawei.myyikezhong.Tuijian.remen.m.Mod;
import com.bawei.myyikezhong.Tuijian.remen.v.RementView;

/**
 * Created by 王利博 on 2018/6/5.
 */

public class Per implements PerIm {
    private RementView rementView;
    private Mod mod;

    public Per(RementView rementView) {
        this.rementView = rementView;
         mod = new Mod(rementView);
    }



    /**
     * M层方法
     */
    @Override
    public void login() {
            mod.login();
    }

    @Override
    public void loginvideo(String page) {
        mod.loginvideo(page);
    }
}
