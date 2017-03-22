package cn.digitalScene.Controller;

import cn.digitalScene.Model.ReceivedModel.UploadFileArray;
import cn.digitalScene.Model.UploadFile;
import cn.digitalScene.Model.User;
import cn.digitalScene.Service.ProjectService;
import cn.digitalScene.Service.UploadFileService;
import cn.digitalScene.Service.UserService;
import cn.digitalScene.Utils.ExecuteResult;
import cn.digitalScene.Utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 25065 on 2017/3/16.
 */
@Controller
@RequestMapping("/admin/common")
public class CommonController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UploadFileService uploadFileService;

    private ExecuteResult executeResult=new ExecuteResult();

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
            return "/page/admin/module/subtitleEdit/toReject";
        }
    }

    /**
     * 处理操作
     * @param moduleId
     * @param uploadFileArray
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/file/save",method = RequestMethod.POST)
    public Object fileToSave(String moduleId,UploadFileArray uploadFileArray ){
        List<UploadFile> uploadFileList = uploadFileArray.getUploadFileList();

        try {
            for (UploadFile uploadFile : uploadFileList) {
                if (uploadFile.getFileName()!=null&&uploadFile.getUrl()!=null){
                    uploadFile.setModuleId(moduleId);
                    uploadFileService.save(uploadFile);
                }
            }
            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300, e.getMessage());
        }
    }

    /**
     * 文件删除
     */
    @ResponseBody
    @RequestMapping("/file/delete")
    public Object delete(HttpServletRequest request, HttpServletResponse response, Integer id, Integer index, String url) throws Exception{

        try {
            String basePath=request.getSession().getServletContext().getRealPath("/");
            File file=new File(basePath+url);
            if (file.exists()){
                file.delete();
            }
            if (file.getParentFile().exists()){
                file.getParentFile().delete();
            }
            if (id!=null){
                uploadFileService.delete(id);
            }
            return executeResult.jsonReturnIndex(200,index,false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 压缩文件上传
     */
    @ResponseBody
    @RequestMapping("/file/upload")
    public Object fileUpload(String moduleType,HttpServletRequest request, HttpServletResponse response) throws Exception{

        String basePath=request.getSession().getServletContext().getRealPath("/");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String ymd="uploads"+"/"+moduleType+"/"+sdf.format(new Date());
        String parentPath=basePath+ymd+"/";

        try {

            FileUtils.FileInfo fileInfo=FileUtils.fileUpload(request,parentPath,ymd);

            return executeResult.jsonReturnFile(200,fileInfo.getFileName(),fileInfo.getReadFilePath());
        } catch (Exception e) {
            return executeResult.jsonReturn(300," 上传失败，请重试！",false);
        }
    }

    @RequestMapping("/file/download")
    public void downLoadFile(HttpServletRequest request,HttpServletResponse response,String fileName, String url)
    {
        String basePath=request.getSession().getServletContext().getRealPath("/");
        File file=new File(basePath+url);
        if (file == null || !file.exists())
        {
            return;
        }
        OutputStream out = null;
        FileInputStream in=null;
        try {
            response.reset();
//            response.setContentType("application/octet-stream; charset=utf-8");
            response.setContentType("application/x-msdownload ; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" +fileName);
            out = response.getOutputStream();
            in=new FileInputStream(file);

            byte[] b=new byte[1024];

            int i=0;
            while ((i=in.read(b))>0){
                out.write(b,0,i);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }

            if (out != null)
            {
                try {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
