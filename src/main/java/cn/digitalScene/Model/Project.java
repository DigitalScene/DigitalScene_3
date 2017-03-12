package cn.digitalScene.Model;

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

    private Integer status=0;//项目状态，整个项目是否完成 0为项目未开始，1为项目正在进行中，2为整个项目已完成

    private Integer isDel=0;//是否删除 0为未删除，1为删除，默认为0不删除

    //必须模块，有一定的顺序流程 1->2->3->4->5
    //1.用户数据上传模块 dataUpload
    private String dataUploadPeople="";//场景用户数据上传者

    private Integer is_dataUploadPeople=0;//场景用户数据上传者确认(0为未确认，1为确认接受，2为已拒绝)

    private String dataUploadPeople_reason="";//场景用户数据上传者拒绝原因

    private Date is_dataUploadPeopleDate;//场景用户数据上传者确认时间

    private Date dataUploadFinishDate;//场景用户数据上传完成时间

    private Integer is_dataUploadFinish=0;//场景用户数据上传完成(0为未开始，1为进行中，2为已完成)

    //2.原始图片编辑模块 photoEdit
    private String photoEditPeople="";//原始图片编辑者

    private Integer is_photoEditPeople=0;//原始图片编辑者确认(0为未确认，1为确认接受，2为已拒绝)

    private String photoEditPeople_reason="";//原始图片编辑者拒绝原因

    private Date is_photoEditPeopleDate;//原始图片编辑者确认时间

    private Date photoEditFinishDate;//原始图片编辑完成时间

    private Integer is_photoEditFinish=0;//原始图片编辑完成(0为未开始，1为进行中，2为已完成)

    //3.球形图制作模块 photoMade
    private String photoMadePeople="";//球形图制作者

    private Integer is_photoMadePeople=0;//球形图制作者确认(0为未确认，1为确认接受，2为已拒绝)

    private String photoMadePeople_reason="";//球形图制作者拒绝原因

    private Date is_photoMadePeopleDate;//球形图制作者确认时间

    private Date photoMadeFinishDate;//球形图制作完成时间

    private Integer is_photoMadeFinish=0;//球形图制作完成(0为未开始，1为进行中，2为已完成)

    //4.场景构建模块 sceneMade
    private String sceneMadePeople="";//场景构建者

    private Integer is_sceneMadePeople=0;//场景构建者确认(0为未确认，1为确认接受，2为已拒绝)

    private String sceneMadePeople_reason="";//场景构建者拒绝原因

    private Date is_sceneMadePeopleDate;//场景构建者确认时间

    private Date sceneMadeFinishDate;//场景构建完成时间

    private Integer is_sceneMadeFinish=0;//场景构建完成(0为未开始，1为进行中，2为已完成)

    //5.数据整合模块 dataIntegration
    private String dataIntegrationPeople="";//数据整合者

    private Integer is_dataIntegrationPeople=0;//数据整合者确认(0为未确认，1为确认接受，2为已拒绝)

    private String dataIntegrationPeople_reason="";//数据整合者拒绝原因

    private Date is_dataIntegrationPeopleDate;//数据整合者确认时间

    private Date dataIntegrationFinishDate;//数据整合完成时间

    private Integer is_dataIntegrationFinish=0;//数据整合完成(0为未开始，1为进行中，2为已完成)

    //非必须模块  没有一定的顺序流程，可能是同时进行 6,7,8,9
    //6.音频文件编辑模块 mp3Edit
    private String mp3EditPeople="";//音频文件编辑者

    private Integer is_mp3EditPeople=0;//音频文件编辑者确认(0为未确认，1为确认接受，2为已拒绝)

    private String mp3EditPeople_reason="";//音频文件编辑者拒绝原因

    private Date is_mp3EditPeopleDate;//音频文件编辑者确认时间

    private Date mp3EditFinishDate;//音频文件编辑完成时间

    private Integer is_mp3EditFinish=3;//音频文件编辑完成(0为未开始，1为进行中，2为已完成，3为不需要)

    //7.视频文件编辑模块 videoEdit
    private String videoEditPeople="";//视频文件编辑者

    private Integer is_videoEditPeople=0;//视频文件编辑者确认(0为未确认，1为确认接受，2为已拒绝)

    private String videoEditPeople_reason="";//视频文件编辑者拒绝原因

    private Date is_videoEditPeopleDate;//视频文件编辑者确认时间

    private Date videoEditFinishDate;//视频文件编辑完成时间

    private Integer is_videoEditFinish=3;//视频文件编辑完成(0为未开始，1为进行中，2为已完成，3为不需要)

    //8.3D模型制作模块 thrDModelMade
    private String thrDModelMadePeople="";//3D模型制作者

    private Integer is_thrDModelMadePeople=0;//3D模型制作者确认(0为未确认，1为确认接受，2为已拒绝)

    private String thrDModelMadePeople_reason="";//3D模型制作者拒绝原因

    private Date is_thrDModelMadePeopleDate;//3D模型制作者确认时间

    private Date thrDModelMadeFinishDate;//3D模型制作完成时间

    private Integer is_thrDModelMadeFinish=3;//3D模型制作完成(0为未开始，1为进行中，2为已完成，3为不需要)

    //9.字幕文件编辑模块 subtitleEdit
    private String subtitleEditPeople="";//字幕文件编辑者

    private Integer is_subtitleEditPeople=0;//字幕文件编辑者确认(0为未确认，1为确认接受，2为已拒绝)

    private String subtitleEditPeople_reason="";//字幕文件编辑者拒绝原因

    private Date is_subtitleEditPeopleDate;//字幕文件编辑者确认时间

    private Date subtitleEditFinishDate;//字幕文件编辑完成时间

    private Integer is_subtitleEditFinish=3;//字幕文件编辑完成(0为未开始，1为进行中，2为已完成，3为不需要)


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
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(this.getCreateTime());
    }

    public Integer getStatus() {
        return status;
    }

    public String getProjectStatus() {
        return ProjectStatus.getDescByValue(status);
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDataUploadPeople() {
        return dataUploadPeople;
    }

    public void setDataUploadPeople(String dataUploadPeople) {
        this.dataUploadPeople = dataUploadPeople;
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

    public Date getIs_dataUploadPeopleDate() {
        return is_dataUploadPeopleDate;
    }

    public void setIs_dataUploadPeopleDate(Date is_dataUploadPeopleDate) {
        this.is_dataUploadPeopleDate = is_dataUploadPeopleDate;
    }

    public Date getDataUploadFinishDate() {
        return dataUploadFinishDate;
    }

    public void setDataUploadFinishDate(Date dataUploadFinishDate) {
        this.dataUploadFinishDate = dataUploadFinishDate;
    }

    public Integer getIs_dataUploadFinish() {
        return is_dataUploadFinish;
    }

    public String getIs_dataUploadStatus() {
        return ProjectStatus.getDescByValue(is_dataUploadFinish);
    }

    public void setIs_dataUploadFinish(Integer is_dataUploadFinish) {
        this.is_dataUploadFinish = is_dataUploadFinish;
    }

    public String getPhotoEditPeople() {
        return photoEditPeople;
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

    public Date getIs_photoEditPeopleDate() {
        return is_photoEditPeopleDate;
    }

    public void setIs_photoEditPeopleDate(Date is_photoEditPeopleDate) {
        this.is_photoEditPeopleDate = is_photoEditPeopleDate;
    }

    public Date getPhotoEditFinishDate() {
        return photoEditFinishDate;
    }

    public void setPhotoEditFinishDate(Date photoEditFinishDate) {
        this.photoEditFinishDate = photoEditFinishDate;
    }

    public Integer getIs_photoEditFinish() {
        return is_photoEditFinish;
    }

    public String getIs_photoEditStatus() {
        return ProjectStatus.getDescByValue(is_photoEditFinish);
    }

    public void setIs_photoEditFinish(Integer is_photoEditFinish) {
        this.is_photoEditFinish = is_photoEditFinish;
    }

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

    public Date getIs_photoMadePeopleDate() {
        return is_photoMadePeopleDate;
    }

    public void setIs_photoMadePeopleDate(Date is_photoMadePeopleDate) {
        this.is_photoMadePeopleDate = is_photoMadePeopleDate;
    }

    public Date getPhotoMadeFinishDate() {
        return photoMadeFinishDate;
    }

    public void setPhotoMadeFinishDate(Date photoMadeFinishDate) {
        this.photoMadeFinishDate = photoMadeFinishDate;
    }

    public Integer getIs_photoMadeFinish() {
        return is_photoMadeFinish;
    }

    public String getIs_photoMadeStatus() {
        return ProjectStatus.getDescByValue(is_photoMadeFinish);
    }

    public void setIs_photoMadeFinish(Integer is_photoMadeFinish) {
        this.is_photoMadeFinish = is_photoMadeFinish;
    }

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

    public Date getIs_sceneMadePeopleDate() {
        return is_sceneMadePeopleDate;
    }

    public void setIs_sceneMadePeopleDate(Date is_sceneMadePeopleDate) {
        this.is_sceneMadePeopleDate = is_sceneMadePeopleDate;
    }

    public Date getSceneMadeFinishDate() {
        return sceneMadeFinishDate;
    }

    public void setSceneMadeFinishDate(Date sceneMadeFinishDate) {
        this.sceneMadeFinishDate = sceneMadeFinishDate;
    }

    public Integer getIs_sceneMadeFinish() {
        return is_sceneMadeFinish;
    }

    public String getIs_sceneMadeStatus() {
        return ProjectStatus.getDescByValue(is_sceneMadeFinish);
    }

    public void setIs_sceneMadeFinish(Integer is_sceneMadeFinish) {
        this.is_sceneMadeFinish = is_sceneMadeFinish;
    }

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

    public Date getIs_dataIntegrationPeopleDate() {
        return is_dataIntegrationPeopleDate;
    }

    public void setIs_dataIntegrationPeopleDate(Date is_dataIntegrationPeopleDate) {
        this.is_dataIntegrationPeopleDate = is_dataIntegrationPeopleDate;
    }

    public Date getDataIntegrationFinishDate() {
        return dataIntegrationFinishDate;
    }

    public void setDataIntegrationFinishDate(Date dataIntegrationFinishDate) {
        this.dataIntegrationFinishDate = dataIntegrationFinishDate;
    }

    public Integer getIs_dataIntegrationFinish() {
        return is_dataIntegrationFinish;
    }

    public String getIs_dataIntegrationStatus() {
        return ProjectStatus.getDescByValue(is_dataIntegrationFinish);
    }

    public void setIs_dataIntegrationFinish(Integer is_dataIntegrationFinish) {
        this.is_dataIntegrationFinish = is_dataIntegrationFinish;
    }

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

    public Date getIs_mp3EditPeopleDate() {
        return is_mp3EditPeopleDate;
    }

    public void setIs_mp3EditPeopleDate(Date is_mp3EditPeopleDate) {
        this.is_mp3EditPeopleDate = is_mp3EditPeopleDate;
    }

    public Date getMp3EditFinishDate() {
        return mp3EditFinishDate;
    }

    public void setMp3EditFinishDate(Date mp3EditFinishDate) {
        this.mp3EditFinishDate = mp3EditFinishDate;
    }

    public Integer getIs_mp3EditFinish() {
        return is_mp3EditFinish;
    }

    public String getIs_mp3EditStatus() {
        return ProjectStatus.getDescByValue(is_mp3EditFinish);
    }

    public void setIs_mp3EditFinish(Integer is_mp3EditFinish) {
        this.is_mp3EditFinish = is_mp3EditFinish;
    }

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

    public Date getIs_videoEditPeopleDate() {
        return is_videoEditPeopleDate;
    }

    public void setIs_videoEditPeopleDate(Date is_videoEditPeopleDate) {
        this.is_videoEditPeopleDate = is_videoEditPeopleDate;
    }

    public Date getVideoEditFinishDate() {
        return videoEditFinishDate;
    }

    public void setVideoEditFinishDate(Date videoEditFinishDate) {
        this.videoEditFinishDate = videoEditFinishDate;
    }

    public Integer getIs_videoEditFinish() {
        return is_videoEditFinish;
    }

    public String getIs_videoEditStatus() {
        return ProjectStatus.getDescByValue(is_videoEditFinish);
    }

    public void setIs_videoEditFinish(Integer is_videoEditFinish) {
        this.is_videoEditFinish = is_videoEditFinish;
    }

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

    public Date getIs_thrDModelMadePeopleDate() {
        return is_thrDModelMadePeopleDate;
    }

    public void setIs_thrDModelMadePeopleDate(Date is_thrDModelMadePeopleDate) {
        this.is_thrDModelMadePeopleDate = is_thrDModelMadePeopleDate;
    }

    public Date getThrDModelMadeFinishDate() {
        return thrDModelMadeFinishDate;
    }

    public void setThrDModelMadeFinishDate(Date thrDModelMadeFinishDate) {
        this.thrDModelMadeFinishDate = thrDModelMadeFinishDate;
    }

    public Integer getIs_thrDModelMadeFinish() {
        return is_thrDModelMadeFinish;
    }

    public String getIs_thrDModelMadeStatus() {
        return ProjectStatus.getDescByValue(is_thrDModelMadeFinish);
    }

    public void setIs_thrDModelMadeFinish(Integer is_thrDModelMadeFinish) {
        this.is_thrDModelMadeFinish = is_thrDModelMadeFinish;
    }

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

    public Date getIs_subtitleEditPeopleDate() {
        return is_subtitleEditPeopleDate;
    }

    public void setIs_subtitleEditPeopleDate(Date is_subtitleEditPeopleDate) {
        this.is_subtitleEditPeopleDate = is_subtitleEditPeopleDate;
    }

    public Date getSubtitleEditFinishDate() {
        return subtitleEditFinishDate;
    }

    public void setSubtitleEditFinishDate(Date subtitleEditFinishDate) {
        this.subtitleEditFinishDate = subtitleEditFinishDate;
    }

    public Integer getIs_subtitleEditFinish() {
        return is_subtitleEditFinish;
    }

    public String getIs_subtitleEditStatus() {
        return ProjectStatus.getDescByValue(is_subtitleEditFinish);
    }

    public void setIs_subtitleEditFinish(Integer is_subtitleEditFinish) {
        this.is_subtitleEditFinish = is_subtitleEditFinish;
    }

    //枚举
    public static enum ProjectStatus{
         NOTSTART(0,"未开始"),PROGRESSING(1,"进行中"),FINISH(2,"已完成"),NONEED(3,"不需要");

        private Integer value;
        private String description;

        ProjectStatus(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        public static ProjectStatus getByValue(Integer value){
            for (ProjectStatus s:ProjectStatus.values()){
                if (s.value.equals(value)){
                    return s;
                }
            }
            return null;
        }

        public static String getNameByValue(Integer value) {
            ProjectStatus s = getByValue(value);
            return s == null ? null : s.name();
        }

        public static String getDescByValue(Integer value) {
            ProjectStatus s = getByValue(value);
            return s == null ? null : s.getDescription();
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


}



