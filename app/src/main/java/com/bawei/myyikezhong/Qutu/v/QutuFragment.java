package com.bawei.myyikezhong.Qutu.v;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myyikezhong.Qutu.bean.Qutubean;
import com.bawei.myyikezhong.Qutu.p.QuPerer;
import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.shard.Shared;
import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 王利博 on 2018/6/5.
 */
//uid=71&token=C9E316BA0DBF0A4926320921E70C112D

public class QutuFragment extends Fragment implements QuView, View.OnClickListener, UploadUtil.OnUploadProcessListener {
    final String uid = "71";
    final String token = "C9E316BA0DBF0A4926320921E70C112D";
    private Map<String, String> map = new HashMap<>();
    private View view;
    private SimpleDraweeView mImghead;


    private static final int PHOTO_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;
    private static final int PHOTO_CLIP = 3;
    private static final int UPLOAD_INIT_PROCESS = 4;//上传初始化
    protected static final int UPLOAD_FILE_DONE = 2;//上传中
    private static final int UPLOAD_IN_PROCESS = 5;//上传文件响应
    private ProgressDialog pd;
    private File filepath;//返回的文件地址
    View inflate;
    private String set = "https://www.zhaoapi.cn/file/upload?uid=13681";
    /**
     * name
     */
    private TextView mTvname;
    /**
     * time
     */
    private TextView mTvtime;
    private TextView mTvbody;
    private SimpleDraweeView mImgsdv;
    private ImageView mBtIm;
    private String imgurl;
    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_qutu, container, false);
        map.put("uid", uid);
        map.put("token", token);
        new QuPerer(this).login(map);
        initView(view);
        return view;
    }

    @Override
    public void getSuccess(Qutubean body) {
        //  Log.e("sssss", body.getMsg());
        imgurl = body.getData().getWorksEntities().get(0).getCover();
        //加载头像
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(body.getData().getUser().getIcon())
                //播放gif 图片
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();

        mImghead.setController(controller);
        //加载显示图片
        AbstractDraweeController controller1 = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(body.getData().getWorksEntities().get(0).getCover())
                //播放gif 图片
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();

        mImgsdv.setController(controller1);
        mTvname.setText(body.getData().getUser().getNickname());
        mTvtime.setText(body.getData().getWorksEntities().get(0).getCreateTime());
        mTvbody.setText(body.getData().getWorksEntities().get(0).getCommentNum() + "");
    }

    private void initView(View view) {
        mImghead = (SimpleDraweeView) view.findViewById(R.id.imghead);
        mImghead.setOnClickListener(this);
        mTvname = (TextView) view.findViewById(R.id.tvname);
        mTvtime = (TextView) view.findViewById(R.id.tvtime);
        mTvbody = (TextView) view.findViewById(R.id.tvbody);
        mImgsdv = (SimpleDraweeView) view.findViewById(R.id.imgsdv);
        mBtIm = (ImageView) view.findViewById(R.id.bt_im);
        mBtIm.setOnClickListener(this);
        mImageView = (ImageView) view.findViewById(R.id.img);
        mImageView.setOnClickListener(this);
    }

    /**
     * 点击头像显示个人信息
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imghead:
                Toast.makeText(getActivity(), "点击头像上传头像", Toast.LENGTH_SHORT).show();

                break;
            case R.id.bt_im:
                Log.e("qazxsw", "点击了飞享按钮");
                new Shared((Activity) getContext(), imgurl);
                break;
            case R.id.img:
                method1();
                break;
        }
    }

    private void method1() {
        AlertDialog builder = new AlertDialog.Builder(getActivity())
                .setTitle("选择头像")
                .setPositiveButton("相机", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getCamera();

                    }
                })
                .setNegativeButton("相册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPhoto();

                    }
                })
                .show();
    }

    /**
     * 调用相机的方法
     */
    private void getPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        startActivityForResult(intent, PHOTO_REQUEST);
    }


    //调用你相册的方法
    private void getCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 下面这句指定调用相机拍照后的照片存储的路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                Environment.getExternalStorageDirectory(), "hand.jpg")));
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    /**
     * 系统相机
     *
     * @param uri
     */
    private void photoClip(Uri uri) {
        // 调用系统中自带的图片剪裁
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_CLIP);
    }

    private void toUploadFile() {
        pd = ProgressDialog.show(getActivity(), "", "正在上传文件...");
        pd.show();
        String fileKey = "avatarFile";
        UploadUtil uploadUtil = UploadUtil.getInstance();
        uploadUtil.setOnUploadProcessListener(this); //设置监听器监听上传状态

        Map<String, String> params = new HashMap<String, String>();//上传map对象
        params.put("userId", "");
        uploadUtil.uploadFile(filepath, fileKey, "上传头像的地址", params);
        Toast.makeText(getActivity(), "上传成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUploadDone(int responseCode, String message) {

        pd.dismiss();
        Message msg = Message.obtain();
        msg.what = UPLOAD_FILE_DONE;
        msg.arg1 = responseCode;
        msg.obj = message;
    }

    @Override
    public void onUploadProcess(int uploadSize) {

        //上传中
        Message msg = Message.obtain();
        msg.what = UPLOAD_IN_PROCESS;
        msg.arg1 = uploadSize;
    }

    @Override
    public void initUpload(int fileSize) {

        //准备上传
        Message msg = Message.obtain();
        msg.what = UPLOAD_INIT_PROCESS;
        msg.arg1 = fileSize;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_REQUEST:
                switch (resultCode) {
                    case -1://-1表示拍照成功
                        File file = new File(Environment.getExternalStorageDirectory()
                                + "/hand.jpg");//保存图片
                        if (file.exists()) {
                            //对相机拍照照片进行裁剪
                            photoClip(Uri.fromFile(file));
                        }
                }
                break;

            case PHOTO_REQUEST://从相册取
                if (data != null) {
                    Uri uri = data.getData();
                    //对相册取出照片进行裁剪
                    photoClip(uri);

                }
                break;
            case PHOTO_CLIP:
                //完成
                if (data != null) {

                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        Bitmap photo = extras.getParcelable("data");
                        try {
                            //获得图片路径
                            filepath = UploadUtil.saveFile(photo, Environment.getExternalStorageDirectory().toString(), "hand.jpg");
                            //上传照片
                            toUploadFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //上传完成将照片写入imageview与用户进行交互
                        mImageView.setImageBitmap(photo);
                     //   Glide.with(getContext()).load(photo).into(mImghead);
                        uploadPic(set, filepath, "hand.jpg");
                    }
                }
                break;
        }
    }

    public static void uploadPic(String url, File file, String fileName) {
        //创建OkHttpClient请求对象

        OkHttpClient okHttpClient = new OkHttpClient();
        //创建RequestBody 封装file参数
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        //创建RequestBody 设置类型等
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", fileName, fileBody).build();
        //创建Request
        Request request = new Request.Builder().url(url).post(requestBody).build();

        //得到Call
        Call call = okHttpClient.newCall(request);
        //执行请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("失败", "onResponse: 很不高兴");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //上传成功回调 目前不需要处理
                Log.d("成功", "onResponse: 开心");
            }
        });

    }
}
