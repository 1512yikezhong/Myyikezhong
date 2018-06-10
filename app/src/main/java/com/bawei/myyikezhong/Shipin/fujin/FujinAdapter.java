package com.bawei.myyikezhong.Shipin.fujin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.bean.FujinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class FujinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<FujinBean.DataBean> list;
    private LayoutInflater inflater;


    public FujinAdapter(Context context, List<FujinBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fujin_nishuo, parent, false);
        return new FujinAdapter.MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {


        FujinBean.DataBean dataBean = list.get(position);

        FujinAdapter.MyViewHodel myViewHodel= (MyViewHodel) holder;

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

    public  void  refresh(List<FujinBean.DataBean> templist){

        //清楚原先集合
        this.list.clear();
        this.list.addAll(templist);
        notifyDataSetChanged();
    }

    public void  loadMore(List<FujinBean.DataBean> templist){

        this.list.addAll(templist);
        notifyDataSetChanged();
    }

    public  int getListNum(){
        return list.size();

    }

    private FujinAdapter.Listener listener;

    public void setlistener( FujinAdapter.Listener listener){
        this.listener=listener;
    }

    interface Listener{
        //点击事件
        public void onClick(View view, int position);
        //长按事件
        public  void longClick(View view, int position);

    }

}
