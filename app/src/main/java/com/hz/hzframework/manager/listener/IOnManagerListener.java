package com.hz.hzframework.manager.listener;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public interface IOnManagerListener<T> {

    void onSuccess(T data, String url);

    void onFail(Exception e, String url);
}
