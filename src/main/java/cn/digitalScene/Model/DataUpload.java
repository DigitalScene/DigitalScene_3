package cn.digitalScene.Model;

import cn.digitalScene.Utils.ModuleStatus;
import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 25065 on 2017/3/14.
 */
@Entity
@Table(name = "ds_dataupload")
public class DataUpload {

    @Id
    @GeneratedValue
    private Integer id;

    //必须模块，有一定的顺序流程 1->2->3->4->5
    //1.用户数据上传模块 dataUpload
    private String dataUploadPeople="";//场景用户数据上传者

    private String dataUploadToAppointPeople="";//场景用户数据指派者

    private Date dataUploadToAppointDate;//场景用户数据指派时间

    private Integer is_dataUploadPeople=0;//场景用户数据上传者确认(0为未确认，1为确认接受，2为已拒绝)

    private String dataUploadPeople_reason="";//场景用户数据上传者拒绝原因

    private String dataUploadToCheckPeople="";//场景用户数据审核者

    private Date dataUploadCheckDate;//场景用户数据审核时间

    private Date dataUploadFinishDate;//场景用户数据上传完成时间

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "dataUpload")
    private Project project;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataUploadPeople() {
        return dataUploadPeople;
    }

    public void setDataUploadPeople(String dataUploadPeople) {
        this.dataUploadPeople = dataUploadPeople;
    }

    public String getDataUploadToAppointPeople() {
        return dataUploadToAppointPeople;
    }

    public void setDataUploadToAppointPeople(String dataUploadToAppointPeople) {
        this.dataUploadToAppointPeople = dataUploadToAppointPeople;
    }

    public Date getDataUploadToAppointDate() {
        return dataUploadToAppointDate;
    }

    public void setDataUploadToAppointDate(Date dataUploadToAppointDate) {
        this.dataUploadToAppointDate = dataUploadToAppointDate;
    }

    public String getDataUploadToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getDataUploadToAppointDate());
    }

    public Integer getIs_dataUploadPeople() {
        return is_dataUploadPeople;
    }

    public void setIs_dataUploadPeople(Integer is_dataUploadPeople) {
        this.is_dataUploadPeople = is_dataUploadPeople;
    }

    public String getDataUploadPeople_reason() {
        return dataUploadPeople_reason;
    }

    public void setDataUploadPeople_reason(String dataUploadPeople_reason) {
        this.dataUploadPeople_reason = dataUploadPeople_reason;
    }

    public String getDataUploadToCheckPeople() {
        return dataUploadToCheckPeople;
    }

    public void setDataUploadToCheckPeople(String dataUploadToCheckPeople) {
        this.dataUploadToCheckPeople = dataUploadToCheckPeople;
    }

    public Date getDataUploadCheckDate() {
        return dataUploadCheckDate;
    }

    public String getDataUploadCheckDateStr() {
        return TimeStringUtils.timeToString(this.getDataUploadCheckDate());
    }

    public void setDataUploadCheckDate(Date dataUploadCheckDate) {
        this.dataUploadCheckDate = dataUploadCheckDate;
    }

    public Date getDataUploadFinishDate() {
        return dataUploadFinishDate;
    }

    public String getDataUploadFinishDateStr() {
        return TimeStringUtils.timeToString(this.getDataUploadFinishDate());
    }

    public void setDataUploadFinishDate(Date dataUploadFinishDate) {
        this.dataUploadFinishDate = dataUploadFinishDate;
    }



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
