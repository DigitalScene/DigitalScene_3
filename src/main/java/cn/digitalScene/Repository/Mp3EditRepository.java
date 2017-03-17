package cn.digitalScene.Repository;

import cn.digitalScene.Model.Mp3Edit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
public interface Mp3EditRepository extends JpaRepository<Mp3Edit,String>,JpaSpecificationExecutor<Mp3Edit>{

    @Modifying
    @Query("update Mp3Edit o set o.mp3EditPeople=:username,o.mp3EditToAppointPeople=:toAppointPeople,o.mp3EditToAppointDate=:toAppointDate where o.id=(select p.mp3Edit.id from Project p where p.id=:id)")
    public void updateAppointByProjectId(@Param("id") Integer id, @Param("username") String username, @Param("toAppointPeople") String toAppointPeople, @Param("toAppointDate") Date toAppointDate);

    @Modifying
    @Query("update Mp3Edit o set o.is_mp3EditPeople=:accept where o.id=(select p.mp3Edit.id from Project p where p.id=:id)")
    public void updateAcceptByProjectId(@Param("id") Integer id, @Param("accept") Integer accept);

    @Modifying
    @Query("update Mp3Edit o set o.is_mp3EditPeople=:reject,o.mp3EditPeople_reason=:reason where o.id=(select p.mp3Edit.id from Project p where p.id=:id)")
    public void updateRejectByProjectId(@Param("id") Integer id, @Param("reject") Integer reject, @Param("reason") String reason);

    @Modifying
    @Query("update Mp3Edit o set o.mp3EditFinishDate=:toDealWithFinishDate where o.id=(select p.mp3Edit.id from Project p where p.id=:id)")
    public void updateDealWithByProjectId(@Param("id") Integer id, @Param("toDealWithFinishDate") Date toDealWithFinishDate);

    @Modifying
    @Query("update Mp3Edit o set o.mp3EditToCheckPeople=:checkPeople,o.mp3EditCheckDate=:checkDate where o.id=(select p.mp3Edit.id from Project p where p.id=:id)")
    public void updateCheckByProjectId(@Param("id") Integer id, @Param("checkPeople") String checkPeople, @Param("checkDate") Date checkDate);
}
