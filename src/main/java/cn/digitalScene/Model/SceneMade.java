package cn.digitalScene.Model;

import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_scenemade")
public class SceneMade {

    @Id
    @GeneratedValue
    private Integer id;

    //4.场景构建模块 sceneMade
    private String sceneMadePeople="";//场景构建者

    private String sceneMadeToAppointPeople="";//场景用户数据指派者

    private Date sceneMadeToAppointDate;//场景用户数据指派时间

    private Integer is_sceneMadePeople=0;//场景构建者确认(0为未确认，1为确认接受，2为已拒绝)

    private String sceneMadePeople_reason="";//场景构建者拒绝原因

    private String sceneMadeToCheckPeople="";//场景构建数据审核者

    private Date sceneMadeCheckDate;//场景构建数据审核时间

    private Date sceneMadeFinishDate;//场景构建完成时间


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "sceneMade")
    private Project project;

    public String getSceneMadePeople() {
        return sceneMadePeople;
    }

    public void setSceneMadePeople(String sceneMadePeople) {
        this.sceneMadePeople = sceneMadePeople;
    }

    public Integer getIs_sceneMadePeople() {
        return is_sceneMadePeople;
    }

    public void setIs_sceneMadePeople(Integer is_sceneMadePeople) {
        this.is_sceneMadePeople = is_sceneMadePeople;
    }

    public String getSceneMadePeople_reason() {
        return sceneMadePeople_reason;
    }

    public void setSceneMadePeople_reason(String sceneMadePeople_reason) {
        this.sceneMadePeople_reason = sceneMadePeople_reason;
    }

    public Date getSceneMadeFinishDate() {
        return sceneMadeFinishDate;
    }

    public String getSceneMadeFinishDateStr() {
        return TimeStringUtils.timeToString(this.getSceneMadeFinishDate());
    }

    public void setSceneMadeFinishDate(Date sceneMadeFinishDate) {
        this.sceneMadeFinishDate = sceneMadeFinishDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSceneMadeToAppointPeople() {
        return sceneMadeToAppointPeople;
    }

    public void setSceneMadeToAppointPeople(String sceneMadeToAppointPeople) {
        this.sceneMadeToAppointPeople = sceneMadeToAppointPeople;
    }

    public Date getSceneMadeToAppointDate() {
        return sceneMadeToAppointDate;
    }

    public String getSceneMadeToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getSceneMadeToAppointDate());
    }


    public void setSceneMadeToAppointDate(Date sceneMadeToAppointDate) {
        this.sceneMadeToAppointDate = sceneMadeToAppointDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSceneMadeToCheckPeople() {
        return sceneMadeToCheckPeople;
    }

    public void setSceneMadeToCheckPeople(String sceneMadeToCheckPeople) {
        this.sceneMadeToCheckPeople = sceneMadeToCheckPeople;
    }

    public Date getSceneMadeCheckDate() {
        return sceneMadeCheckDate;
    }

    public String getSceneMadeCheckDateStr() {
        return TimeStringUtils.timeToString(this.getSceneMadeCheckDate());
    }


    public void setSceneMadeCheckDate(Date sceneMadeCheckDate) {
        this.sceneMadeCheckDate = sceneMadeCheckDate;
    }
}
