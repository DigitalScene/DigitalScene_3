package cn.digitalScene.Repository;

import cn.digitalScene.Model.VideoEdit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
public interface VideoEditRepository extends JpaRepository<VideoEdit,String>,JpaSpecificationExecutor<VideoEdit> {

    @Modifying
    @Query("update VideoEdit o set o.videoEditPeople=:username,o.videoEditToAppointPeople=:toAppointPeople,o.videoEditToAppointDate=:toAppointDate where o.id=(select p.videoEdit.id from Project p where p.id=:id)")
    public void updateAppointByProjectId(@Param("id") Integer id, @Param("username") String username, @Param("toAppointPeople") String toAppointPeople, @Param("toAppointDate") Date toAppointDate);

    @Modifying
    @Query("update VideoEdit o set o.is_videoEditPeople=:accept where o.id=(select p.videoEdit.id from Project p where p.id=:id)")
    public void updateAcceptByProjectId(@Param("id") Integer id, @Param("accept") Integer accept);

    @Modifying
    @Query("update VideoEdit o set o.is_videoEditPeople=:reject,o.videoEditPeople_reason=:reason where o.id=(select p.videoEdit.id from Project p where p.id=:id)")
    public void updateRejectByProjectId(@Param("id") Integer id, @Param("reject") Integer reject, @Param("reason") String reason);

    @Modifying
    @Query("update VideoEdit o set o.videoEditFinishDate=:toDealWithFinishDate where o.id=(select p.videoEdit.id from Project p where p.id=:id)")
    public void updateDealWithByProjectId(@Param("id") Integer id, @Param("toDealWithFinishDate") Date toDealWithFinishDate);

    @Modifying
    @Query("update VideoEdit o set o.videoEditToCheckPeople=:checkPeople,o.videoEditCheckDate=:checkDate where o.id=(select p.videoEdit.id from Project p where p.id=:id)")
    public void updateCheckByProjectId(@Param("id") Integer id, @Param("checkPeople") String checkPeople, @Param("checkDate") Date checkDate);
}
