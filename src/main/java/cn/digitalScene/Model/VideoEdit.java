package cn.digitalScene.Model;

import cn.digitalScene.Utils.ModuleStatus;
import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_videoedit")
public class VideoEdit {
    @Id
    @GeneratedValue
    private Integer id;

    //7.视频文件编辑模块 videoEdit
    private String videoEditPeople="";//视频文件编辑者

    private String videoEditToAppointPeople="";//场景用户数据指派者

    private Date videoEditToAppointDate;//场景用户数据指派时间

    private Integer is_videoEditPeople=0;//视频文件编辑者确认(0为未确认，1为确认接受，2为已拒绝)

    private String videoEditPeople_reason="";//视频文件编辑者拒绝原因

    private String videoEditToCheckPeople="";//视频文件编辑审核者

    private Date videoEditCheckDate;//视频文件编辑审核时间

    private Date videoEditFinishDate;//视频文件编辑完成时间

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "videoEdit")
    private Project project;

    public String getVideoEditPeople() {
        return videoEditPeople;
    }

    public void setVideoEditPeople(String videoEditPeople) {
        this.videoEditPeople = videoEditPeople;
    }

    public Integer getIs_videoEditPeople() {
        return is_videoEditPeople;
    }

    public void setIs_videoEditPeople(Integer is_videoEditPeople) {
        this.is_videoEditPeople = is_videoEditPeople;
    }

    public String getVideoEditPeople_reason() {
        return videoEditPeople_reason;
    }

    public void setVideoEditPeople_reason(String videoEditPeople_reason) {
        this.videoEditPeople_reason = videoEditPeople_reason;
    }

    public String getVideoEditFinishDateStr() {
        return TimeStringUtils.timeToString(this.getVideoEditFinishDate());
    }

    public Date getVideoEditFinishDate() {
        return videoEditFinishDate;
    }

    public void setVideoEditFinishDate(Date videoEditFinishDate) {
        this.videoEditFinishDate = videoEditFinishDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoEditToAppointPeople() {
        return videoEditToAppointPeople;
    }

    public void setVideoEditToAppointPeople(String videoEditToAppointPeople) {
        this.videoEditToAppointPeople = videoEditToAppointPeople;
    }

    public Date getVideoEditToAppointDate() {
        return videoEditToAppointDate;
    }

    public String getVideoEditToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getVideoEditToAppointDate());
    }

    public void setVideoEditToAppointDate(Date videoEditToAppointDate) {
        this.videoEditToAppointDate = videoEditToAppointDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getVideoEditToCheckPeople() {
        return videoEditToCheckPeople;
    }

    public void setVideoEditToCheckPeople(String videoEditToCheckPeople) {
        this.videoEditToCheckPeople = videoEditToCheckPeople;
    }

    public Date getVideoEditCheckDate() {
        return videoEditCheckDate;
    }

    public String getVideoEditCheckDateStr() {
        return TimeStringUtils.timeToString(this.getVideoEditCheckDate());
    }

    public void setVideoEditCheckDate(Date videoEditCheckDate) {
        this.videoEditCheckDate = videoEditCheckDate;
    }
}
