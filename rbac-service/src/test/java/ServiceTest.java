import com.redding.rbac.infrastructure.domain.Enterprise;
import com.redding.rbac.infrastructure.manager.EnterpriseManager;
import com.redding.rbac.service.EnterpriseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/12 17:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class ServiceTest {

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private EnterpriseManager enterpriseManager;

    @Test
    public void testEnterprise(){
        enterpriseService.getById(1);
    }

    @Test
    public void testLimit(){
//        Enterprise enterprise = new Enterprise();
//        enterprise.setId(1);
//        enterpriseManager.selectFirst(enterprise);

        Example example = new Example(Enterprise.class);
        example.createCriteria().andEqualTo("id", 1);
        enterpriseManager.selectFirstByExample(example);
    }
}
