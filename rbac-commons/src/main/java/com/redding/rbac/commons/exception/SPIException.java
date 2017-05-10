package com.redding.rbac.commons.exception;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.constant.IEcode;

/**
 * 服务接口异常封装
 * 继承运行时异常RuntimeException,不强制调用方捕获,减少代码量
 * Created by wurenqing on 3/17/17.
 */
public class SPIException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 2988464431836163074L;
    /*状态码*/
    private String ecode;
    /*状态码说明*/
    private String msg;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public SPIException(String ecode) {
        super(BasicEcode.getMsg(ecode));
        this.ecode = ecode;
        this.msg = BasicEcode.getMsg(ecode);
    }

    /**
     * 占位符 参数传递
     * %s%s   参数  可变字符
     *
     * @param ecode
     * @param args
     */
    public SPIException(String ecode, String... args) {
        super(BasicEcode.getMsg(ecode));
        this.ecode = ecode;
        this.msg = BasicEcode.getMsg(ecode);
        if (args != null && args.length > 0) {
            this.msg = String.format(this.msg, args);
        }
    }

    public SPIException(IEcode ecode, String... args) {
        super(ecode.message());
        this.ecode = ecode.ecode();
        this.msg = ecode.message();
        if (args != null && args.length > 0) {
            this.msg = String.format(this.msg, args);
        }
    }


    public String getEcode() {
        return ecode;
    }


    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "SPIException{" +
                "ecode=" + ecode +
                ", msg='" + msg + '\'' +
                '}';
    }
}
