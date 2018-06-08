package com.bawei.myyikezhong.Shipin.remen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RemenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<HotBean.DataBean> list;
    private LayoutInflater inflater;

    public RemenAdapter(Context context, List<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.remen_ada, parent, false);
        return new MyViewHodel(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        HotBean.DataBean dataBean = list.get(position);

        MyViewHodel myViewHodel= (MyViewHodel) holder;

        ((MyViewHodel) holder).iv.setImageURI(dataBean.getCover());

        myViewHodel.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private class MyViewHodel extends RecyclerView.ViewHolder{

        private final SimpleDraweeView iv;

        public MyViewHodel(View itemView) {

            super(itemView);
            iv = itemView.findViewById(R.id.hotimg);

        }
    }

    public  void  refresh(List<HotBean.DataBean> templist){

        //清楚原先集合
        this.list.clear();
        this.list.addAll(templist);
        notifyDataSetChanged();
    }

    public void  loadMore(List<HotBean.DataBean> templist){

        this.list.addAll(templist);
        notifyDataSetChanged();
    }

    public  int getListNum(){
        return list.size();

    }

    private Listener listener;

    public void setlistener( Listener listener){
        this.listener=listener;
    }

    interface Listener{
        //点击事件
        public void onClick(View view, int position);
        //长按事件
        public  void longClick(View view, int position);

    }
}
