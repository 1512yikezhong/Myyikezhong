package com.bawei.myyikezhong.Tuijian.ui.component;


import com.bawei.myyikezhong.Tuijian.ui.GuanZhuFragment;
import com.bawei.myyikezhong.Tuijian.ui.module.HttpModule;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {

    void  inject(GuanZhuFragment guanZhuFragment);
}
