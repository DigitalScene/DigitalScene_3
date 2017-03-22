package cn.digitalScene.Utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by 25065 on 2017/3/21.
 */
public class FileUtils {

    public static FileInfo fileUpload(HttpServletRequest request,String parentPath,String ymd){

        String readFilePath=null;

        String path=null;

        String fileName=null;

        try {
            //解析器解析request的上下文
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());

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
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      return  new FileInfo(fileName,readFilePath);
    }

    public static class FileInfo{
        private String fileName;
        private String readFilePath;

        public FileInfo() {
        }

        public FileInfo(String fileName, String readFilePath) {
            this.fileName = fileName;
            this.readFilePath = readFilePath;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getReadFilePath() {
            return readFilePath;
        }

        public void setReadFilePath(String readFilePath) {
            this.readFilePath = readFilePath;
        }
    }
}

