package cn.digitalScene.Repository;

import cn.digitalScene.Model.PhotoEdit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by 25065 on 2017/3/16.
 */
public interface PhotoEditRepository extends JpaRepository<PhotoEdit,String>,JpaSpecificationExecutor<PhotoEdit> {

    @Modifying
    @Query("update PhotoEdit o set o.photoEditPeople=:username,o.photoEditToAppointPeople=:toAppointPeople,o.photoEditToAppointDate=:toAppointDate where o.id=(select p.photoEdit.id from Project p where p.id=:id)")
    public void updateAppointByProjectId(@Param("id")Integer id,@Param("username")String username,@Param("toAppointPeople")String toAppointPeople,@Param("toAppointDate")Date toAppointDate);

    @Modifying
    @Query("update PhotoEdit o set o.is_photoEditPeople=:accept where o.id=(select p.photoEdit.id from Project p where p.id=:id)")
    public void updateAcceptByProjectId(@Param("id")Integer id,@Param("accept")Integer accept);

    @Modifying
    @Query("update PhotoEdit o set o.is_photoEditPeople=:reject,o.photoEditPeople_reason=:reason where o.id=(select p.photoEdit.id from Project p where p.id=:id)")
    public void updateRejectByProjectId(@Param("id")Integer id,@Param("reject")Integer reject,@Param("reason")String reason);

    @Modifying
    @Query("update PhotoEdit o set o.photoEditFinishDate=:toDealWithFinishDate where o.id=(select p.photoEdit.id from Project p where p.id=:id)")
    public void updateDealWithByProjectId(@Param("id")Integer id,@Param("toDealWithFinishDate")Date toDealWithFinishDate);

    @Modifying
    @Query("update PhotoEdit o set o.photoEditToCheckPeople=:checkPeople,o.photoEditCheckDate=:checkDate where o.id=(select p.photoEdit.id from Project p where p.id=:id)")
    public void updateCheckByProjectId(@Param("id")Integer id,@Param("checkPeople")String checkPeople,@Param("checkDate")Date checkDate);
}
