package cn.digitalScene.Repository;

import cn.digitalScene.Model.PhotoMade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by 25065 on 2017/3/16.
 */
public interface PhotoMadeRepository extends JpaRepository<PhotoMade,String>,JpaSpecificationExecutor<PhotoMade> {

    @Modifying
    @Query("update PhotoMade o set o.photoMadePeople=:username,o.photoMadeToAppointPeople=:toAppointPeople,o.photoMadeToAppointDate=:toAppointDate where o.id=(select p.photoMade.id from Project p where p.id=:id)")
    public void updateAppointByProjectId(@Param("id") Integer id, @Param("username") String username, @Param("toAppointPeople") String toAppointPeople, @Param("toAppointDate") Date toAppointDate);

    @Modifying
    @Query("update PhotoMade o set o.is_photoMadePeople=:accept where o.id=(select p.photoMade.id from Project p where p.id=:id)")
    public void updateAcceptByProjectId(@Param("id") Integer id, @Param("accept") Integer accept);

    @Modifying
    @Query("update PhotoMade o set o.is_photoMadePeople=:reject,o.photoMadePeople_reason=:reason where o.id=(select p.photoMade.id from Project p where p.id=:id)")
    public void updateRejectByProjectId(@Param("id") Integer id, @Param("reject") Integer reject, @Param("reason") String reason);

    @Modifying
    @Query("update PhotoMade o set o.photoMadeFinishDate=:toDealWithFinishDate where o.id=(select p.photoMade.id from Project p where p.id=:id)")
    public void updateDealWithByProjectId(@Param("id") Integer id, @Param("toDealWithFinishDate") Date toDealWithFinishDate);

    @Modifying
    @Query("update PhotoMade o set o.photoMadeToCheckPeople=:checkPeople,o.photoMadeCheckDate=:checkDate where o.id=(select p.photoMade.id from Project p where p.id=:id)")
    public void updateCheckByProjectId(@Param("id") Integer id, @Param("checkPeople") String checkPeople, @Param("checkDate") Date checkDate);
}
