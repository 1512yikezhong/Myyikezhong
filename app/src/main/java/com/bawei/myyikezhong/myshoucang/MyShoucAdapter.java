package com.bawei.myyikezhong.myshoucang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyshoucangBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MyShoucAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<MyshoucangBean.DataBean> list;


    public MyShoucAdapter(Context context, List<MyshoucangBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.shoucang_layout, null);

        return new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyshoucangBean.DataBean dataBean = list.get(position);

        MyShoucAdapter.MyViewHodel myViewHodel= (MyShoucAdapter.MyViewHodel) holder;

        myViewHodel.touxiang.setImageURI(dataBean.getUser().getIcon());
        myViewHodel.user.setText(dataBean.getUser().getNickname());
        myViewHodel.say.setText(dataBean.getWorkDesc());
        myViewHodel.shijian.setText(dataBean.getCreateTime());

        String videouri = dataBean.getVideoUrl();

//        holder.jcVideoPlayerStandard.TOOL_BAR_EXIST = false;
//        holder.jcVideoPlayerStandard.setUp(db.getVideouri(),
//                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, " ");
        myViewHodel.shoucang.setUp(videouri,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, " ");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private class MyViewHodel extends RecyclerView.ViewHolder{

        private final SimpleDraweeView touxiang;
        private TextView user;
        private TextView say;
        private TextView shijian;
        private JCVideoPlayerStandard  shoucang;


        public MyViewHodel(View itemView) {
            super(itemView);
            touxiang = itemView.findViewById(R.id.touxiangxy);
            user = itemView.findViewById(R.id.textusery);
            say = itemView.findViewById(R.id.usersayy);
            shijian=   itemView.findViewById(R.id.shijainxy);

            shoucang = itemView.findViewById(R.id.scvideo);

        }
    }
}
