package cn.digitalScene.Controller;

import cn.digitalScene.Model.Project;
import cn.digitalScene.Model.User;
import cn.digitalScene.Service.ProjectService;
import cn.digitalScene.Utils.ExecuteResult;
import cn.digitalScene.Utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/13.
 */
@Controller
@RequestMapping("/admin/thrDModelMade")
public class ThrDModelMadeController {

    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private ProjectService projectService;

    //待指派列表搜索参数的数量
    private static int parameterCountBeforeFromAppoint=0;

    //待处理列表搜索参数的数量
    private static int parameterCountBeforeFromDealWith=0;

    //待审核列表搜索参数的数量
    private static int parameterCountBeforeFromCheck=0;

    //已完成列表搜索参数的数量
    private static int parameterCountBeforeFromFinish=0;

    /**
     * 待指派列表
     * @param projectName
     * @param createTime
     * @param pageSize
     * @param pageNumbers
     * @param pageCurrent
     * @param orderField
     * @param orderDirection
     * @param model
     * @return
     */
    @RequestMapping("/toAppointList")
    public String toAppointList(@RequestParam(value = "projectName",required = false)String projectName,
                                @RequestParam(value = "createTime",required = false)String createTime,
                                @RequestParam(value = "pageSize",required = false)Integer pageSize,
                                @RequestParam(value = "pageNumbers",required = false)Integer pageNumbers,
                                @RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                                @RequestParam(value = "orderField",required = false)String orderField,
                                @RequestParam(value = "orderDirection",required = false)String orderDirection,
                                Model model){

        Page<Project> projectsList=null;

        try {
            int parameterCountNow=0;
            if (projectName!=null&&!projectName.equals("")){
                model.addAttribute("projectName",projectName);
                parameterCountNow++;
            }
            if (createTime!=null&&!createTime.equals("")){
                model.addAttribute("createTime",createTime);
                parameterCountNow++;
            }

            if (pageSize==null||pageSize.equals("")){
                pageSize=20;
            }

            pageCurrent= PageUtils.returnPageCurrent(pageCurrent,parameterCountNow,parameterCountBeforeFromAppoint,pageNumbers);

            if (parameterCountNow!=parameterCountBeforeFromAppoint){
                parameterCountBeforeFromAppoint=parameterCountNow;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);

            projectsList=projectService.findAllByIsDel0(projectName,createTime,null,null,null,null,null,null,null,null,"1",null,null,null,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("appointList",projectsList);
        return "page/admin/module/thrDModelMade/toAppointList";
    }



    /**
     * 指派操作
     * @param id
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toAppoint",method = RequestMethod.POST)
    public Object toAppoint(Integer id, String username, HttpSession session){
        try {
            User user=(User) session.getAttribute("loginUser");
            String toAppointPeople=user.getUsername()+"("+user.getNickname()+")";
            Date toAppointDate=new Date();
            //2为3D模型制作模块状态指派中
            projectService.updateThrDModelMadeStatusByIdAndUsername(id,2,username,toAppointPeople,toAppointDate);
            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,"登录已过时，请重新登录!");
        }
    }

    /**
     * 待处理列表
     * @param projectName
     * @param createTime
     * @param pageSize
     * @param pageNumbers
     * @param pageCurrent
     * @param orderField
     * @param orderDirection
     * @param model
     * @return
     */
    @RequestMapping("/toDealWithList")
    public String toDealWithList(@RequestParam(value = "projectName",required = false)String projectName,
                                @RequestParam(value = "createTime",required = false)String createTime,
                                @RequestParam(value = "pageSize",required = false)Integer pageSize,
                                @RequestParam(value = "pageNumbers",required = false)Integer pageNumbers,
                                @RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                                @RequestParam(value = "orderField",required = false)String orderField,
                                @RequestParam(value = "orderDirection",required = false)String orderDirection,
                                Model model,HttpSession session){

        User user=(User)session.getAttribute("loginUser");

        String people=user.getUsername()+"("+user.getNickname()+")";

        Page<Project> projectsList=null;

        try {
            int parameterCountNow=0;
            if (projectName!=null&&!projectName.equals("")){
                model.addAttribute("projectName",projectName);
                parameterCountNow++;
            }
            if (createTime!=null&&!createTime.equals("")){
                model.addAttribute("createTime",createTime);
                parameterCountNow++;
            }

            if (pageSize==null||pageSize.equals("")){
                pageSize=20;
            }

            pageCurrent= PageUtils.returnPageCurrent(pageCurrent,parameterCountNow,parameterCountBeforeFromDealWith,pageNumbers);

            if (parameterCountNow!=parameterCountBeforeFromDealWith){
                parameterCountBeforeFromDealWith=parameterCountNow;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);

            projectsList=projectService.findAllByIsDel0(projectName,createTime,null,null,null,null,null,null,null,null,"2,3",null,people,"thrDModelMade",orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("dealWithList",projectsList);
        return "page/admin/module/thrDModelMade/toDealWithList";
    }

    /**
     * 接受操作
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toAccept",method = RequestMethod.POST)
    public Object toAccept(Integer id){
        try {
            //3为3D模型制作模块的状态：进行中；1为3D模型制作模块is_thrDModelMadePeople确认接受状态
            projectService.updateThrDModelMadeStatusAndAcceptById(id,3,1);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }



    /**
     * 拒绝操作
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toReject",method = RequestMethod.POST)
    public Object toReject(Integer id,String thrDModelMadePeopleReason){
        try {
            //1为3D模型制作模块的状态：待确认；2为3D模型制作模块is_thrDModelMadePeople拒绝状态
            projectService.updateThrDModelMadeStatusAndRejectById(id,1,2,thrDModelMadePeopleReason);
            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage());
        }
    }

    /**
     * 处理操作
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toDealWith")
    public String toDealWith(Integer id,Model model){
        model.addAttribute("id",id);
        return "/page/admin/module/thrDModelMade/toDealWith";
    }

    /**
     * 确认处理完成操作
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/toDealWithFinish")
    public Object toDealWithFinish(Integer id){
        try {
            //4为3D模型制作模块的状态：待审核
            Date toDealWithFinishDate=new Date();
            projectService.updateThrDModelMadeStatusAndDealWithById(id,4,toDealWithFinishDate);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 待审核列表
     * @param projectName
     * @param createTime
     * @param pageSize
     * @param pageNumbers
     * @param pageCurrent
     * @param orderField
     * @param orderDirection
     * @param model
     * @return
     */
    @RequestMapping("/toCheckList")
    public String toCheckList(@RequestParam(value = "projectName",required = false)String projectName,
                              @RequestParam(value = "createTime",required = false)String createTime,
                              @RequestParam(value = "pageSize",required = false)Integer pageSize,
                              @RequestParam(value = "pageNumbers",required = false)Integer pageNumbers,
                              @RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                              @RequestParam(value = "orderField",required = false)String orderField,
                              @RequestParam(value = "orderDirection",required = false)String orderDirection,
                              Model model){
        Page<Project> projectsList=null;

        try {
            int parameterCountNow=0;
            if (projectName!=null&&!projectName.equals("")){
                model.addAttribute("projectName",projectName);
                parameterCountNow++;
            }
            if (createTime!=null&&!createTime.equals("")){
                model.addAttribute("createTime",createTime);
                parameterCountNow++;
            }

            if (pageSize==null||pageSize.equals("")){
                pageSize=20;
            }

            pageCurrent= PageUtils.returnPageCurrent(pageCurrent,parameterCountNow,parameterCountBeforeFromCheck,pageNumbers);

            if (parameterCountNow!=parameterCountBeforeFromCheck){
                parameterCountBeforeFromCheck=parameterCountNow;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);

            projectsList=projectService.findAllByIsDel0(projectName,createTime,null,null,null,null,null,null,null,null,"4",null,null,null,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("checkList",projectsList);
        return "/page/admin/module/thrDModelMade/toCheckList";
    }

    /**
     * 确认审核完成列表
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/toCheckFinish")
    public Object toCheckFinish(Integer id,HttpSession session){
        try {
            User user=(User) session.getAttribute("loginUser");
            String checkPeople=user.getUsername()+"("+user.getNickname()+")";
            Date toCheckDate=new Date();
            //5为3D模型制作模块状态为已完成
            projectService.updateThrDModelMadeStatusToCheckFinishById(id,5,checkPeople,toCheckDate);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 已完成列表
     * @param projectName
     * @param createTime
     * @param pageSize
     * @param pageNumbers
     * @param pageCurrent
     * @param orderField
     * @param orderDirection
     * @param model
     * @return
     */
    @RequestMapping("/toFinishList")
    public String toFinishList(@RequestParam(value = "projectName",required = false)String projectName,
                              @RequestParam(value = "createTime",required = false)String createTime,
                              @RequestParam(value = "pageSize",required = false)Integer pageSize,
                              @RequestParam(value = "pageNumbers",required = false)Integer pageNumbers,
                              @RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                              @RequestParam(value = "orderField",required = false)String orderField,
                              @RequestParam(value = "orderDirection",required = false)String orderDirection,
                              Model model,HttpSession session){

        String roleType=(String)session.getAttribute("roleType");
        String people=null;
        String moduleType=null;
        //普通用户，需要根据登陆者搜索该用户拥有的项目
        if (roleType.equals("user")){
            User user=(User) session.getAttribute("loginUser");
            people=user.getUsername()+"("+user.getNickname()+")";
            moduleType="thrDModelMade";
        }

        Page<Project> projectsList=null;

        try {
            int parameterCountNow=0;
            if (projectName!=null&&!projectName.equals("")){
                model.addAttribute("projectName",projectName);
                parameterCountNow++;
            }
            if (createTime!=null&&!createTime.equals("")){
                model.addAttribute("createTime",createTime);
                parameterCountNow++;
            }

            if (pageSize==null||pageSize.equals("")){
                pageSize=20;
            }

            pageCurrent= PageUtils.returnPageCurrent(pageCurrent,parameterCountNow,parameterCountBeforeFromFinish,pageNumbers);

            if (parameterCountNow!=parameterCountBeforeFromFinish){
                parameterCountBeforeFromFinish=parameterCountNow;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);

            projectsList=projectService.findAllByIsDel0(projectName,createTime,null,null,null,null,null,null,null,null,"5",null,people,moduleType,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("finishList",projectsList);
        return "/page/admin/module/thrDModelMade/finishList";
    }

}
