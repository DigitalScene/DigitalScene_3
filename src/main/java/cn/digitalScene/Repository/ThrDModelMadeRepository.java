package cn.digitalScene.Repository;

import cn.digitalScene.Model.ThrDModelMade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by 25065 on 2017/3/15.
 */
public interface ThrDModelMadeRepository extends JpaRepository<ThrDModelMade,String>,JpaSpecificationExecutor<ThrDModelMade>{

    @Modifying
    @Query("update ThrDModelMade o set o.thrDModelMadePeople=:username,o.thrDModelMadeToAppointPeople=:toAppointPeople,o.thrDModelMadeToAppointDate=:toAppointDate where o.id=(select p.thrDModelMade.id from Project p where p.id=:id)")
    public void updateAppointByProjectId(@Param("id") Integer id, @Param("username") String username, @Param("toAppointPeople") String toAppointPeople, @Param("toAppointDate") Date toAppointDate);

    @Modifying
    @Query("update ThrDModelMade o set o.is_thrDModelMadePeople=:accept where o.id=(select p.thrDModelMade.id from Project p where p.id=:id)")
    public void updateAcceptByProjectId(@Param("id") Integer id, @Param("accept") Integer accept);

    @Modifying
    @Query("update ThrDModelMade o set o.is_thrDModelMadePeople=:reject,o.thrDModelMadePeople_reason=:reason where o.id=(select p.thrDModelMade.id from Project p where p.id=:id)")
    public void updateRejectByProjectId(@Param("id") Integer id, @Param("reject") Integer reject, @Param("reason") String reason);

    @Modifying
    @Query("update ThrDModelMade o set o.thrDModelMadeFinishDate=:toDealWithFinishDate where o.id=(select p.thrDModelMade.id from Project p where p.id=:id)")
    public void updateDealWithByProjectId(@Param("id") Integer id, @Param("toDealWithFinishDate") Date toDealWithFinishDate);

    @Modifying
    @Query("update ThrDModelMade o set o.thrDModelMadeToCheckPeople=:checkPeople,o.thrDModelMadeCheckDate=:checkDate where o.id=(select p.thrDModelMade.id from Project p where p.id=:id)")
    public void updateCheckByProjectId(@Param("id") Integer id, @Param("checkPeople") String checkPeople, @Param("checkDate") Date checkDate);
}
