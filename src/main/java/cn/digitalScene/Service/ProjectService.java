package cn.digitalScene.Service;

import cn.digitalScene.Model.Project;
import cn.digitalScene.Repository.*;
import cn.digitalScene.Utils.StringUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections.list.PredicatedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 25065 on 2017/3/11.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DataUploadRepository dataUploadRepository;
    @Autowired
    private PhotoEditRepository photoEditRepository;
    @Autowired
    private PhotoMadeRepository photoMadeRepository;
    @Autowired
    private SceneMadeRepository sceneMadeRepository;
    @Autowired
    private DataIntegrationRepository dataIntegrationRepository;
    @Autowired
    private Mp3EditRepository mp3EditRepository;
    @Autowired
    private VideoEditRepository videoEditRepository;
    @Autowired
    private ThrDModelMadeRepository thrDModelMadeRepository;
    @Autowired
    private SubtitleEditRepository subtitleEditRepository;

    @Transactional
    public void delete(Integer id){
        projectRepository.deleteByPrimaryKey(id);
    }

    public void save(Project project){
        projectRepository.save(project);
    }

    //查找所有项目
    public Page<Project> findAllByIsDel0(final String projectName, final String createTime,final Integer status,  String orderField, String orderDirection, PageRequest pageRequest) throws Exception{
        return this.findAllByIsDel0(projectName, createTime, status,null,null,null,null,null,null,null,null,null,orderField, orderDirection, pageRequest);
    }

    //查找已完成的项目
    public Page<Project> findAllByIsDel0(final String projectName, final String createTime, String orderField, String orderDirection, PageRequest pageRequest) throws Exception{
        return this.findAllByIsDel0(projectName, createTime, 6,orderField, orderDirection, pageRequest);
    }

    public Page<Project> findAllByIsDel0(final String projectName, final String createTime, final Integer status,final String is_dataUploadStatus,
                                         final String is_photoEditStatus,final String is_photoMadeStatus,final String is_sceneMadeStatus,final String is_dataIntegrationStatus,
                                         final String is_mp3EditStatus,final String is_videoEditStatus,final String is_thrDModelMadeStatus,final String is_subtitleEditStatus,
                                         String orderField, String orderDirection, PageRequest pageRequest) throws Exception{
        Specification<Project> projectSpecification=new Specification<Project>() {
            @Override
            public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();

                Predicate predicate=null;

                //默认查询isDel为0
                predicate=criteriaBuilder.equal(root.get("isDel"),0);
                predicateList.add(predicate);

                if (projectName!=null&&!projectName.equals("")){
                    Path<String> stringPath=root.get("projectName");
                    predicate=criteriaBuilder.like(stringPath,"%"+projectName+"%");
                    predicateList.add(predicate);
                }
                if (createTime!=null&&!createTime.equals("")){
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date1=createTime+" 00:00:00";
                    String date2=createTime+" 23:59:59";
                    Date date3= null;
                    Date date4= null;
                    try {
                        date3 = sdf.parse(date1);
                        date4 = sdf.parse(date2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Expression<Date> stringPath=root.get("createTime");
                    predicate=criteriaBuilder.between(stringPath,date3,date4);
                    predicateList.add(criteriaBuilder.and(predicate));
                }
                //项目状态
                if (status!=null&&!status.equals("")){
                    predicate=criteriaBuilder.equal(root.get("status"),status);
                    predicateList.add(criteriaBuilder.and(predicate));
                }
                //1.数据上传模块状态
                if (is_dataUploadStatus!=null&&!is_dataUploadStatus.equals("")){
                    if (StringUtils.isInteger(is_dataUploadStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_dataUploadStatus"),is_dataUploadStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_dataUploadStatus.split(",");
                        Expression<Integer> path=root.get("is_dataUploadStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }
                }
                //2.原始图编辑模块状态
                if (is_photoEditStatus!=null&&!is_photoEditStatus.equals("")){
                    if (StringUtils.isInteger(is_photoEditStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_photoEditStatus"),is_photoEditStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_photoEditStatus.split(",");
                        Expression<Integer> path=root.get("is_photoEditStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }

                }
                //3.球形图制作模块状态
                if (is_photoMadeStatus!=null&&!is_photoMadeStatus.equals("")){
                    if (StringUtils.isInteger(is_photoMadeStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_photoMadeStatus"),is_photoMadeStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_photoMadeStatus.split(",");
                        Expression<Integer> path=root.get("is_photoMadeStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }

                }
                //4.场景构建模块状态
                if (is_sceneMadeStatus!=null&&!is_sceneMadeStatus.equals("")){
                    if (StringUtils.isInteger(is_sceneMadeStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_sceneMadeStatus"),is_sceneMadeStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_sceneMadeStatus.split(",");
                        Expression<Integer> path=root.get("is_sceneMadeStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }

                }
                //5.数据整合模块状态
                if (is_dataIntegrationStatus!=null&&!is_dataIntegrationStatus.equals("")){
                    if (StringUtils.isInteger(is_dataIntegrationStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_dataIntegrationStatus"),is_dataIntegrationStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_dataIntegrationStatus.split(",");
                        Expression<Integer> path=root.get("is_dataIntegrationStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }

                }
                //6.音频编辑模块状态
                if (is_mp3EditStatus!=null&&!is_mp3EditStatus.equals("")){
                    if (StringUtils.isInteger(is_mp3EditStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_mp3EditStatus"),is_mp3EditStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_mp3EditStatus.split(",");
                        Expression<Integer> path=root.get("is_mp3EditStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }

                }
                //7.视频编辑模块状态
                if (is_videoEditStatus!=null&&!is_videoEditStatus.equals("")){
                    if (StringUtils.isInteger(is_videoEditStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_videoEditStatus"),is_videoEditStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_videoEditStatus.split(",");
                        Expression<Integer> path=root.get("is_videoEditStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }

                }
                //8.3D模型制作模块状态
                if (is_thrDModelMadeStatus!=null&&!is_thrDModelMadeStatus.equals("")){
                    if (StringUtils.isInteger(is_thrDModelMadeStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_thrDModelMadeStatus"),is_thrDModelMadeStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_thrDModelMadeStatus.split(",");
                        Expression<Integer> path=root.get("is_thrDModelMadeStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }

                }
                //9.字幕编辑模块状态
                if (is_subtitleEditStatus!=null&&!is_subtitleEditStatus.equals("")){
                    if (StringUtils.isInteger(is_subtitleEditStatus)){
                        //整型
                        predicate=criteriaBuilder.equal(root.get("is_subtitleEditStatus"),is_subtitleEditStatus);
                        predicateList.add(criteriaBuilder.and(predicate));
                    }else {
                        //字符串
                        String[] strings=is_subtitleEditStatus.split(",");
                        Expression<Integer> path=root.get("is_subtitleEditStatus");
                        predicate=criteriaBuilder.between(path,Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
                        predicateList.add(criteriaBuilder.and(predicate));
                    }

                }

                 criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort;
        if (orderDirection!=null&&!orderDirection.equals("")&&orderField!=null&&!orderField.equals("")){
            sort=new Sort(Sort.Direction.fromString(orderDirection),orderField);
        }else {
            sort=new Sort(Sort.Direction.DESC,"createTime");
        }
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);

        Page<Project> projectPage=null;
        try {
            projectPage=projectRepository.findAll(projectSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectPage.getTotalElements()>0?projectPage:null;
    }

    @Transactional
    public void startUpById(Integer id){
        projectRepository.updateStatusById(id);
        projectRepository.updateMp3EditStatusById(id);
        projectRepository.updateVideoEditStatusById(id);
        projectRepository.updateThrDModelMadeStatusById(id);
        projectRepository.updateSubtitleEditStatusById(id);
    }

    public Project findById(Integer id){
        return projectRepository.findById(id);
    }

    public String findNameById(Integer id){
        return projectRepository.findNameById(id);
    }

    /**
     * 数据上传模块
     */

    @Transactional
    public void updateDataUploadStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updateDataUploadStatusById(id,status);
        dataUploadRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updateDataUploadStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updateDataUploadStatusById(id,status);
        dataUploadRepository.updateByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updateDataUploadStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updateDataUploadStatusById(id,status);
        dataUploadRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updateDataUploadStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updateDataUploadStatusById(id,status);
        dataUploadRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updateDaUpStatusToCheckFinishById(Integer id,Integer status,Integer photoEditStatus,String checkPeople,Date toCheckDate){
        projectRepository.updateDataUploadStatusById(id,status);
        projectRepository.updatePhotoEditStatusById(id,photoEditStatus);
        dataUploadRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }

    /**
     *原始图编辑模块
     */

    @Transactional
    public void updatePhotoEditStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updatePhotoEditStatusById(id,status);
        photoEditRepository.updateAppointByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updatePhotoEditStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updatePhotoEditStatusById(id,status);
        photoEditRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updatePhotoEditStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updatePhotoEditStatusById(id,status);
        photoEditRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updatePhotoEditStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updatePhotoEditStatusById(id,status);
        photoEditRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updatePhEdStatusToCheckFinishById(Integer id,Integer status,Integer photoMadeStatus,String checkPeople,Date toCheckDate){
        projectRepository.updatePhotoEditStatusById(id,status);
        projectRepository.updatePhotoMadeStatusById(id,photoMadeStatus);
        photoEditRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }

    /**
     * 球形图制作模块
     */
    @Transactional
    public void updatePhotoMadeStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updatePhotoMadeStatusById(id,status);
        photoMadeRepository.updateAppointByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updatePhotoMadeStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updatePhotoMadeStatusById(id,status);
        photoMadeRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updatePhotoMadeStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updatePhotoMadeStatusById(id,status);
        photoMadeRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updatePhotoMadeStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updatePhotoMadeStatusById(id,status);
        photoMadeRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updatePhMaStatusToCheckFinishById(Integer id,Integer status,Integer photoMadeStatus,String checkPeople,Date toCheckDate){
        projectRepository.updatePhotoMadeStatusById(id,status);
        projectRepository.updateSceneMadeStatusById(id,photoMadeStatus);
        photoMadeRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }

    /**
     * 场景制作模块
     */
    @Transactional
    public void updateSceneMadeStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updateSceneMadeStatusById(id,status);
        sceneMadeRepository.updateAppointByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updateSceneMadeStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updateSceneMadeStatusById(id,status);
        sceneMadeRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updateSceneMadeStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updateSceneMadeStatusById(id,status);
        sceneMadeRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updateSceneMadeStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updateSceneMadeStatusById(id,status);
        sceneMadeRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updateScMaStatusToCheckFinishById(Integer id,Integer status,Integer photoMadeStatus,String checkPeople,Date toCheckDate){
        projectRepository.updateSceneMadeStatusById(id,status);
        projectRepository.updateDataIntegrationStatusById(id,photoMadeStatus);
        sceneMadeRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }

    /**
     * 数据整合模块
     */
    @Transactional
    public void updateDataIntegrationStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updateDataIntegrationStatusById(id,status);
        dataIntegrationRepository.updateAppointByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updateDataIntegrationStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updateDataIntegrationStatusById(id,status);
        dataIntegrationRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updateDataIntegrationStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updateDataIntegrationStatusById(id,status);
        dataIntegrationRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updateDataIntegrationStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updateDataIntegrationStatusById(id,status);
        dataIntegrationRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updateDaInStatusToCheckFinishById(Integer id,Integer status,String checkPeople,Date toCheckDate){
        projectRepository.updateDataIntegrationStatusById(id,status);
        dataIntegrationRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }

    /**
     * 音频编辑模块
     */
    @Transactional
    public void updateMp3EditStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updateMp3EditStatusById(id,status);
        mp3EditRepository.updateAppointByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updateMp3EditStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updateMp3EditStatusById(id,status);
        mp3EditRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updateMp3EditStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updateMp3EditStatusById(id,status);
        mp3EditRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updateMp3EditStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updateMp3EditStatusById(id,status);
        mp3EditRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updateMp3EditStatusToCheckFinishById(Integer id,Integer status,String checkPeople,Date toCheckDate){
        projectRepository.updateMp3EditStatusById(id,status);
        mp3EditRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }

    /**
     * 视频编辑模块
     */
    @Transactional
    public void updateVideoEditStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updateVideoEditStatusById(id,status);
        videoEditRepository.updateAppointByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updateVideoEditStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updateVideoEditStatusById(id,status);
        videoEditRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updateVideoEditStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updateVideoEditStatusById(id,status);
        videoEditRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updateVideoEditStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updateVideoEditStatusById(id,status);
        videoEditRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updateVideoEditStatusToCheckFinishById(Integer id,Integer status,String checkPeople,Date toCheckDate){
        projectRepository.updateVideoEditStatusById(id,status);
        videoEditRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }

    /**
     * 3D模型制作模块
     */
    @Transactional
    public void updateThrDModelMadeStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updateThrDModelMadeStatusById(id,status);
        thrDModelMadeRepository.updateAppointByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updateThrDModelMadeStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updateThrDModelMadeStatusById(id,status);
        thrDModelMadeRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updateThrDModelMadeStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updateThrDModelMadeStatusById(id,status);
        thrDModelMadeRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updateThrDModelMadeStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updateThrDModelMadeStatusById(id,status);
        thrDModelMadeRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updateThrDModelMadeStatusToCheckFinishById(Integer id,Integer status,String checkPeople,Date toCheckDate){
        projectRepository.updateThrDModelMadeStatusById(id,status);
        thrDModelMadeRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }

    /**
     * 字幕编辑模块
     */
    @Transactional
    public void updateSubtitleEditStatusByIdAndUsername(Integer id,Integer status,String username,String toAppointPeople,Date toAppointDate){
        projectRepository.updateSubtitleEditStatusById(id,status);
        subtitleEditRepository.updateAppointByProjectId(id,username,toAppointPeople,toAppointDate);
    }

    @Transactional
    public void updateSubtitleEditStatusAndAcceptById(Integer id,Integer status,Integer accept){
        projectRepository.updateSubtitleEditStatusById(id,status);
        subtitleEditRepository.updateAcceptByProjectId(id,accept);
    }

    @Transactional
    public void updateSubtitleEditStatusAndRejectById(Integer id,Integer status,Integer reject,String reason){
        projectRepository.updateSubtitleEditStatusById(id,status);
        subtitleEditRepository.updateRejectByProjectId(id,reject,reason);
    }

    @Transactional
    public void updateSubtitleEditStatusAndDealWithById(Integer id,Integer status,Date toDealWithFinishDate){
        projectRepository.updateSubtitleEditStatusById(id,status);
        subtitleEditRepository.updateDealWithByProjectId(id,toDealWithFinishDate);
    }

    @Transactional
    public void updateSubtitleEditStatusToCheckFinishById(Integer id,Integer status,String checkPeople,Date toCheckDate){
        projectRepository.updateSubtitleEditStatusById(id,status);
        subtitleEditRepository.updateCheckByProjectId(id,checkPeople,toCheckDate);
    }
}
