package com.bawei.myyikezhong.SanRegLogin.reg.p;

import com.bawei.myyikezhong.SanRegLogin.reg.LoginView;
import com.bawei.myyikezhong.SanRegLogin.reg.m.Mod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王利博 on 2018/6/7.
 */

public class Pere implements  Perim{
    private LoginView loginView;
    private Mod mod;

    public Pere(LoginView loginView) {
        this.loginView = loginView;
        mod=new Mod(loginView);
    }

    @Override
    public void login() {
        String getname = loginView.getname();
        String getpass = loginView.getpass();

        Map<String,String> map=new HashMap<>();
        map.put("mobile",getname);
        map.put("password",getpass);

        mod.login(map);

    }
}
