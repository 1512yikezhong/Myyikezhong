package com.bawei.myyikezhong.SanRegLogin.denluzhuce.p;

import com.bawei.myyikezhong.SanRegLogin.denluzhuce.Iview;
import com.bawei.myyikezhong.SanRegLogin.denluzhuce.m.Modle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王利博 on 2018/6/7.
 */

public class Perer implements  PerIim{
    private Iview iview;
    private Modle modle;

    public Perer(Iview iview) {
        this.iview = iview;
        modle=new Modle(iview);
    }

    @Override
    public void login() {
        String getname = iview.getname();
        String getpass = iview.getpass();
        Map<String,String> map=new HashMap<>();
        map.put("mobile",getname);
        map.put("password",getpass);
        modle.login(map);
    }
}
