package com.redding.rbac.web.utils.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by rascaler on 11/11/17.
 */
public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {

    public UsernamePasswordCaptchaToken() {
        super();
    }

    public UsernamePasswordCaptchaToken(String username, char[] password) {
        super(username, (char[])password, false, (String)null);
    }

    public UsernamePasswordCaptchaToken(String username, String password) {
        super(username, (char[])(password != null?password.toCharArray():null), false, (String)null);
    }

    public UsernamePasswordCaptchaToken(String username, char[] password, String host) {
        super(username, password, false, host);
    }

    public UsernamePasswordCaptchaToken(String username, String password, String host) {
        super(username, password != null?password.toCharArray():null, false, host);
    }

    public UsernamePasswordCaptchaToken(String username, char[] password, boolean rememberMe) {
        super(username, (char[])password, rememberMe, (String)null);
    }

    public UsernamePasswordCaptchaToken(String username, String password, boolean rememberMe) {
        super(username, (char[])(password != null?password.toCharArray():null), rememberMe, (String)null);
    }

    public UsernamePasswordCaptchaToken(String username, char[] password, boolean rememberMe, String host) {
        setRememberMe(false);
        setUsername(username);
        setPassword(password);
        setRememberMe(rememberMe);
        setHost(host);
    }

    public UsernamePasswordCaptchaToken(String username, String password, boolean rememberMe, String host) {
        super(username, password != null?password.toCharArray():null, rememberMe, host);
    }

    public UsernamePasswordCaptchaToken(String username, String password, String captcha, boolean rememberMe) {
        setUsername(username);
        setPassword(password != null?password.toCharArray():null);
        setRememberMe(rememberMe);
        setCaptcha(captcha);
    }

    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }


}
