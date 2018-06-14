package com.bawei.myyikezhong.Bianxie.v;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myyikezhong.Bianxie.bean.Duanzibean;
import com.bawei.myyikezhong.Bianxie.fx.ShardActivity;
import com.bawei.myyikezhong.Bianxie.p.DuanPer;
import com.bawei.myyikezhong.R;
import com.bawei.myyikezhong.chuangzuo.MakeActivity;
import com.hdl.mricheditor.bean.CamaraRequestCode;
import com.hdl.mricheditor.bean.EditorBean;
import com.hdl.mricheditor.view.MRichEditor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BianxieduanziActivity extends AppCompatActivity implements View.OnClickListener,DuanView {

    /**
     * 取消
     */
    private TextView mQuxiao;
    /**
     * 发表
     */
    private TextView mFabiao;
    private MRichEditor editor;
    private final String token="1E858E51388616C08AEAEBCC8D39E72B";
    private final  String uid="3174";
    private Map<String,String> map=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bianxieduanzi);
        initView();
    }

    private void initView() {
        mQuxiao = (TextView) findViewById(R.id.quxiao);
        mFabiao = (TextView) findViewById(R.id.fabiao);
        editor = (MRichEditor) findViewById(R.id.mre_editor);

        mQuxiao.setOnClickListener(this);
        mFabiao.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "取消操作", Toast.LENGTH_LONG).show();
            return;
        }
        if (requestCode == CamaraRequestCode.CAMARA_GET_IMG) {
            editor.insertImg(data.getData());
        } else if (requestCode == CamaraRequestCode.CAMARA_TAKE_PHOTO) {
            editor.insertImg(data);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.quxiao:
                //点击取消跳转回创作页面
                Intent intent = new Intent(BianxieduanziActivity.this, MakeActivity.class);
                startActivity(intent);
                break;
            case R.id.fabiao:
                //整合数据 调取接口发布段子
                List<EditorBean> editorList = editor.getEditorList();
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<editorList.size();i++){
                    sb.append(editorList.get(i).getContent()+"  ");
                }
                map.put("uid",uid);
                map.put("token",token);
                map.put("content", String.valueOf(sb));

                //网络请求
              new DuanPer(this).login(map);



                break;
        }
    }

    /**
     * 获取成功的数据
     * @param body
     */
    @Override
    public void getSuccess(Duanzibean body) {
        String msg = body.getMsg();
        //图示提示用户
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        if(msg.contains("成功")){
            Intent intent = new Intent(BianxieduanziActivity.this, ShardActivity.class);
            startActivity(intent);
        }
    }
}
