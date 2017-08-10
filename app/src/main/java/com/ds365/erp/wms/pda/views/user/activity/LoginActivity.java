package com.ds365.erp.wms.pda.views.user.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ds365.erp.wms.pda.R;
import com.ds365.networkconnections.base.ActivityLifeCycleEvent;
import com.ds365.networkconnections.base.BaseActivity;
import com.ds365.networkconnections.http.Api;
import com.ds365.networkconnections.http.HttpUtil;
import com.ds365.networkconnections.http.ProgressSubscriber;
import com.ds365.networkconnections.model.VerifyCodeModel;
import com.ds365.networkconnections.view.SimpleLoadDialog;

import java.util.List;

import rx.Observable;

public class LoginActivity extends BaseActivity {

    private TextView mText;
    private SimpleLoadDialog dialogHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dialogHandler = new SimpleLoadDialog(LoginActivity.this, null, true);
        mText = (TextView) findViewById(R.id.text);
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialogHandler.obtainMessage(SimpleLoadDialog.SHOW_PROGRESS_DIALOG).sendToTarget();
                doGet();
            }
        });
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        dialogHandler.obtainMessage(SimpleLoadDialog.DISMISS_PROGRESS_DIALOG).sendToTarget();
    }

    private void doGet() {
        //获取豆瓣电影TOP 100
//        Observable ob = Api.getDefault().getTopMovie(0, 100);
        Observable ob = Api.getDefault().getImage();
        //嵌套请求
//        ob.flatMap(new Func1<String, Observable<HttpResult<Subject>>>() {
//
//            @Override
//            public Observable<HttpResult<Subject>> call(String s) {
//                return Api.getDefault().getUser("aa");
//            }
//        });


        HttpUtil.getInstance().toSubscribe(ob, new ProgressSubscriber<VerifyCodeModel>(this) {
            @Override
            protected void _onError(String message) {
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
            }

            @Override
            protected void _onNext(VerifyCodeModel image) {
                /*String str = "";
                for (int i = 0; i < list.size(); i++) {
                    str += "电影名：" + list.get(i).getTitle() + "\n";
                }
                mText.setText(str);*/
                Log.e("lili", "" + image.getToken());
                Toast.makeText(LoginActivity.this, ""+image.getToken(), Toast.LENGTH_SHORT).show();
            }
        }, "cacheKey", ActivityLifeCycleEvent.DESTROY, lifecycleSubject, false, false);
    }
}
