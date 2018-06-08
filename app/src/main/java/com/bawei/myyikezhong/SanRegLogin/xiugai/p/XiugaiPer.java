package com.bawei.myyikezhong.SanRegLogin.xiugai.p;

import com.bawei.myyikezhong.SanRegLogin.xiugai.m.XiugaiMod;
import com.bawei.myyikezhong.SanRegLogin.xiugai.v.XiugaiView;

import java.util.Map;

/**
 * Created by 王利博 on 2018/6/8.
 */

public class XiugaiPer implements XiugaiPerIm {
    private XiugaiView xiugaiView;
    private XiugaiMod xiugaiMod;

    public XiugaiPer(XiugaiView xiugaiView) {
        this.xiugaiView = xiugaiView;
        xiugaiMod=new XiugaiMod(xiugaiView);
    }

    @Override
    public void login(Map<String, String> map) {
            xiugaiMod.login(map);
    }
}
