import cn.digitalScene.Model.Project;
import cn.digitalScene.Service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by 25065 on 2017/3/11.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void add(){
        Project project=new Project("武汉理工","好学习","杨",new Date(),1);
        projectService.save(project);
    }
}
