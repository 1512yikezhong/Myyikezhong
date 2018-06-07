package com.bawei.myyikezhong.SanRegLogin.denluzhuce;

import com.bawei.myyikezhong.SanRegLogin.denluzhuce.bean.Studentbean;

/**
 * Created by 王利博 on 2018/6/7.
 */

public interface Iview {
    String getname();
    String getpass();
    void getSuccess(Studentbean body);
}
