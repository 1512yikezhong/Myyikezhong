package com.bawei.myyikezhong.Tuijian.remen.v;

import com.bawei.myyikezhong.Tuijian.remen.beans.Imgbean;
import com.bawei.myyikezhong.Tuijian.remen.beans.Videobean;

/**
 * Created by 王利博 on 2018/6/5.
 */

public interface RementView {
    void getSuccess(Imgbean body);
    void getVideoSuccess(Videobean body);

    void onBackPressed();
}
