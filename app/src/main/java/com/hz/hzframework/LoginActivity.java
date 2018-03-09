package com.hz.hzframework;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hz.hzframework.base.BaseActivity;
import com.hz.hzframework.presenter.LoginPresenter;
import com.hz.hzframework.utils.KeyboardUtil;
import com.hz.hzframework.viewinterface.ILoginView;
import com.hz.hzframework.widget.ClearWriteEditText;

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView {

    private ImageView mImg_Background;
    private ClearWriteEditText mPhoneEdit, mPasswordEdit;

    private LoginPresenter presenter;
    private long firstTime;

    @Override
    public View initView(Bundle savedInstanceState) {
        View view = mLayoutInflater.inflate(R.layout.activity_login, null);
        rootView.isHintHeadBar(true);

        initView(view);
        return view;
    }

    @Override
    public String setTitleStr() {
        return "";
    }

    @Override
    public void getRefreshData() {

    }

    private void initView(View view) {
        mPhoneEdit = (ClearWriteEditText) view.findViewById(R.id.de_login_phone);
        mPasswordEdit = (ClearWriteEditText) view.findViewById(R.id.de_login_password);
        Button mConfirm = (Button) view.findViewById(R.id.de_login_sign);
        mConfirm.setOnClickListener(this);
        mImg_Background = (ImageView) view.findViewById(R.id.de_img_backgroud);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate_anim);
                mImg_Background.startAnimation(animation);
            }
        }, 200);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.de_login_sign:
                if (presenter == null) {
                    presenter = new LoginPresenter(this, this);
                }
                presenter.login();
                KeyboardUtil.closeKeyBoard(this);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (System.currentTimeMillis() - firstTime > 1000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public String getUserName() {
        return mPhoneEdit.getText().toString();
    }

    @Override
    public String getUserPassWord() {
        return mPasswordEdit.getText().toString();
    }

    @Override
    public void successLogin() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
