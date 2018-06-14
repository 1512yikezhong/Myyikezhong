package com.bawei.myyikezhong.chuangzuo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.myyikezhong.Bianxie.v.BianxieduanziActivity;
import com.bawei.myyikezhong.R;

import java.io.File;

public class MakeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBtnshipin;
    private ImageView mBtnduanzi;
    private String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);
        initView();
    }

    private void initView() {
        mBtnshipin = (ImageView) findViewById(R.id.btnshipin);
        mBtnshipin.setOnClickListener(this);
        mBtnduanzi = (ImageView) findViewById(R.id.btnduanzi);
        mBtnduanzi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btnshipin:
                //点击视频图片调用相机功能
                Toast.makeText(this, "调用照相机 需要真机测试", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setAction("android.media.action.VIDEO_CAPTURE");
                intent.addCategory("android.intent.category.DEFAULT");

                // 保存录像到指定的路径
                File file = new File("/sdcard/video.3pg");
                 Uri uri = Uri.fromFile(file);
                path = file.getPath();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                startActivityForResult(intent, 0);
                break;
            case R.id.btnduanzi:
                //吐司提示
                Toast.makeText(MakeActivity.this,"编写段子",Toast.LENGTH_SHORT).show();
                //跳转到activity  编写段子
                Intent intent1 = new Intent(MakeActivity.this, BianxieduanziActivity.class);
                startActivity(intent1);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "调用照相机完毕", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MakeActivity.this, BofangActivity.class);
        intent.putExtra("url",path);
        startActivity(intent);


    }
}
