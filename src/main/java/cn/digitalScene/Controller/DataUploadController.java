package cn.digitalScene.Controller;

import cn.digitalScene.Model.Project;
import cn.digitalScene.Model.User;
import cn.digitalScene.Service.ProjectService;
import cn.digitalScene.Service.UserService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by 25065 on 2017/3/13.
 */
@Controller
@RequestMapping("/dataUpload")
public class DataUploadController {

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

            projectsList=projectService.findAllByIsDel0(projectName,createTime,null,"1",null,null,null,null,null,null,null,null,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("appointList",projectsList);
        return "page/admin/module/dataUpload/toAppointList";
    }

//    /**
//     * 指派界面
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/toAppoint",method = RequestMethod.GET)
//    public String toAppoint(Integer id,Model model){
//
//        try {
//            String projectName=projectService.findNameById(id);
//            List<User> userLists=userService.findUsernameByStatus0AndUser();
//            model.addAttribute("id",id);
//            model.addAttribute("projectName",projectName);
//            model.addAttribute("userLists",userLists);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/page/admin/mustModule/dataUpload/toAppoint";
//    }

    /**
     * 指派操作
     * @param id
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toAppoint",method = RequestMethod.POST)
    public Object toAppoint(Integer id,String username){
        try {
            String toAppointPeople="admin(小白)";
            Date toAppointDate=new Date();
            //2为数据上传模块状态指派中
            projectService.updateDataUploadStatusByIdAndUsername(id,2,username,toAppointPeople,toAppointDate);
            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage());
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

            pageCurrent= PageUtils.returnPageCurrent(pageCurrent,parameterCountNow,parameterCountBeforeFromDealWith,pageNumbers);

            if (parameterCountNow!=parameterCountBeforeFromDealWith){
                parameterCountBeforeFromDealWith=parameterCountNow;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);

            projectsList=projectService.findAllByIsDel0(projectName,createTime,null,"2,3",null,null,null,null,null,null,null,null,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("dealWithList",projectsList);
        return "page/admin/module/dataUpload/toDealWithList";
    }

    /**
     * 接受操作
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toAccept",method = RequestMethod.POST)
    public Object toReject(Integer id){
        try {
            //3为数据上传的状态：进行中；1为数据上传is_dataUploadPeople确认接受状态
            projectService.updateDataUploadStatusAndAcceptById(id,3,1);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

//    /**
//     * 拒绝操作界面
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/toReject",method = RequestMethod.GET)
//    public String toReject(Integer id,Model model){
//        try {
//            String projectName=projectService.findNameById(id);
//            model.addAttribute("id",id);
//            model.addAttribute("projectName",projectName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/page/admin/module/dataUpload/toReject";
//    }

    /**
     * 拒绝操作
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toReject",method = RequestMethod.POST)
    public Object toReject(Integer id,String dataUploadPeopleReason){
        try {
            //1为数据上传的状态：待确认；2为数据上传is_dataUploadPeople拒绝状态
            projectService.updateDataUploadStatusAndRejectById(id,1,2,dataUploadPeopleReason);
            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage());
        }
    }

    @RequestMapping("/toDealWith")
    public String toDealWith(Integer id,Model model){
        model.addAttribute("id",id);
        return "/page/admin/module/dataUpload/toDealWith";
    }

    @ResponseBody
    @RequestMapping("/toDealWithFinish")
    public Object toDealWithFinish(Integer id){
        try {
            //4为数据上传的状态：待审核
            Date toDealWithFinishDate=new Date();
            projectService.updateDataUploadStatusAndDealWithById(id,4,toDealWithFinishDate);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

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

            projectsList=projectService.findAllByIsDel0(projectName,createTime,null,"4",null,null,null,null,null,null,null,null,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("checkList",projectsList);
        return "/page/admin/module/dataUpload/toCheckList";
    }

    @ResponseBody
    @RequestMapping("/toCheckFinish")
    public Object toCheckFinish(Integer id){
        try {
            String checkPeople="admin(小白)";
            Date toCheckDate=new Date();
            //5为数据上传状态为已完成，同时启动原始图编辑图状态，1为待指派
            projectService.updateDaUpStatusToCheckFinishById(id,5,1,checkPeople,toCheckDate);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    @RequestMapping("/toFinishList")
    public String toFinishList(@RequestParam(value = "projectName",required = false)String projectName,
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

            pageCurrent= PageUtils.returnPageCurrent(pageCurrent,parameterCountNow,parameterCountBeforeFromFinish,pageNumbers);

            if (parameterCountNow!=parameterCountBeforeFromFinish){
                parameterCountBeforeFromFinish=parameterCountNow;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);

            projectsList=projectService.findAllByIsDel0(projectName,createTime,null,"5",null,null,null,null,null,null,null,null,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("finishList",projectsList);
        return "/page/admin/module/dataUpload/finishList";
    }

    /**
     * 图片压缩文件上传
     */
    @ResponseBody
    @RequestMapping("/fileUpload")
    public Object fileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String basePath=request.getSession().getServletContext().getRealPath("/");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String ymd="uploads"+"/dataUpload/"+sdf.format(new Date());
        String parentPath=basePath+ymd+"/";

        String readFilePath=null;

        String path=null;

        try {
            //解析器解析request的上下文
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());

            String fileName=null;
            //先判断request中是否包含multipart类型的数据，
            if (multipartResolver.isMultipart(request)){
                //再将request中的数据转化成multipart类型的数据
                MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest) request;
                Iterator iterator=multiRequest.getFileNames();
                while (iterator.hasNext()){
                    MultipartFile file=multiRequest.getFile((String)iterator.next());
                    if (file!=null){
                        fileName=file.getOriginalFilename();

                        String imageType=fileName.substring(fileName.lastIndexOf(".")).trim().toLowerCase();
                        String uuid= UUID.randomUUID().toString().replace("-","");//返回一个随机UUID
                        String newFileName=uuid+imageType;

                        path=parentPath+newFileName;
                        readFilePath=ymd+"/"+newFileName;
                        File localFile=new File(path);
                        if (!localFile.getParentFile().exists()){
                            localFile.getParentFile().mkdirs();
                        }
                        file.transferTo(localFile);
                        System.out.println(readFilePath);
                    }
                }
            }
            return executeResult.jsonReturnFile(200,fileName,readFilePath);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }
}
