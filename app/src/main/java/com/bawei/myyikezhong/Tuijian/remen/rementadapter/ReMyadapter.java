package com.bawei.myyikezhong.Tuijian.remen.rementadapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.remen.beans.Videobean;
import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 王利博 on 2018/6/6.
 */

public class ReMyadapter extends RecyclerView.Adapter<ReMyadapter.Myviewholder> {
    private List<Videobean.DataBean> data;
    private   Context context;

    public ReMyadapter(List<Videobean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;

    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_video_item, parent, false);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myviewholder holder, int position) {
        Videobean.DataBean db = data.get(position);
        //头像
        if (db.getProfile_image()!=null&!"".equals(db.getProfile_image()) ){
            holder.ivsdv.setImageURI(db.getProfile_image());
        }

        //名字
        holder.name.setText(db.getName());
        //时间
        holder.time.setText(db.getPasstime());
        //内容
        if(db.getText()!=null&!"".equals(db.getText())) {
            holder.tv.setText(db.getText());
        }else{
            holder.tv.setText("暂无内容！");

        }
            //视频
        holder.jcVideoPlayerStandard.TOOL_BAR_EXIST = false;
        holder.jcVideoPlayerStandard.setUp(db.getVideouri(),
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, " ");
        Glide.with(context.getApplicationContext()).load( db.getBimageuri() ) .into(   holder.jcVideoPlayerStandard.thumbImageView);
        holder.jcVideoPlayerStandard.widthRatio = 4;//播放比例
        holder.jcVideoPlayerStandard.heightRatio = 3;


     //   Log.e("aaaaqq",db.getLove()+db.getHate()+db.getComment()+db.getBookmark());
        //点赞
        if(db.getLove()!=null&!"".equals(db.getLove())){
             holder.love.setText(db.getLove());
        } else{
            holder.love.setText("0");
        }
        if(db.getHate()!=null&!"".equals(db.getHate())){
            holder.xing.setText(db.getHate());
        } else{
            holder.xing.setText("0");
        }
        //分享
        if(db.getComment()!=null&!"".equals(db.getComment())){
            holder.shard.setText(db.getComment());
        } else{
            holder.shard.setText("0");
        }
        /**
         * 分享   第三方
         */
        holder.shard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //分享

                
            }
        });


        if(db.getBookmark()!=null&!"".equals(db.getBookmark())){
            holder.ping.setText(db.getBookmark());
        } else {
            holder.ping.setText("0");
        }




    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        public SimpleDraweeView ivsdv;
        public TextView name;
        public  TextView time;
        public TextView tv;
        public JCVideoPlayerStandard jcVideoPlayerStandard;
        public  TextView love;
        public  TextView xing;
        public  TextView shard;
        public  TextView ping;
        public Myviewholder(View itemView) {
            super(itemView);
            ivsdv=itemView.findViewById(R.id.ivsdv);
            name=itemView.findViewById(R.id.name);
            time=itemView.findViewById(R.id.time);
            tv=itemView.findViewById(R.id.tv1);
            jcVideoPlayerStandard =  itemView.findViewById(R.id.videoplayer);
            love=itemView.findViewById(R.id.love);
            xing=itemView.findViewById(R.id.xing);
            shard=itemView.findViewById(R.id.shard);
            ping=itemView.findViewById(R.id.ping);
        }
    }



}
