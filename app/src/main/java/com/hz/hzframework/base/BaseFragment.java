package com.hz.hzframework.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hz.hzframework.view.RootView;


/**
 * Created by zh on 16/6/21.
 */
public abstract class BaseFragment extends Fragment implements RootView.RootViewListener, BaseViewState, RootView.NoWifiListener {
    protected RootView rootView;
    protected LayoutInflater mInflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflater = inflater;
        if (rootView == null) {
            rootView = new RootView(getContext());
            rootView.hintBackView(true);
            rootView.setHeadTitle(setTitleStr());
            rootView.addContentView(initView(inflater, container, savedInstanceState));
            rootView.setRootViewListener(this);
            rootView.setNoWifiListener(this);
        }
        return rootView;
    }

    public abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @NonNull
    public abstract String setTitleStr();

    /**
     * @param v
     */
    public void onHeadClick(View v) {

    }


    public void setHideHead() {
        rootView.isHintHeadBar(true);
    }

    @Override
    public void onRootViewClick(View v) {
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
