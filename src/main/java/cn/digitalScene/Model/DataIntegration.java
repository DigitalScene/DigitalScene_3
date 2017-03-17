package cn.digitalScene.Model;

import cn.digitalScene.Utils.ModuleStatus;
import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_dataIntegration")
public class DataIntegration {

    @Id
    @GeneratedValue
    private Integer id;

    //5.数据整合模块 dataIntegration
    private String dataIntegrationPeople="";//数据整合者

    private String dataIntegrationToAppointPeople="";//场景用户数据指派者

    private Date dataIntegrationToAppointDate;//场景用户数据指派时间

    private Integer is_dataIntegrationPeople=0;//数据整合者确认(0为未确认，1为确认接受，2为已拒绝)

    private String dataIntegrationPeople_reason="";//数据整合者拒绝原因

    private String dataIntegrationToCheckPeople="";//场景构建数据审核者

    private Date dataIntegrationCheckDate;//场景构建数据审核时间

    private Date dataIntegrationFinishDate;//数据整合完成时间


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "dataIntegration")
    private Project project;

    public String getDataIntegrationPeople() {
        return dataIntegrationPeople;
    }

    public void setDataIntegrationPeople(String dataIntegrationPeople) {
        this.dataIntegrationPeople = dataIntegrationPeople;
    }

    public Integer getIs_dataIntegrationPeople() {
        return is_dataIntegrationPeople;
    }

    public void setIs_dataIntegrationPeople(Integer is_dataIntegrationPeople) {
        this.is_dataIntegrationPeople = is_dataIntegrationPeople;
    }

    public String getDataIntegrationPeople_reason() {
        return dataIntegrationPeople_reason;
    }

    public void setDataIntegrationPeople_reason(String dataIntegrationPeople_reason) {
        this.dataIntegrationPeople_reason = dataIntegrationPeople_reason;
    }

    public Date getDataIntegrationFinishDate() {
        return dataIntegrationFinishDate;
    }

    public String getDataIntegrationFinishDateStr() {
        return TimeStringUtils.timeToString(this.getDataIntegrationFinishDate());
    }

    public void setDataIntegrationFinishDate(Date dataIntegrationFinishDate) {
        this.dataIntegrationFinishDate = dataIntegrationFinishDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataIntegrationToAppointPeople() {
        return dataIntegrationToAppointPeople;
    }

    public void setDataIntegrationToAppointPeople(String dataIntegrationToAppointPeople) {
        this.dataIntegrationToAppointPeople = dataIntegrationToAppointPeople;
    }

    public Date getDataIntegrationToAppointDate() {
        return dataIntegrationToAppointDate;
    }

    public String getDataIntegrationToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getDataIntegrationToAppointDate());
    }

    public void setDataIntegrationToAppointDate(Date dataIntegrationToAppointDate) {
        this.dataIntegrationToAppointDate = dataIntegrationToAppointDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDataIntegrationToCheckPeople() {
        return dataIntegrationToCheckPeople;
    }

    public void setDataIntegrationToCheckPeople(String dataIntegrationToCheckPeople) {
        this.dataIntegrationToCheckPeople = dataIntegrationToCheckPeople;
    }

    public Date getDataIntegrationCheckDate() {
        return dataIntegrationCheckDate;
    }

    public String getDataIntegrationCheckDateStr() {
        return TimeStringUtils.timeToString(this.getDataIntegrationCheckDate());
    }

    public void setDataIntegrationCheckDate(Date dataIntegrationCheckDate) {
        this.dataIntegrationCheckDate = dataIntegrationCheckDate;
    }
}
