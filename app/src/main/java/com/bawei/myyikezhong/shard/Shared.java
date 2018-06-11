package com.bawei.myyikezhong.shard;

import android.app.Activity;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by 王利博 on 2018/6/11.
 */

public class Shared {
    private Activity activity;
    private String url;

    public Shared(Activity activity, String url) {
        this.activity = activity;
        this.url = url;
    }

    public void getshard( ){
        UMWeb umWeb = new UMWeb(url);
        new ShareAction(activity).withMedia(umWeb)
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener).open();
    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }
        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(activity,"成功了",Toast.LENGTH_LONG).show();
        }
        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(activity,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }
        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(activity,"取消了",Toast.LENGTH_LONG).show();
        }
    };
}
