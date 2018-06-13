package com.bawei.myyikezhong.sousuo;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.bean.SuijiBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class SuijiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<SuijiBean.DataBean> list;


    public SuijiAdapter(Context context, List<SuijiBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.suiji_layout, null);

        return  new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SuijiBean.DataBean dataBean = list.get(position);

        SuijiAdapter.MyViewHodel myViewHodel= (SuijiAdapter.MyViewHodel) holder;

        myViewHodel.touxiang.setImageURI((Uri) dataBean.getIcon());
        myViewHodel.user.setText(dataBean.getMobile());
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
            touxiang = itemView.findViewById(R.id.touxiangxj);
            user = itemView.findViewById(R.id.textuserj);
            say = itemView.findViewById(R.id.usersayj);
            shijian=   itemView.findViewById(R.id.shijainxj);



        }
    }

}
