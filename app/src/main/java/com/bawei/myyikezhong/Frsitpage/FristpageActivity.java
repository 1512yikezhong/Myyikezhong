package com.bawei.myyikezhong.Frsitpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.myyikezhong.MainActivity;
import com.bawei.myyikezhong.R;

public class FristpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fristpage);
        //倒计时跳转MainActivity
        Intent intent = new Intent(FristpageActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
