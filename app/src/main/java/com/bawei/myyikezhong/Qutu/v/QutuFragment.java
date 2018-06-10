package com.bawei.myyikezhong.Qutu.v;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myyikezhong.Qutu.bean.Qutubean;
import com.bawei.myyikezhong.Qutu.p.QuPerer;
import com.bawei.myyikezhong.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王利博 on 2018/6/5.
 */
//uid=71&token=C9E316BA0DBF0A4926320921E70C112D

public class QutuFragment extends Fragment implements QuView, View.OnClickListener {
    final String uid = "71";
    final String token = "C9E316BA0DBF0A4926320921E70C112D";
    private Map<String, String> map = new HashMap<>();
    private View view;
    private SimpleDraweeView mImghead;
    /**
     * name
     */
    private TextView mTvname;
    /**
     * time
     */
    private TextView mTvtime;
    private TextView mTvbody;
    private SimpleDraweeView mImgsdv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.layout_qutu, container, false);
        map.put("uid", uid);
        map.put("token", token);
        new QuPerer(this).login(map);
        initView(view);
        return view;
    }

    @Override
    public void getSuccess(Qutubean body) {
      //  Log.e("sssss", body.getMsg());
        //加载头像
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(body.getData().getUser().getIcon())
                //播放gif 图片
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();

        mImghead.setController(controller);
        //加载显示图片
        AbstractDraweeController controller1 = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(body.getData().getWorksEntities().get(0).getCover())
                //播放gif 图片
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();

        mImgsdv.setController(controller1);
        mTvname.setText(body.getData().getUser().getNickname());
        mTvtime.setText(body.getData().getWorksEntities().get(0).getCreateTime());
        mTvbody.setText(body.getData().getWorksEntities().get(0).getCommentNum()+"");
    }

    private void initView(View view) {
        mImghead = (SimpleDraweeView) view.findViewById(R.id.imghead);
        mImghead.setOnClickListener(this);
        mTvname = (TextView) view.findViewById(R.id.tvname);
        mTvtime = (TextView) view.findViewById(R.id.tvtime);
        mTvbody = (TextView) view.findViewById(R.id.tvbody);
        mImgsdv = (SimpleDraweeView) view.findViewById(R.id.imgsdv);
    }

    /**
     * 点击头像显示个人信息
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imghead:
                Toast.makeText(getActivity(),"点击头像显示个人信息",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
