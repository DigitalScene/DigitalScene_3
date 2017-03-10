package cn.digitalScene.Controller;

import cn.digitalScene.Model.Role;
import cn.digitalScene.Model.User;
import cn.digitalScene.Service.RoleService;
import cn.digitalScene.Service.UserService;
import cn.digitalScene.Utils.ExecuteResult;
import cn.digitalScene.Utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.form.FormTag;

import java.util.List;

/**
 * Created by 25065 on 2017/3/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService adminService;

    @Autowired
    private RoleService roleService;

    private ExecuteResult executeResult=new ExecuteResult();

    //搜索参数的数量
    private static int parameterCountBefore=0;

    /**
     * 管理员显示列表
     * @param username
     * @param nickname
     * @param status
     * @param pageNumbers
     * @param pageSize
     * @param pageCurrent
     * @param orderField
     * @param orderDirection
     * @param model
     * @return
     */
    @RequestMapping(value = "/userList")
    public String adminList(@RequestParam(required = false)String username,
                            @RequestParam(required = false)String nickname,
                            @RequestParam(required = false)Integer status,
                            @RequestParam(required = false)Integer pageNumbers,
                            @RequestParam(required = false)Integer pageSize,
                            @RequestParam(required = false)Integer pageCurrent,
                            @RequestParam(required = false)String orderField,
                            @RequestParam(required = false)String orderDirection,
                            Model model){
        Page<User> adminList= null;

        try {
            //搜索参数现在的数量
            int parameterCountNow=0;
            if (username!=null&&!username.equals("")){
                model.addAttribute("username",username);
                parameterCountNow++;
            }
            if (nickname!=null&&!nickname.equals("")){
                model.addAttribute("nickname",nickname);
                parameterCountNow++;
            }
            if (status!=null&&!status.equals("")){
                model.addAttribute("status",status);
                parameterCountNow++;
            }


            if (pageSize==null||pageSize.equals("")){
                pageSize=20;
            }

            if (pageCurrent==null||pageCurrent.equals("")){
                pageCurrent=0;
            }else if(parameterCountNow!=parameterCountBefore){
                pageCurrent=0;
                parameterCountBefore=parameterCountNow;
            }else if (pageCurrent>pageNumbers){
                pageCurrent=0;
            }else {
                pageCurrent=pageCurrent-1;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);
            adminList = adminService.findAllByIsDel0(username,nickname,status,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userList",adminList);
        return "/page/admin/user/userList";
    }

    /**
     * 管理员添加或编辑跳转页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Integer id,Model model){

        if (id!=null){
            //编辑
            User admin= null;
            try {
                admin = adminService.findById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String roles="";
            for (Role role:admin.getRoleArrayList()){
                roles+=role.getRole()+",";
            }
             System.out.println("roles:"+roles);
            model.addAttribute("user",admin);
            model.addAttribute("roles",roles);
        }

        return "/page/admin/user/add";
    }

    /**
     * 管理员添加实体
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(User admin,String[] roles){
        //添加admin实体类
        try {

            if (admin.getId()!=null){
                //编辑
                //名字重复检测
                String name=adminService.checkUsername(admin.getUsername());
                String oldName=adminService.findUsernameById(admin.getId());
                if (name!=null&&!name.equals(oldName)){
                    return executeResult.jsonReturn(300,"该用户名已被注册",false);
                }

                List<Role> roleList=adminService.findRolesById(admin.getId());
                for (Role role:roleList){
                    roleService.delete(role.getId());
                }

            }else {
                //添加
               //名字重复检测
                String name=adminService.checkUsername(admin.getUsername());
                if (name!=null){
                    return executeResult.jsonReturn(300,"该用户名已被注册",false);
                }
                //密码加密
                admin.setPassword(MD5.getMD5(admin.getPassword()));
            }

            if (roles!=null){
                //添加角色
                Role role=null;
                for (String s:roles){
                    role=new Role(s);
                    admin.addRoleArrayList(role);
                }
            }
            adminService.add(admin);

            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage());
        }
    }

    /**
     * 管理员更改密码跳转页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/updatePassword",method = RequestMethod.GET)
    public String updatePassword(Integer id,Model model){
        model.addAttribute("id",id);
        return "/page/admin/user/updatePassword";
    }

    /**
     * 管理员更改密码
     * @param id
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public Object updatePassword(Integer id,String oldPassword,String password,Model model){
        try {
            String oldPasswordFromDataBase=adminService.findPasswordById(id);
            if (!MD5.getMD5(oldPassword).equals(oldPasswordFromDataBase)){
                return executeResult.jsonReturn(300,"输入的原密码不对",false);
            }
            adminService.updatePasswordById(MD5.getMD5(password),id);
            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }

    }

    /**
     * 管理员用户名检测是否存在
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkUsername")
    public Object checkUsername(String username){
        try {
            String name=adminService.checkUsername(username);
            if (name==null){
                return executeResult.jsonReturn(200,"该用户名可以使用",false);
            }else {
                return executeResult.jsonReturn(300,"该用户名已被注册",false);
            }
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 管理员锁定
     * @return
     */
    @ResponseBody
    @RequestMapping("/suoDing")
    public Object suoDing(Integer id){
        try {
            adminService.suoDingById(id);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 管理员解锁
     * @return
     */
    @ResponseBody
    @RequestMapping("/jieSuo")
    public Object jieDing(Integer id){
        try {
            adminService.jieSuoById(id);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }


    /**
     * 管理员删除
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(Integer id){
        try {
            adminService.delete(id);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

}
