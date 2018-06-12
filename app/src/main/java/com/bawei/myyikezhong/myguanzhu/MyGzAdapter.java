package com.bawei.myyikezhong.myguanzhu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.bean.MyGuanzhuBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyGzAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<MyGuanzhuBean.DataBean> list;
  //  private LayoutInflater inflater;

    public MyGzAdapter(Context context, List<MyGuanzhuBean.DataBean> list) {
        this.context = context;
        this.list = list;
     //   inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.myguanzhu_layout, null);

        return new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyGuanzhuBean.DataBean dataBean = list.get(position);

        MyGzAdapter.MyViewHodel myViewHodel= (MyGzAdapter.MyViewHodel) holder;

        //((MyGzAdapter.MyViewHodel) holder).iv.setImageURI(dataBean.getCover());
        myViewHodel.touxiang.setImageURI(dataBean.getIcon());
        myViewHodel.user.setText(dataBean.getNickname());
        myViewHodel.say.setText(dataBean.getMobile());
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
            touxiang = itemView.findViewById(R.id.touxiangx);
             user = itemView.findViewById(R.id.textuser);
            say = itemView.findViewById(R.id.usersay);
            shijian=   itemView.findViewById(R.id.shijainx);

        }
    }


//    private MyGzAdapter.Listener listener;
//
//    public void setlistener( MyGzAdapter.Listener listener){
//        this.listener=listener;
//    }
//
//    interface Listener{
//        //点击事件
//        public void onClick(View view, int position);
//        //长按事件
//        public  void longClick(View view, int position);
//
//    }

}
