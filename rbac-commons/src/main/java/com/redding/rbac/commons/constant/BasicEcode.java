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
public class BasicEcode implements Serializable {

    /* 状态===>>>状态说明映射文件 */
    public static final String BASE_PATH = "/basic-ecode.properties";
    // 扩展
    public static final String FILE_PATH = "/sub-ecode.properties";

    /* 系统异常 */
    public final static String FAILED = "1001";
    /* 成功 */
    public final static String SUCCESS = "1000";

    /* 用户未登陆 */
    public final static String USER_ERR_UNLOGINED = "10002";

    /* 账号登录异常 */
    public final static String USER_ERR_LOGIN = "10003";

    /* 账号已被禁用 */
    public final static String USER_ACCOUNT_LOCK = "10004";

    /* 该账号已在其他地方登录 */
    public final static String USER_ACCOUNT_KICK_OUT = "10005";

    /* 没有权限 */
    public final static String PERMISSION_DENIED = "11001";

    /* 参数不合法 */
    public final static String ILLEGAL_PARAMETER = "13000";

    /* 参数不能为空 */
    public final static String NULL_PARAMETER = "13001";

    /* 参数%s不合法 */
    public final static String DETAIL_ILLEGAL_PARAMETER = "13002";

    /* 数据异常,请及时修复 */
    public final static String DATA_ERROR = "13003";

    /* 数据不存在 */
    public final static String DATA_NOT_FOUND = "13004";

    /**
     * 保存失败
     */
    public final static String SAVE_ERROR = "19001";
    /**
     * 更新失败
     */
    public final static String UPDATE_ERROR = "19002";
    /**
     * 删除失败
     */
    public final static String DELETE_ERROR = "19003";
    /**
     * 重复操作
     */
    public final static String OP_RE_OPERATE = "19004";

    /* 状态码==状态码说明map */
    private final static Map<String, String> ecodeMessageMap = new HashMap<>();


    private static Logger logger = LoggerFactory.getLogger(BasicEcode.class);

    static {
        logger.info("加载错误码资源文件");
        try {
            ecodeMessageMap.putAll(loadBasicPropertie());
            loadPropertie(BasicEcode.class.getResourceAsStream(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }



    /**
     * 根据状态码获取状态对应说明
     *
     * @param ecode 状态码
     * @return 状态码说明
     * @throws RuntimeException 系统不存在状态码时抛出异常
     */
    public static String getMsg(String ecode) {
//		if (!ecodeMessageMap.containsKey(ecode)) {
//			throw new RuntimeException("ecode: " + ecode + " no found!!");
//		}
        return ecodeMessageMap.get(ecode);
    }


    /**
     * 加载基础状态码和描述文件
     *
     * @return
     * @throws IOException
     */
    private static Map<String, String> loadBasicPropertie() throws IOException {
        Map<String, String> map = new HashMap<>();
        Properties p = new Properties();
        try (InputStream is = BasicEcode.class.getResourceAsStream(BASE_PATH)) {
            p.load(is);
            for(String e: p.stringPropertyNames())
                map.put(e.trim(), p.getProperty(e.trim()));
        }

        return map;
    }

    /**
     * 通过文件路径加载状态码和描述
     *
     * @param propertieFilePath 配置文件路径
     * @throws IllegalAccessException 文件权限抛出异常问题抛出异常
     * @throws IOException            文件IO
     */
    protected static void loadPropertie(String propertieFilePath) throws IllegalAccessException, IOException {
        loadPropertie(new FileInputStream(new File(propertieFilePath)));
    }

    /**
     * 通过输入流加载状态码和描述
     *
     * @param is 输入流
     * @throws IOException            IO异常
     * @throws IllegalAccessException 文件权限异常
     */
    protected static void loadPropertie(InputStream is) throws IOException, IllegalAccessException {
        if (is == null) {
            logger.info("sub-ecode no found");
            return;
        }
        Map<String, String> map = new HashMap<>();
        Properties p = new Properties();
        p.load(is);
        for(String e: p.stringPropertyNames())
            map.put(e.trim(), p.getProperty(e.trim()));
        setEcodeMessageMap(map);
    }

    /**
     * 设置状态码和描述
     *
     * @param map
     */
    protected static void setEcodeMessageMap(Map<String, String> map) {
        BasicEcode.ecodeMessageMap.putAll(map);
    }

    public static Map<String, String> getEcodeMessageMap() {
        return BasicEcode.ecodeMessageMap;
    }

    /**
     * 检测状态码和描述是否一一对应
     *
     * @throws IllegalAccessException
     */
    public void checkEcodeMessage() throws IllegalAccessException {

        List<String> ecodes = getAllEcodeValue();
        for (String ecode : ecodes) {
            if (!BasicEcode.getEcodeMessageMap().containsKey(ecode)) {
                throw new RuntimeException("ecode:" + ecode + " no has message!!");
            }
        }
    }

    /**
     * 获取状态码的值,用于检测是否存在重复状态码
     *
     * @return
     * @throws IllegalAccessException
     */
    @SuppressWarnings({"rawtypes"})
    protected List<String> getAllEcodeValue() throws IllegalAccessException {
        List<String> ecodes = new ArrayList<>();
        Class clazz = this.getClass();
        do {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (!f.getName().equalsIgnoreCase("SYS_NO") && f.getType().isAssignableFrom(int.class)
                        && Modifier.isFinal(f.getModifiers()) && Modifier.isStatic(f.getModifiers())) {
                    ecodes.add(f.get(null).toString());
                }
            }
            clazz = clazz.getSuperclass();
        } while (clazz != Object.class);
        if (new HashSet<>(ecodes).size() != ecodes.size()) {
            throw new RuntimeException("duplicate ecode");
        }
        return ecodes;
    }
}
