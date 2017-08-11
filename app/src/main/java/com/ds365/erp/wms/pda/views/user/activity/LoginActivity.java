package com.ds365.erp.wms.pda.views.user.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ds365.commons.AppConstants;
import com.ds365.erp.wms.pda.R;
import com.ds365.erp.wms.pda.common.activity.BaseActivity;
import com.ds365.erp.wms.pda.common.base.Api;
import com.ds365.erp.wms.pda.model.user.VerifyCodeModel;
import com.ds365.networkconnections.base.ActivityLifeCycleEvent;
import com.ds365.networkconnections.http.HttpUtil;
import com.ds365.networkconnections.http.ProgressSubscriber;
import com.ds365.networkconnections.http.Url;

import rx.Observable;

public class LoginActivity extends BaseActivity {

    private boolean mIntentFromMessageFlag = false;//用来判断是否是从消息点击过来的

    private ImageView mVerifyCodeImage;

    private String captchaToken;//token
    private StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mVerifyCodeImage = (ImageView) findViewById(R.id.login_verifyCode_image);

        if (AppConstants.Intent_FROMMESSAGE_KEY.equals(getIntent().getStringExtra(AppConstants.Intent_FROMMESSAGE_KEY))) {
            mIntentFromMessageFlag = true;
        }

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCaptchaToken();
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
    }

    /**
     * 获取验证码,在获取验证码之前先获取token.
     */
    private void getCaptchaToken() {

        Observable ob = Api.getDefault().getImage();

        HttpUtil.getInstance().toSubscribe(ob, new ProgressSubscriber<VerifyCodeModel>(this) {
            @Override
            protected void _onError(String message) {
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
            }

            @Override
            protected void _onNext(VerifyCodeModel result) {
                captchaToken = result.getToken();
                sb = new StringBuilder(Url.image);
                sb.append("?").append(AppConstants.captchTokenParamsName).append("=").append(captchaToken);
                sb.append("&").append(AppConstants.requestSourceParamsName).append("=").append(AppConstants.requestSourceValue_app);
                Glide.with(LoginActivity.this).load(sb.toString()).into(mVerifyCodeImage);
            }
        }, "cacheKey", ActivityLifeCycleEvent.DESTROY, lifecycleSubject, false, false);
    }
}