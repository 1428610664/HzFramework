package com.hz.hzframework.base;

/**
 * Created by Administrator on 2016/6/22 0022.
 */
public interface BaseViewState {
    void showLoading(); // 加载中

    void showInitLoading(); // 初始化加载中

    void showNoNetWork(); // 无网络

    void showNoData(); // 无数据

    void showLoadFinish(); // 加载完成
}
