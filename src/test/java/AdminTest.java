import cn.digitalScene.Model.User;
import cn.digitalScene.Service.UserService;
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
    private UserService adminService;

    @Test
    public void add(){
        User admin=new User("yang","小白", MD5.getMD5("123456"),1);
        adminService.add(admin);
    }

    @Test
    public void test(){
        int a=11;
        int b=2;
        System.out.println(a/b);
    }
}
