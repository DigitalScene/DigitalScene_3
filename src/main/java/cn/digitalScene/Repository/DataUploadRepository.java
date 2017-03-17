package cn.digitalScene.Repository;

import cn.digitalScene.Model.DataUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
public interface DataUploadRepository extends JpaRepository<DataUpload,String>,JpaSpecificationExecutor<DataUpload> {


    @Modifying
    @Query("update DataUpload o set o.dataUploadPeople=:username,o.dataUploadToAppointPeople=:toAppointPeople,o.dataUploadToAppointDate=:toAppointDate where o.id=(select p.dataUpload.id from Project p where p.id=:id)")
    public void updateByProjectId(@Param("id")Integer id,@Param("username")String username, @Param("toAppointPeople")String toAppointPeople,@Param("toAppointDate")Date toAppointDate);

    @Modifying
    @Query("update DataUpload o set o.is_dataUploadPeople=:accept where o.id=(select p.dataUpload.id from Project p where p.id=:id) ")
    public void updateAcceptByProjectId(@Param("id")Integer id,@Param("accept")Integer accept);

    @Modifying
    @Query("update DataUpload o set o.is_dataUploadPeople=:reject,o.dataUploadPeople_reason=:reason where o.id=(select p.dataUpload.id from Project p where p.id=:id) ")
    public void updateRejectByProjectId(@Param("id")Integer id,@Param("reject")Integer reject,@Param("reason")String reason);

    @Modifying
    @Query("update DataUpload o set o.dataUploadFinishDate=:toDealWithFinishDate where o.id=(select p.dataUpload.id from Project p where p.id=:id)")
    public void updateDealWithByProjectId(@Param("id")Integer id,@Param("toDealWithFinishDate")Date toDealWithFinishDate);

    @Modifying
    @Query("update DataUpload o set o.dataUploadToCheckPeople=:checkPeople,o.dataUploadCheckDate=:toCheckDate where o.id=(select p.dataUpload.id from Project p where p.id=:id)")
    public void updateCheckByProjectId(@Param("id")Integer id, @Param("checkPeople")String checkPeople,@Param("toCheckDate")Date toCheckDate);
}
