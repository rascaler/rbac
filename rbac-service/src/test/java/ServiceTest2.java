import com.redding.rbac.commons.pojo.dto.EnterpriseDto;
import com.redding.rbac.service.EnterpriseService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


}
