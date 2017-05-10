package com.redding.rbac.web.bean;

/**
 * Created by wurenqing on 2017/3/20.
 */
public class OuterResult {
    private String ecode = "1000";
    private String msg = "操作成功";
    private Object data;

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public OuterResult(String message) {
        this.setEcode("1001");
        this.setMsg(message);
    }


    public OuterResult(String code, String message) {
        this.setEcode(code);
        this.setMsg(message);
    }

    public OuterResult() {
    }

    public static OuterResult newInstance() {
        return new OuterResult();
    }
}
