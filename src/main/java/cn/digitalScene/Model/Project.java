package cn.digitalScene.Model;

import cn.digitalScene.Utils.ModuleStatus;
import cn.digitalScene.Utils.TimeStringUtils;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 25065 on 2017/3/10.
 */
@Entity
@Table(name = "ds_project")
public class Project {

    @Id
    @GeneratedValue
    private Integer id;

    private String projectName;//项目名

    @Column(length = 1000)
    private String description;//项目描述

    private String creator;//创建者

    private Date createTime;//项目创建时间

    private Integer status=0;//项目状态，整个项目是否完成 0为项目未开始，3为项目正在进行中，6为整个项目已完成

    private Integer isDel=0;//是否删除 0为未删除，1为删除，默认为0不删除

    //必须模块，有一定的顺序流程 1->2->3->4->5
    //1.用户数据上传模块 dataUpload
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "dataupload_id")
    private DataUpload dataUpload;

    private Integer is_dataUploadStatus=0;//场景用户数据上传状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)

    //2.原始图片编辑模块 photoEdit
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "photoedit_id")
    private PhotoEdit photoEdit;

    private Integer is_photoEditStatus=0;//原始图片编辑状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)

    //3.球形图制作模块 photoMade
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "photomade_id")
    private PhotoMade photoMade;

    private Integer is_photoMadeStatus=0;//球形图制作状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)

    //4.场景构建模块 sceneMade
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "scenemade_id")
    private SceneMade sceneMade;

    private Integer is_sceneMadeStatus=0;//场景构建状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)

    //5.数据整合模块 dataIntegration
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "dataintegration_id")
    private DataIntegration dataIntegration;

    private Integer is_dataIntegrationStatus=0;//数据整合状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)

    //非必须模块  没有一定的顺序流程，可能是同时进行 6,7,8,9
    //6.音频文件编辑模块 mp3Edit
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "mp3edit_id")
    private Mp3Edit mp3Edit;

    private Integer is_mp3EditStatus=6;//音频文件编辑状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)

    //7.视频文件编辑模块 videoEdit
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "videoedit_id")
    private VideoEdit videoEdit;

    private Integer is_videoEditStatus=6;//视频文件编辑状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)

    //8.3D模型制作模块 thrDModelMade
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "thrdmodelmade_id")
    private ThrDModelMade thrDModelMade;

    private Integer is_thrDModelMadeStatus=6;//3D模型制作状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)

    //9.字幕文件编辑模块 subtitleEdit
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "subtitleedit_id")
    private SubtitleEdit subtitleEdit;

    private Integer is_subtitleEditStatus=6;//字幕文件编辑状态(0为未开始，1为待指派，2为指派中，3为进行中，4为待审核，5为已完成，6为不需要)


    public Project() {
    }

    public Project(String projectName, String description, String creator, Date createTime, Integer status) {
        this.projectName = projectName;
        this.description = description;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeString(){
        return TimeStringUtils.timeToString(this.getCreateTime());
    }

    public Integer getStatus() {
        return status;
    }

    public String getProjectStatus() {
        return ModuleStatus.getDescByValue(status);
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DataUpload getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(DataUpload dataUpload) {
        this.dataUpload = dataUpload;
    }

    public SceneMade getSceneMade() {
        return sceneMade;
    }

    public void setSceneMade(SceneMade sceneMade) {
        this.sceneMade = sceneMade;
    }

    public DataIntegration getDataIntegration() {
        return dataIntegration;
    }

    public void setDataIntegration(DataIntegration dataIntegration) {
        this.dataIntegration = dataIntegration;
    }

    public Mp3Edit getMp3Edit() {
        return mp3Edit;
    }

    public void setMp3Edit(Mp3Edit mp3Edit) {
        this.mp3Edit = mp3Edit;
    }

    public VideoEdit getVideoEdit() {
        return videoEdit;
    }

    public void setVideoEdit(VideoEdit videoEdit) {
        this.videoEdit = videoEdit;
    }

    public ThrDModelMade getThrDModelMade() {
        return thrDModelMade;
    }

    public void setThrDModelMade(ThrDModelMade thrDModelMade) {
        this.thrDModelMade = thrDModelMade;
    }

    public SubtitleEdit getSubtitleEdit() {
        return subtitleEdit;
    }

    public void setSubtitleEdit(SubtitleEdit subtitleEdit) {
        this.subtitleEdit = subtitleEdit;
    }

    public PhotoEdit getPhotoEdit() {
        return photoEdit;
    }

    public void setPhotoEdit(PhotoEdit photoEdit) {
        this.photoEdit = photoEdit;
    }

    public PhotoMade getPhotoMade() {
        return photoMade;
    }

    public void setPhotoMade(PhotoMade photoMade) {
        this.photoMade = photoMade;
    }

    public Integer getIs_dataUploadStatus() {
        return is_dataUploadStatus;
    }

    public void setIs_dataUploadStatus(Integer is_dataUploadStatus) {
        this.is_dataUploadStatus = is_dataUploadStatus;
    }

    public String getDataUploadStatus() {
        return ModuleStatus.getDescByValue(is_dataUploadStatus);
    }

    public Integer getIs_photoEditStatus() {
        return is_photoEditStatus;
    }

    public void setIs_photoEditStatus(Integer is_photoEditStatus) {
        this.is_photoEditStatus = is_photoEditStatus;
    }

    public String getPhotoEditStatus() {
        return ModuleStatus.getDescByValue(is_photoEditStatus);
    }

    public Integer getIs_photoMadeStatus() {
        return is_photoMadeStatus;
    }

    public void setIs_photoMadeStatus(Integer is_photoMadeStatus) {
        this.is_photoMadeStatus = is_photoMadeStatus;
    }

    public String getPhotoMadeStatus() {
        return ModuleStatus.getDescByValue(is_photoMadeStatus);
    }

    public Integer getIs_sceneMadeStatus() {
        return is_sceneMadeStatus;
    }

    public void setIs_sceneMadeStatus(Integer is_sceneMadeStatus) {
        this.is_sceneMadeStatus = is_sceneMadeStatus;
    }

    public String getSceneMadeStatus() {
        return ModuleStatus.getDescByValue(is_sceneMadeStatus);
    }

    public Integer getIs_dataIntegrationStatus() {
        return is_dataIntegrationStatus;
    }

    public void setIs_dataIntegrationStatus(Integer is_dataIntegrationStatus) {
        this.is_dataIntegrationStatus = is_dataIntegrationStatus;
    }

    public String getDataIntegrationStatus() {
        return ModuleStatus.getDescByValue(is_dataIntegrationStatus);
    }

    public Integer getIs_mp3EditStatus() {
        return is_mp3EditStatus;
    }

    public void setIs_mp3EditStatus(Integer is_mp3EditStatus) {
        this.is_mp3EditStatus = is_mp3EditStatus;
    }

    public String getMp3EditStatus() {
        return ModuleStatus.getDescByValue(is_mp3EditStatus);
    }

    public Integer getIs_videoEditStatus() {
        return is_videoEditStatus;
    }

    public void setIs_videoEditStatus(Integer is_videoEditStatus) {
        this.is_videoEditStatus = is_videoEditStatus;
    }

    public String getVideoEditStatus() {
        return ModuleStatus.getDescByValue(is_videoEditStatus);
    }

    public Integer getIs_thrDModelMadeStatus() {
        return is_thrDModelMadeStatus;
    }

    public void setIs_thrDModelMadeStatus(Integer is_thrDModelMadeStatus) {
        this.is_thrDModelMadeStatus = is_thrDModelMadeStatus;
    }

    public String getThrDModelMadeStatus() {
        return ModuleStatus.getDescByValue(is_thrDModelMadeStatus);
    }

    public Integer getIs_subtitleEditStatus() {
        return is_subtitleEditStatus;
    }

    public void setIs_subtitleEditStatus(Integer is_subtitleEditStatus) {
        this.is_subtitleEditStatus = is_subtitleEditStatus;
    }

    public String getSubtitleEditStatus() {
        return ModuleStatus.getDescByValue(is_subtitleEditStatus);
    }
}



