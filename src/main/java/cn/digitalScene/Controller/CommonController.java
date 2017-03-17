package cn.digitalScene.Controller;

import cn.digitalScene.Model.User;
import cn.digitalScene.Service.ProjectService;
import cn.digitalScene.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 25065 on 2017/3/16.
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    /**
     * 各大模块的指派界面
     * @param id
     * @return
     */
    @RequestMapping(value = "/module/toAppoint",method = RequestMethod.GET)
    public String toAppoint(Integer id,String type,Model model){

        try {
            String projectName=projectService.findNameById(id);
            List<User> userLists=userService.findUsernameByStatus0AndUser();
            model.addAttribute("id",id);
            model.addAttribute("projectName",projectName);
            model.addAttribute("userLists",userLists);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (type.equals("dataUpload")){
            return "/page/admin/module/dataUpload/toAppoint";
        }else if (type.equals("photoEdit")){
            return "/page/admin/module/photoEdit/toAppoint";
        }else if (type.equals("photoMade")){
            return "/page/admin/module/photoMade/toAppoint";
        }else if (type.equals("sceneMade")){
            return "/page/admin/module/sceneMade/toAppoint";
        }else if (type.equals("dataIntegration")){
            return "/page/admin/module/dataIntegration/toAppoint";
        }else if (type.equals("mp3Edit")){
            return "/page/admin/module/mp3Edit/toAppoint";
        }else if (type.equals("videoEdit")){
            return "/page/admin/module/videoEdit/toAppoint";
        }else if (type.equals("thrDModelMade")){
            return "/page/admin/module/thrDModelMade/toAppoint";
        }else {
            return "/page/admin/module/subtitleEdit/toAppoint";
        }
    }

    /**
     * 拒绝操作界面
     * @param id
     * @return
     */
    @RequestMapping(value = "/module/toReject",method = RequestMethod.GET)
    public String toReject(Integer id,String type,Model model){
        try {
            String projectName=projectService.findNameById(id);
            model.addAttribute("id",id);
            model.addAttribute("projectName",projectName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (type.equals("dataUpload")){
            return "/page/admin/module/dataUpload/toReject";
        }else if (type.equals("photoEdit")){
            return "/page/admin/module/photoEdit/toReject";
        }else if (type.equals("photoMade")){
            return "/page/admin/module/photoMade/toReject";
        }else if (type.equals("sceneMade")){
            return "/page/admin/module/sceneMade/toReject";
        }else if (type.equals("dataIntegration")){
            return "/page/admin/module/dataIntegration/toReject";
        }else if (type.equals("mp3Edit")){
            return "/page/admin/module/mp3Edit/toReject";
        }else if (type.equals("videoEdit")){
            return "/page/admin/module/videoEdit/toReject";
        }else if (type.equals("thrDModelMade")){
            return "/page/admin/module/thrDModelMade/toReject";
        }else {
            return "/page/admin/module/subtitleEdit/toAppoint";
        }

    }


}
