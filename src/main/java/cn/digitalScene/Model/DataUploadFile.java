package cn.digitalScene.Model;

import javax.persistence.*;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_datauploadfile")
public class DataUploadFile {

    @Id
    @GeneratedValue
    private Integer id;

    private String url;

    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "dataupload_id")
    private DataUpload dataUpload;

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

    public DataUpload getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(DataUpload dataUpload) {
        this.dataUpload = dataUpload;
    }
}
