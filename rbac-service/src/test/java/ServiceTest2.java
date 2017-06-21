import com.redding.rbac.commons.pojo.dto.EnterpriseDto;
import com.redding.rbac.service.EnterpriseService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/12 17:24
 */
public class ServiceTest2 {

    @Test
    public void testEncript(){
        try {
            String secret = "123456";
            String depaCode = "4419010830";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String now = format.format(new Date());
            System.out.println(encriptByMd5(now + depaCode +secret));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String encriptByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testSet(){
        Set<Integer> nums = new HashSet<Integer>();
        List<Integer> num1 = new ArrayList<Integer>(){{add(1);add(2);}};
        List<Integer> num2 = new ArrayList<Integer>(){{add(1);add(2);}};
        nums.addAll(num1);
        nums.addAll(num2);
        System.out.println(ToStringBuilder.reflectionToString(nums));
    }

    @Test
    public void testSplit(){
        String str ="1,2,3";
        System.out.println(str.split(","));
        return;
    }



}
