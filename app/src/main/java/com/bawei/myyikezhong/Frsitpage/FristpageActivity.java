package com.bawei.myyikezhong.Frsitpage;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.bawei.myyikezhong.MainActivity;
import com.bawei.myyikezhong.R;
/**
 * li
 * 起始页
 * */
public class FristpageActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY_MILLIS = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fristpage);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                goHome();
            }

        }, SPLASH_DELAY_MILLIS);

//        //倒计时跳转MainActivity
//        Intent intent = new Intent(FristpageActivity.this, MainActivity.class);
//        startActivity(intent);
    }


    private void goHome() {
        Intent intent = new Intent(FristpageActivity.this, MainActivity.class);
        FristpageActivity.this.startActivity(intent);
        FristpageActivity.this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
