package cn.digitalScene.Model;

import cn.digitalScene.Utils.ModuleStatus;
import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
@Entity
@Table(name = "ds_photomade")
public class PhotoMade {

    @Id
    @GeneratedValue
    private Integer id;

    //3.球形图制作模块 photoMade
    private String photoMadePeople="";//球形图制作者

    private String photoMadeToAppointPeople="";//场景用户数据指派者

    private Date photoMadeToAppointDate;//场景用户数据指派时间

    private Integer is_photoMadePeople=0;//球形图制作者确认(0为未确认，1为确认接受，2为已拒绝)

    private String photoMadePeople_reason="";//球形图制作者拒绝原因

    private String photoMadeToCheckPeople="";//场景用户数据审核者

    private Date photoMadeCheckDate;//场景用户数据审核时间

    private Date photoMadeFinishDate;//球形图制作完成时间


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "photoMade")
    private Project project;

    public String getPhotoMadePeople() {
        return photoMadePeople;
    }

    public void setPhotoMadePeople(String photoMadePeople) {
        this.photoMadePeople = photoMadePeople;
    }

    public Integer getIs_photoMadePeople() {
        return is_photoMadePeople;
    }

    public void setIs_photoMadePeople(Integer is_photoMadePeople) {
        this.is_photoMadePeople = is_photoMadePeople;
    }

    public String getPhotoMadePeople_reason() {
        return photoMadePeople_reason;
    }

    public void setPhotoMadePeople_reason(String photoMadePeople_reason) {
        this.photoMadePeople_reason = photoMadePeople_reason;
    }

    public Date getPhotoMadeFinishDate() {
        return photoMadeFinishDate;
    }

    public String getPhotoMadeFinishDateStr() {
        return TimeStringUtils.timeToString(this.getPhotoMadeFinishDate());
    }


    public void setPhotoMadeFinishDate(Date photoMadeFinishDate) {
        this.photoMadeFinishDate = photoMadeFinishDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoMadeToAppointPeople() {
        return photoMadeToAppointPeople;
    }

    public void setPhotoMadeToAppointPeople(String photoMadeToAppointPeople) {
        this.photoMadeToAppointPeople = photoMadeToAppointPeople;
    }

    public Date getPhotoMadeToAppointDate() {
        return photoMadeToAppointDate;
    }

    public String getPhotoMadeToAppointDateStr() {
        return TimeStringUtils.timeToString(this.getPhotoMadeToAppointDate());
    }

    public void setPhotoMadeToAppointDate(Date photoMadeToAppointDate) {
        this.photoMadeToAppointDate = photoMadeToAppointDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getPhotoMadeToCheckPeople() {
        return photoMadeToCheckPeople;
    }

    public void setPhotoMadeToCheckPeople(String PhotoMadeToCheckPeople) {
        this.photoMadeToCheckPeople = photoMadeToCheckPeople;
    }

    public Date getPhotoMadeCheckDate() {
        return photoMadeCheckDate;
    }

    public String getPhotoMadeCheckDateStr() {
        return TimeStringUtils.timeToString(this.getPhotoMadeCheckDate());
    }

    public void setPhotoMadeCheckDate(Date photoMadeCheckDate) {
        this.photoMadeCheckDate = photoMadeCheckDate;
    }
}
