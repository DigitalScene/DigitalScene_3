package cn.digitalScene.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 25065 on 2017/3/21.
 */
@Entity
@Table(name = "ds_uploadfile")
public class UploadFile {

    @Id
    @GeneratedValue
    private Integer id;

    private String url;

    private String fileName;

    private String moduleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
}
