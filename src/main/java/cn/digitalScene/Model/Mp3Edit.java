package cn.digitalScene.Model;

import cn.digitalScene.Utils.ModuleStatus;
import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_mp3edit")
public class Mp3Edit {

    @Id
    @GeneratedValue
    private Integer id;

    //非必须模块  没有一定的顺序流程，可能是同时进行 6,7,8,9
    //6.音频文件编辑模块 mp3Edit
    private String mp3EditPeople="";//音频文件编辑者

    private String mp3EditToAppointPeople="";//场景用户数据指派者

    private Date mp3EditToAppointDate;//场景用户数据指派时间

    private Integer is_mp3EditPeople=0;//音频文件编辑者确认(0为未确认，1为确认接受，2为已拒绝)

    private String mp3EditPeople_reason="";//音频文件编辑者拒绝原因

    private String mp3EditToCheckPeople="";//音频文件编辑审核者

    private Date mp3EditCheckDate;//音频文件编辑审核时间

    private Date mp3EditFinishDate;//音频文件编辑完成时间


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "mp3Edit")
    private Project project;

    public String getMp3EditPeople() {
        return mp3EditPeople;
    }

    public void setMp3EditPeople(String mp3EditPeople) {
        this.mp3EditPeople = mp3EditPeople;
    }

    public Integer getIs_mp3EditPeople() {
        return is_mp3EditPeople;
    }

    public void setIs_mp3EditPeople(Integer is_mp3EditPeople) {
        this.is_mp3EditPeople = is_mp3EditPeople;
    }

    public String getMp3EditPeople_reason() {
        return mp3EditPeople_reason;
    }

    public void setMp3EditPeople_reason(String mp3EditPeople_reason) {
        this.mp3EditPeople_reason = mp3EditPeople_reason;
    }

    public Date getMp3EditFinishDate() {
        return mp3EditFinishDate;
    }

    public String getMp3EditFinishDateStr() {
        return TimeStringUtils.timeToString(this.getMp3EditFinishDate());
    }

    public void setMp3EditFinishDate(Date mp3EditFinishDate) {
        this.mp3EditFinishDate = mp3EditFinishDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMp3EditToAppointPeople() {
        return mp3EditToAppointPeople;
    }

    public void setMp3EditToAppointPeople(String mp3EditToAppointPeople) {
        this.mp3EditToAppointPeople = mp3EditToAppointPeople;
    }

    public Date getMp3EditToAppointDate() {
        return mp3EditToAppointDate;
    }

    public String getMp3EditToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getMp3EditToAppointDate());
    }

    public void setMp3EditToAppointDate(Date mp3EditToAppointDate) {
        this.mp3EditToAppointDate = mp3EditToAppointDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getMp3EditToCheckPeople() {
        return mp3EditToCheckPeople;
    }

    public void setMp3EditToCheckPeople(String mp3EditToCheckPeople) {
        this.mp3EditToCheckPeople = mp3EditToCheckPeople;
    }

    public Date getMp3EditCheckDate() {
        return mp3EditCheckDate;
    }

    public String getMp3EditCheckDateStr() {
        return TimeStringUtils.timeToString(this.getMp3EditCheckDate());
    }

    public void setMp3EditCheckDate(Date mp3EditCheckDate) {
        this.mp3EditCheckDate = mp3EditCheckDate;
    }
}
