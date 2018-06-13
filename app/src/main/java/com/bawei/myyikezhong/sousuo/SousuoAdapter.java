package com.bawei.myyikezhong.sousuo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.bean.SousuoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class SousuoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;
    private List<SousuoBean.DataBean> list;

    public SousuoAdapter(Context context, List<SousuoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sousuo_layout, null);

        return new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        SousuoBean.DataBean dataBean = list.get(position);

        SousuoAdapter.MyViewHodel myViewHodel= (SousuoAdapter.MyViewHodel) holder;

        myViewHodel.touxiang.setImageURI(dataBean.getIcon());
        myViewHodel.user.setText(dataBean.getNickname());
        myViewHodel.say.setText(dataBean.getUsername());
        myViewHodel.shijian.setText(dataBean.getCreatetime());


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


        public MyViewHodel(View itemView) {
            super(itemView);
            touxiang = itemView.findViewById(R.id.touxiangxs);
            user = itemView.findViewById(R.id.textusers);
            say = itemView.findViewById(R.id.usersays);
            shijian=   itemView.findViewById(R.id.shijainxs);



        }
    }
}
