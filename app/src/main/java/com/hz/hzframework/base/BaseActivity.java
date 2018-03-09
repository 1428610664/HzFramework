package com.hz.hzframework.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.hz.hzframework.R;
import com.hz.hzframework.view.RootView;

/**
 * Created by hz on 2018/3/9.
 * GitHub：https://github.com/1428610664
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

public abstract class BaseActivity extends Activity implements RootView.RootViewListener, BaseViewState, RootView.NoWifiListener {

    protected RootView rootView;
    private boolean isCloseBack;
    protected LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutInflater = LayoutInflater.from(this);
        rootView = new RootView(this);
        rootView.addContentView(initView(savedInstanceState));
        rootView.setHeadTitle(setTitleStr() != null ? setTitleStr() : "");

        rootView.setRootViewListener(this);
        rootView.setNoWifiListener(this);
        setContentView(rootView);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public abstract View initView(Bundle savedInstanceState);

    public abstract String setTitleStr();

    public void setIsClosBack(boolean isClosBack) {
        this.isCloseBack = isClosBack;
    }

    public View getRightIcon(boolean isVisible){

        return  rootView.getRightIcon(isVisible);
    }


    public void setRightText(String v,boolean isview){
        rootView.setRightText(v,isview);
    }

    /**
     * @param v
     */
    public void onHeadClick(View v) {

    }

    @Override
    public void onRootViewClick(View v) {
        if (!isCloseBack) {
            if (v.getId() == R.id.root_head_back) {
                this.finish();
                return;
            }
        }
        onHeadClick(v);
    }

    public void changeState(RootView.ViewState state) {
        rootView.changeRootViewState(state);
    }

    @Override
    public void showLoading() {
        changeState(RootView.ViewState.LOADING);
    }

    @Override
    public void showInitLoading() {
        changeState(RootView.ViewState.ONELOADING);
    }

    @Override
    public void showNoNetWork() {
        changeState(RootView.ViewState.NONETWORK);
    }

    @Override
    public void showNoData() {
        changeState(RootView.ViewState.NODATA);
    }

    @Override
    public void showLoadFinish() {
        changeState(RootView.ViewState.SUCCESS);
    }

    public abstract void getRefreshData();

    @Override
    public void onNoWifiLister(View v) {
        getRefreshData();
    }
}
