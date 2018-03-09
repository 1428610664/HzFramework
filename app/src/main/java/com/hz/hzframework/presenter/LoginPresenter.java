package com.hz.hzframework.presenter;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.hz.hzframework.base.BaseViewState;
import com.hz.hzframework.bean.UserBean;
import com.hz.hzframework.manager.ILoginManager;
import com.hz.hzframework.manager.impl.LoginManager;
import com.hz.hzframework.manager.listener.IOnManagerListener;
import com.hz.hzframework.utils.PersonMessagePreferencesUtils;
import com.hz.hzframework.utils.SystemConfig;
import com.hz.hzframework.viewinterface.ILoginView;
import com.hz.hzframework.widget.LoadDialog;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class LoginPresenter implements IOnManagerListener {
    private ILoginView loginView;
    private ILoginManager loginManager;
    private BaseViewState viewState;

    public LoginPresenter(ILoginView loginView, BaseViewState viewState) {
        this.loginView = loginView;
        this.loginManager = new LoginManager();
        this.viewState = viewState;
    }

    public void login() {
        if (!TextUtils.isEmpty(loginView.getUserName())) {
            if (SystemConfig.isPassword(loginView.getUserPassWord())) {
                viewState.showLoading();
                loginManager.login(loginView.getUserName(), loginView.getUserPassWord(), this);
            }
        } else {
            SystemConfig.showToast("请输入正确手机号");
        }
    }


    @Override
    public void onSuccess(Object data, String url) {
        viewState.showLoadFinish();
        UserBean userBean = (UserBean) data;
        if (userBean.getCode().equals("1")) {
            PersonMessagePreferencesUtils.storeInfo(userBean);
            loginView.successLogin();
        } else {
            SystemConfig.showToast(userBean.getMsg());
        }
    }

    @Override
    public void onFail(Exception e, String url) {
        viewState.showLoadFinish();
        SystemConfig.showToast("网络错误");
    }
}
