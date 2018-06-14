package com.bawei.myyikezhong.chuangzuo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.myyikezhong.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class BofangActivity extends AppCompatActivity implements View.OnClickListener {

    private JCVideoPlayerStandard mVideoplayer;
    /**
     * 下一步
     */
    private Button btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bofang);
        initView();

        String url = getIntent().getStringExtra("url");
        //视频
        mVideoplayer.TOOL_BAR_EXIST = false;
        mVideoplayer.setUp(url,
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, " ");
        // Glide.with(context.getApplicationContext()).load( db.getBimageuri() ) .into(   holder.jcVideoPlayerStandard.thumbImageView);
        mVideoplayer.widthRatio = 4;//播放比例
        mVideoplayer.heightRatio = 3;
    }

    private void initView() {
        mVideoplayer = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        btnnext = (Button) findViewById(R.id.btn_next);
        btnnext.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        this.onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    /**
     * button  按钮的下一步
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_next:
                Toast.makeText(this,"下一步进行发布 上传接口",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
