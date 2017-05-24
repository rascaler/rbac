package com.redding.rbac.commons.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 注意：各个模块都需要在这个类中注册异常编码
 *
 *
 *
 * 公共状态码基类,规范公共状态码,不同系统要继承该类
 * 异常码格式：AAABBBCCCC
 * AAA 系统编码  BBB 系统模块编码  CCCC 异常编码
 * 1001001000
 * Created by wurenqing on 3/17/17.
 */
public class RbacEcode implements Serializable {

    ///////////////////////////// organization
    /** 组织不存在 */
    public final static String ORGANIZATION_NOT_EXISTS = "";

}
