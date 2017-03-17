package cn.digitalScene.Model;

import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_thrdmodelmade")
public class ThrDModelMade {

    @Id
    @GeneratedValue
    private Integer id;

    //8.3D模型制作模块 thrDModelMade
    private String thrDModelMadePeople="";//3D模型制作者

    private String thrDModelMadeToAppointPeople="";//场景用户数据指派者

    private Date thrDModelMadeToAppointDate;//场景用户数据指派时间

    private Integer is_thrDModelMadePeople=0;//3D模型制作者确认(0为未确认，1为确认接受，2为已拒绝)

    private String thrDModelMadePeople_reason="";//3D模型制作者拒绝原因

    private String thrDModelMadeToCheckPeople="";//3D模型制作编辑审核者

    private Date thrDModelMadeCheckDate;//3D模型制作编辑审核时间

    private Date thrDModelMadeFinishDate;//3D模型制作完成时间

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "thrDModelMade")
    private Project project;

    public String getThrDModelMadePeople() {
        return thrDModelMadePeople;
    }

    public void setThrDModelMadePeople(String thrDModelMadePeople) {
        this.thrDModelMadePeople = thrDModelMadePeople;
    }

    public Integer getIs_thrDModelMadePeople() {
        return is_thrDModelMadePeople;
    }

    public void setIs_thrDModelMadePeople(Integer is_thrDModelMadePeople) {
        this.is_thrDModelMadePeople = is_thrDModelMadePeople;
    }

    public String getThrDModelMadePeople_reason() {
        return thrDModelMadePeople_reason;
    }

    public void setThrDModelMadePeople_reason(String thrDModelMadePeople_reason) {
        this.thrDModelMadePeople_reason = thrDModelMadePeople_reason;
    }

    public Date getThrDModelMadeFinishDate() {
        return thrDModelMadeFinishDate;
    }

    public String getThrDModelMadeFinishDateStr() {
        return TimeStringUtils.timeToString(this.getThrDModelMadeFinishDate());
    }

    public void setThrDModelMadeFinishDate(Date thrDModelMadeFinishDate) {
        this.thrDModelMadeFinishDate = thrDModelMadeFinishDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThrDModelMadeToAppointPeople() {
        return thrDModelMadeToAppointPeople;
    }

    public void setThrDModelMadeToAppointPeople(String thrDModelMadeToAppointPeople) {
        this.thrDModelMadeToAppointPeople = thrDModelMadeToAppointPeople;
    }

    public Date getThrDModelMadeToAppointDate() {
        return thrDModelMadeToAppointDate;
    }

    public String getThrDModelMadeToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getThrDModelMadeToAppointDate());
    }

    public void setThrDModelMadeToAppointDate(Date thrDModelMadeToAppointDate) {
        this.thrDModelMadeToAppointDate = thrDModelMadeToAppointDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getThrDModelMadeToCheckPeople() {
        return thrDModelMadeToCheckPeople;
    }

    public void setThrDModelMadeToCheckPeople(String thrDModelMadeToCheckPeople) {
        this.thrDModelMadeToCheckPeople = thrDModelMadeToCheckPeople;
    }

    public Date getThrDModelMadeCheckDate() {
        return thrDModelMadeCheckDate;
    }

    public String getThrDModelMadeCheckDateStr() {
        return TimeStringUtils.timeToString(this.getThrDModelMadeCheckDate());
    }

    public void setThrDModelMadeCheckDate(Date thrDModelMadeCheckDate) {
        this.thrDModelMadeCheckDate = thrDModelMadeCheckDate;
    }
}
