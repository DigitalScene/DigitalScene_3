package cn.digitalScene.Model;

import cn.digitalScene.Utils.ModuleStatus;
import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_photoedit")
public class PhotoEdit {

    @Id
    @GeneratedValue
    private Integer id;

    //2.原始图片编辑模块 photoEdit
    private String photoEditPeople="";//原始图片编辑者

    private String photoEditToAppointPeople="";//场景用户数据指派者

    private Date photoEditToAppointDate;//场景用户数据指派时间

    private Integer is_photoEditPeople=0;//原始图片编辑者确认(0为未确认，1为确认接受，2为已拒绝)

    private String photoEditPeople_reason="";//原始图片编辑者拒绝原因

    private String photoEditToCheckPeople="";//场景用户数据审核者

    private Date photoEditCheckDate;//场景用户数据审核时间

    private Date photoEditFinishDate;//原始图片编辑完成时间


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "photoEdit")
    private Project project;

    public String getPhotoEditPeople() {
        return photoEditPeople;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhotoEditPeople(String photoEditPeople) {
        this.photoEditPeople = photoEditPeople;
    }

    public Integer getIs_photoEditPeople() {
        return is_photoEditPeople;
    }

    public void setIs_photoEditPeople(Integer is_photoEditPeople) {
        this.is_photoEditPeople = is_photoEditPeople;
    }

    public String getPhotoEditPeople_reason() {
        return photoEditPeople_reason;
    }

    public void setPhotoEditPeople_reason(String photoEditPeople_reason) {
        this.photoEditPeople_reason = photoEditPeople_reason;
    }

    public Date getPhotoEditFinishDate() {
        return photoEditFinishDate;
    }

    public String getPhotoEditFinishDateStr() {
        return TimeStringUtils.timeToString(this.getPhotoEditFinishDate());
    }

    public void setPhotoEditFinishDate(Date photoEditFinishDate) {
        this.photoEditFinishDate = photoEditFinishDate;
    }

    public String getPhotoEditToAppointPeople() {
        return photoEditToAppointPeople;
    }

    public void setPhotoEditToAppointPeople(String photoEditToAppointPeople) {
        this.photoEditToAppointPeople = photoEditToAppointPeople;
    }

    public Date getPhotoEditToAppointDate() {
        return photoEditToAppointDate;
    }

    public String getPhotoEditToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getPhotoEditToAppointDate());
    }

    public void setPhotoEditToAppointDate(Date photoEditToAppointDate) {
        this.photoEditToAppointDate = photoEditToAppointDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getPhotoEditToCheckPeople() {
        return photoEditToCheckPeople;
    }

    public void setPhotoEditToCheckPeople(String photoEditToCheckPeople) {
        this.photoEditToCheckPeople = photoEditToCheckPeople;
    }

    public Date getPhotoEditCheckDate() {
        return photoEditCheckDate;
    }

    public String getPhotoEditCheckDateStr() {
        return TimeStringUtils.timeToString(this.getPhotoEditCheckDate());
    }

    public void setPhotoEditCheckDate(Date photoEditCheckDate) {
        this.photoEditCheckDate = photoEditCheckDate;
    }
}
