package cn.digitalScene.Controller;

import cn.digitalScene.Model.Project;
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

import java.text.SimpleDateFormat;

/**
 * Created by 25065 on 2017/3/11.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    private ExecuteResult executeResult=new ExecuteResult();

    @Autowired
    private ProjectService projectService;

    //项目列表 搜索参数的数量
    private static int parameterCountBefore=0;

    //已完成列表 搜索参数的数量
    private static int parameterCountBeforeFromFinish=0;
    /**
     * 项目添加界面
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Integer id,Model model){

        if (id!=null){
            Project project= null;
            try {
                project = projectService.findById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("project",project);
        }
        return "/page/admin/project/add";
    }

    /**
     * 项目添加实体类
     * @param project
     * @param frontCreateTime
     * @param nonessentialModels
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(Project project,String frontCreateTime,String[] nonessentialModels){
        try {

            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            project.setCreateTime(format.parse(frontCreateTime));

            if (nonessentialModels!=null){
                //选择可能保存的非必须模块
                String noneNeed="";
                for (String s:nonessentialModels){
                    noneNeed+=s+",";
                }
                if (noneNeed.contains("mp3Edit")){
                    project.setIs_mp3EditFinish(0);
                }
                if (noneNeed.contains("videoEdit")){
                    project.setIs_videoEditFinish(0);
                }
                if (noneNeed.contains("thrDModelMade")){
                    project.setIs_thrDModelMadeFinish(0);
                }
                if (noneNeed.contains("subtitleEdit")){
                    project.setIs_subtitleEditFinish(0);
                }
            }

            projectService.save(project);
            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage());
        }
    }

    /**
     * 启动项目
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/startup")
    public Object startup(Integer id){
        try {
            projectService.updateStatusById(id);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 删除，不是真实删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(Integer id){
        try {
            projectService.delete(id);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 项目列表
     * @return
     */
    @RequestMapping("/projectList")
    public String projectList(@RequestParam(value = "projectName",required = false)String projectName,
                              @RequestParam(value = "createTime",required = false)String createTime,
                              @RequestParam(value = "status",required = false)Integer status,
                              @RequestParam(value = "pageSize",required = false)Integer pageSize,
                              @RequestParam(value = "pageNumbers",required = false)Integer pageNumbers,
                              @RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                              @RequestParam(value = "orderField",required = false)String orderField,
                              @RequestParam(value = "orderDirection",required = false)String orderDirection,
                              Model model){
        Page<Project> projectsList= null;

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
            if (status!=null&&!status.equals("")){
                model.addAttribute("status",status);
                parameterCountNow++;
            }

            if (pageSize==null||pageSize.equals("")){
                pageSize=20;
            }

            pageCurrent= PageUtils.returnPageCurrent(pageCurrent,parameterCountNow,parameterCountBefore,pageNumbers);

            if (parameterCountNow!=parameterCountBefore){
                parameterCountBefore=parameterCountNow;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);
            projectsList = projectService.findAllByIsDel0(projectName,createTime,status,orderField,orderDirection,pageRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("projectsList",projectsList);
        return "/page/admin/project/projectList";
    }

    /**
     * 已完成项目列表
     * @return
     */
    @RequestMapping("/finishList")
    public String moduleToAppointList(@RequestParam(value = "projectName",required = false)String projectName,
                                      @RequestParam(value = "createTime",required = false)String createTime,
                                      @RequestParam(value = "pageSize",required = false)Integer pageSize,
                                      @RequestParam(value = "pageNumbers",required = false)Integer pageNumbers,
                                      @RequestParam(value = "pageCurrent",required = false)Integer pageCurrent,
                                      @RequestParam(value = "orderField",required = false)String orderField,
                                      @RequestParam(value = "orderDirection",required = false)String orderDirection,
                                      Model model){

        Page<Project> projectsList= null;

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

            projectsList=projectService.findAllByIsDel0(projectName,createTime,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("projectsList",projectsList);
        return "/page/admin/project/projectFinishList";
    }
}
