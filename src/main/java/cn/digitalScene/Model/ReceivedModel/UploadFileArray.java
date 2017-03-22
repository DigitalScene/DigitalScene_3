package cn.digitalScene.Model.ReceivedModel;

import cn.digitalScene.Model.UploadFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 25065 on 2017/3/21.
 */
public class UploadFileArray {
    private List<UploadFile> uploadFileList=new ArrayList<>();

    public UploadFileArray() {
    }

    public UploadFileArray(List<UploadFile> uploadFileList) {
        this.uploadFileList = uploadFileList;
    }

    public List<UploadFile> getUploadFileList() {
        return uploadFileList;
    }

    public void setUploadFileList(List<UploadFile> uploadFileList) {
        this.uploadFileList = uploadFileList;
    }
}
