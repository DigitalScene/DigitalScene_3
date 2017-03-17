package cn.digitalScene.Model;

import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_subtitleedit")
public class SubtitleEdit {

    @Id
    @GeneratedValue
    private Integer id;

    //9.字幕文件编辑模块 subtitleEdit
    private String subtitleEditPeople="";//字幕文件编辑者

    private String subtitleEditToAppointPeople="";//场景用户数据指派者

    private Date subtitleEditToAppointDate;//场景用户数据指派时间

    private Integer is_subtitleEditPeople=0;//字幕文件编辑者确认(0为未确认，1为确认接受，2为已拒绝)

    private String subtitleEditPeople_reason="";//字幕文件编辑者拒绝原因

    private String subtitleEditToCheckPeople="";//字幕文件编辑审核者

    private Date subtitleEditCheckDate;//字幕文件编辑审核时间

    private Date subtitleEditFinishDate;//字幕文件编辑完成时间


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "subtitleEdit")
    private Project project;

    public String getSubtitleEditPeople() {
        return subtitleEditPeople;
    }

    public void setSubtitleEditPeople(String subtitleEditPeople) {
        this.subtitleEditPeople = subtitleEditPeople;
    }

    public Integer getIs_subtitleEditPeople() {
        return is_subtitleEditPeople;
    }

    public void setIs_subtitleEditPeople(Integer is_subtitleEditPeople) {
        this.is_subtitleEditPeople = is_subtitleEditPeople;
    }

    public String getSubtitleEditPeople_reason() {
        return subtitleEditPeople_reason;
    }

    public void setSubtitleEditPeople_reason(String subtitleEditPeople_reason) {
        this.subtitleEditPeople_reason = subtitleEditPeople_reason;
    }

    public Date getSubtitleEditFinishDate() {
        return subtitleEditFinishDate;
    }

    public String getSubtitleEditFinishDateStr() {
        return TimeStringUtils.timeToString(this.getSubtitleEditFinishDate());
    }

    public void setSubtitleEditFinishDate(Date subtitleEditFinishDate) {
        this.subtitleEditFinishDate = subtitleEditFinishDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubtitleEditToAppointPeople() {
        return subtitleEditToAppointPeople;
    }

    public void setSubtitleEditToAppointPeople(String subtitleEditToAppointPeople) {
        this.subtitleEditToAppointPeople = subtitleEditToAppointPeople;
    }

    public Date getSubtitleEditToAppointDate() {
        return subtitleEditToAppointDate;
    }

    public String getSubtitleEditToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getSubtitleEditToAppointDate());
    }

    public void setSubtitleEditToAppointDate(Date subtitleEditToAppointDate) {
        this.subtitleEditToAppointDate = subtitleEditToAppointDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSubtitleEditToCheckPeople() {
        return subtitleEditToCheckPeople;
    }

    public void setSubtitleEditToCheckPeople(String subtitleEditToCheckPeople) {
        this.subtitleEditToCheckPeople = subtitleEditToCheckPeople;
    }

    public Date getSubtitleEditCheckDate() {
        return subtitleEditCheckDate;
    }

    public String getSubtitleEditCheckDateStr() {
        return TimeStringUtils.timeToString(this.getSubtitleEditCheckDate());
    }

    public void setSubtitleEditCheckDate(Date subtitleEditCheckDate) {
        this.subtitleEditCheckDate = subtitleEditCheckDate;
    }
}
