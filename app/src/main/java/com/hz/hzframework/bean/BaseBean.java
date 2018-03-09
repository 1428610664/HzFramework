package com.hz.hzframework.bean;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class BaseBean {

    /**
     * code : 1
     * msg : 获取验证码成功!
     */

    private String code;
    private String msg;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
