package com.bawei.myyikezhong.SanRegLogin.reg;

import com.bawei.myyikezhong.SanRegLogin.bean.Userbean;

/**
 * Created by 王利博 on 2018/6/7.
 */

public interface LoginView {
    String getname();
    String getpass();
    void getSuccess(Userbean body);
}
