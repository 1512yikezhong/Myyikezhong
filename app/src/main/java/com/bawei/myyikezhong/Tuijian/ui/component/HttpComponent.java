package com.bawei.myyikezhong.Tuijian.ui.component;


import com.bawei.myyikezhong.Duanzi.DuanziFragment;
import com.bawei.myyikezhong.Shipin.fujin.FujinFragment;
import com.bawei.myyikezhong.Shipin.remen.RemenFragment;
import com.bawei.myyikezhong.Tuijian.ui.GuanZhuFragment;
import com.bawei.myyikezhong.Tuijian.ui.module.HttpModule;
import com.bawei.myyikezhong.Xiangqing.XiangQingActivity;
import com.bawei.myyikezhong.myguanzhu.GuanZhuActivity;
import com.bawei.myyikezhong.myshoucang.MyShoucangActivity;
import com.bawei.myyikezhong.sousuo.SousuoActivity;
import com.bawei.myyikezhong.userjm.UserActivity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {

    void  inject(GuanZhuFragment guanZhuFragment);

    void inject(DuanziFragment duanziFragment);

    void inject(RemenFragment remenFragment);

    void inject(XiangQingActivity xiangQingActivity);

    void inject(FujinFragment fujinFragment);

    void  inject(UserActivity userActivity);


    void inject(GuanZhuActivity guanZhuActivity);

    void inject(MyShoucangActivity myShoucangActivity);

    void  inject(SousuoActivity sousuoActivity);

}
