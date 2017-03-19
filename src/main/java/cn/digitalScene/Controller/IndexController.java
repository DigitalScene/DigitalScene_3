package cn.digitalScene.Controller;

import cn.digitalScene.Model.Role;
import cn.digitalScene.Model.User;
import cn.digitalScene.Service.UserService;
import cn.digitalScene.Utils.MD5;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by 25065 on 2016/8/4.
 */
@Controller
public class IndexController {
    @Autowired
    private UserService adminService;

    private Log logger= LogFactory.getLog(IndexController.class);

    @RequestMapping("")
    public String toIndex(){
        return "redirect:/index";
    }

//    暂时注释
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password,
                        @RequestParam(value = "authCode")String authCode,
                        @RequestParam(value = "roleType")String roleType,
                        HttpSession session, Model model){
        try {
            String validateCode=(String) session.getAttribute("validateCode");

            Integer status=0;

            User admin=adminService.findByUsername(username);
            if (admin==null){
                model.addAttribute("message","该用户名不存在");
                return "page/login";
            }

             boolean isExist=false;
             for (Role r:admin.getRoleArrayList()){
                 if (r.getRole().equals(roleType)){
                     isExist=true;
                 }
             }

            String encoder= MD5.getMD5(password.trim());

            status=admin.getStatus();

            if (!username.equals(admin.getUsername())){
                model.addAttribute("message","该用户名不存在");
                return "page/login";
            }else if (!encoder.equals(admin.getPassword())){
                model.addAttribute("message","用户名或密码错误");
                return "page/login";
            }else if (!authCode.equals(validateCode)){
                model.addAttribute("message","验证码错误");
                return "page/login";
            }else if (status==1){
                model.addAttribute("message","该用户已被锁定，请联系管理员解锁");
                return "page/login";
            }else if (!isExist){
                model.addAttribute("message","该用户名不具有所选的角色");
                return "page/login";
            }else {
                session.setMaxInactiveInterval(30*60);
                session.setAttribute("roleType",roleType);
                session.setAttribute("loginUser",admin);
                session.setAttribute("login","success");
                return "redirect:/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //登出
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("login");
        session.removeAttribute("loginUser");
        session.removeAttribute("roleType");
        return "page/login";
    }

    //验证码
    @RequestMapping("/validatecode")
    public String validatecode(){
        return "page/validatecode";
    }

    //首页
    @RequestMapping("/index")
    public String index(HttpSession session, Model model){
        logger.info("主页");
//        暂时注释
        try {
            String login=(String) session.getAttribute("login");
            if (login.equals("success")){
                //登录成功
                User admin=(User)session.getAttribute("loginUser");
                String roleType=(String)session.getAttribute("roleType");
                model.addAttribute("loginUser",admin);
                model.addAttribute("roleType",roleType);
                return "page/backIndex";
            }else {
                session.removeAttribute("login");
                return "page/login";
            }
        } catch (Exception e) {
            //session login不存在，报错
            return "page/login";
        }
//        return "page/backIndex";
    }

    @RequestMapping("/changeRole")
    public String changeRole(String role,HttpSession session){
        session.removeAttribute("roleType");
        session.setAttribute("roleType",role);
        return "redirect:/index";
    }
}
