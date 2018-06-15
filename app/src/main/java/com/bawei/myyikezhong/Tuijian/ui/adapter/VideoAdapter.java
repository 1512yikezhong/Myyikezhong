package com.bawei.myyikezhong.Tuijian.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.Tuijian.ui.bean.VideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<VideoBean.DataBean> data;
    private LayoutInflater inflater;
    private boolean iftrue;




    public VideoAdapter(Context context, List<VideoBean.DataBean> data) {
        this.context = context;
        this.data = data;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.vedio_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        final VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
        VideoBean.DataBean dataBean = data.get(position);
        videoViewHolder.imgtou.setImageURI(dataBean.getProfile_image());
        videoViewHolder.text1.setText(dataBean.getText());
        videoViewHolder.text2.setText(dataBean.getName());
//        videoViewHolder.videoView.setVideoPath(dataBean.getVideouri());
//        videoViewHolder.videoView.start();
        String videouri = dataBean.getVideouri();

        videoViewHolder.dainzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Toast.makeText(context,"YIGUANZH",Toast.LENGTH_LONG).show();

                listener.onClick(v,position);


                if (iftrue){
                    iftrue=false;
                    videoViewHolder.dainzan.setImageResource(R.mipmap.raw_1499933216);
                }else{
                    iftrue=true;
                    videoViewHolder.dainzan.setImageResource(R.drawable.dianxin);
                }
            }
        });

//        videoViewHolder.dainzan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        videoViewHolder.mVideoplayer.setUp(videouri, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "视频播放");

        /*Glide.with(context.getApplicationContext()).load( dataBean.getBimageuri() ) .into(videoViewHolder.mVideoplayer.thumbImageView);
        videoViewHolder.mVideoplayer.widthRatio = 4;//播放比例
        videoViewHolder.mVideoplayer.heightRatio = 3;*/
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView imgtou;
        private final TextView text2;
        private final TextView text1;
        public JCVideoPlayerSimple mVideoplayer;
        public ImageView dainzan;
       // private final VideoView videoView;

        public VideoViewHolder(View itemView) {
            super(itemView);
            imgtou = itemView.findViewById(R.id.imgtou);
            text2 = itemView.findViewById(R.id.text2);
            text1 = itemView.findViewById(R.id.text1);
            //videoView = itemView.findViewById(R.id.surface_view);
            mVideoplayer = itemView.findViewById(R.id.videoplayer);

            dainzan = itemView.findViewById(R.id.dianzan);


        }
    }


    public void setData(List<VideoBean.DataBean> list) {

        if (data != null) {

            data.clear();
            data.addAll(list);
            notifyDataSetChanged();

        }
    }

    private VideoAdapter.Listener listener;

    public void setlistener( VideoAdapter.Listener listener){
        this.listener=listener;
    }

    public interface Listener{
        //点击事件
        public void onClick(View view, int position);
        //长按事件
        public  void longClick(View view, int position);

    }


}