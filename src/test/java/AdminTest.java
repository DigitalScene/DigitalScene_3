import cn.digitalScene.Model.Admin;
import cn.digitalScene.Service.AdminService;
import cn.digitalScene.Utils.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 25065 on 2017/2/16.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void add(){
        Admin admin=new Admin("yang","小白", MD5.getMD5("123456"),1);
        adminService.add(admin);
    }
}
