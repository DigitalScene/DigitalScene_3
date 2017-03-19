package cn.digitalScene.Repository;

import cn.digitalScene.Model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by 25065 on 2017/2/16.
 */
public interface ProjectRepository extends JpaRepository<Project,String>,JpaSpecificationExecutor<Project> {

    @Modifying
    @Query("update Project o set o.isDel=1 where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);

    @Modifying
    @Query("update Project o set o.status=3,o.is_dataUploadStatus=1 where lower(o.id)=lower(:id)")
    public void updateStatusById(@Param("id")Integer id);

    @Modifying
    @Query("update Project o set o.status=5 where lower(o.id)=lower(:id) and o.is_dataIntegrationStatus=5 and (o.is_mp3EditStatus=5 or o.is_mp3EditStatus=6)" +
            "and (o.is_videoEditStatus=5 or o.is_videoEditStatus=6) and (o.is_thrDModelMadeStatus=5 or o.is_thrDModelMadeStatus=6) and " +
            "(o.is_subtitleEditStatus=5 or o.is_subtitleEditStatus=6) ")
    public void updateProjectStatusToFinishById(@Param("id")Integer id);

    @Modifying
    @Query("update Project o set o.is_mp3EditStatus=1 where lower(o.id)=lower(:id) and o.is_mp3EditStatus=0")
    public void updateMp3EditStatusById(@Param("id")Integer id);

    @Modifying
    @Query("update Project o set o.is_mp3EditStatus=:status where lower(o.id)=lower(:id)")
    public void updateMp3EditStatusById(@Param("id")Integer id,@Param("status")Integer status);

    @Modifying
    @Query("update Project o set o.is_videoEditStatus=1 where lower(o.id)=lower(:id) and o.is_videoEditStatus=0")
    public void updateVideoEditStatusById(@Param("id")Integer id);

    @Modifying
    @Query("update Project o set o.is_videoEditStatus=:status where lower(o.id)=lower(:id) ")
    public void updateVideoEditStatusById(@Param("id")Integer id,@Param("status")Integer status);

    @Modifying
    @Query("update Project o set o.is_thrDModelMadeStatus=1 where lower(o.id)=lower(:id) and o.is_thrDModelMadeStatus=0")
    public void updateThrDModelMadeStatusById(@Param("id")Integer id);

    @Modifying
    @Query("update Project o set o.is_thrDModelMadeStatus=:status where lower(o.id)=lower(:id) ")
    public void updateThrDModelMadeStatusById(@Param("id")Integer id,@Param("status")Integer status);

    @Modifying
    @Query("update Project o set o.is_subtitleEditStatus=1 where lower(o.id)=lower(:id) and o.is_subtitleEditStatus=0")
    public void updateSubtitleEditStatusById(@Param("id")Integer id);

    @Modifying
    @Query("update Project o set o.is_subtitleEditStatus=:status where lower(o.id)=lower(:id) ")
    public void updateSubtitleEditStatusById(@Param("id")Integer id,@Param("status")Integer status);

    @Query("select o from Project o where lower(o.id)=lower(:id) ")
    public Project findById(@Param("id")Integer id);

    @Query("select o.projectName from Project o where lower(o.id)=lower(:id) ")
    public String findNameById(@Param("id")Integer id);

    @Modifying
    @Query("update Project  o set o.is_dataUploadStatus=:dataUploadStatus where lower(o.id)=lower(:id) ")
    public void updateDataUploadStatusById(@Param("id")Integer id,@Param("dataUploadStatus")Integer dataUploadStatus);

    @Modifying
    @Query("update Project  o set o.is_photoEditStatus=:photoEditStatus where lower(o.id)=lower(:id) ")
    public void updatePhotoEditStatusById(@Param("id")Integer id,@Param("photoEditStatus")Integer photoEditStatus);

    @Modifying
    @Query("update Project  o set o.is_photoMadeStatus=:photoMadeStatus where lower(o.id)=lower(:id) ")
    public void updatePhotoMadeStatusById(@Param("id")Integer id,@Param("photoMadeStatus")Integer photoMadeStatus);

    @Modifying
    @Query("update Project  o set o.is_sceneMadeStatus=:sceneMadeStatus where lower(o.id)=lower(:id) ")
    public void updateSceneMadeStatusById(@Param("id")Integer id,@Param("sceneMadeStatus")Integer sceneMadeStatus);

    @Modifying
    @Query("update Project  o set o.is_dataIntegrationStatus=:dataIntegrationStatus where lower(o.id)=lower(:id) ")
    public void updateDataIntegrationStatusById(@Param("id")Integer id,@Param("dataIntegrationStatus")Integer dataIntegrationStatus);

}
