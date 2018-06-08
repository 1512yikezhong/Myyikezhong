package com.bawei.myyikezhong.Tuijian.ui.component;


import com.bawei.myyikezhong.Duanzi.DuanziFragment;
import com.bawei.myyikezhong.Shipin.remen.RemenFragment;
import com.bawei.myyikezhong.Tuijian.ui.GuanZhuFragment;
import com.bawei.myyikezhong.Tuijian.ui.module.HttpModule;
import com.bawei.myyikezhong.Xiangqing.XiangQingActivity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {

    void  inject(GuanZhuFragment guanZhuFragment);

    void inject(DuanziFragment duanziFragment);

    void inject(RemenFragment remenFragment);

    void inject(XiangQingActivity xiangQingActivity);

}
