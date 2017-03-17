package cn.digitalScene.Repository;

import cn.digitalScene.Model.DataIntegration;
import cn.digitalScene.Model.SceneMade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by 25065 on 2017/3/16.
 */
public interface DataIntegrationRepository extends JpaRepository<DataIntegration,String>,JpaSpecificationExecutor<DataIntegration> {

    @Modifying
    @Query("update DataIntegration o set o.dataIntegrationPeople=:username,o.dataIntegrationToAppointPeople=:toAppointPeople,o.dataIntegrationToAppointDate=:toAppointDate where o.id=(select p.dataIntegration.id from Project p where p.id=:id)")
    public void updateAppointByProjectId(@Param("id") Integer id, @Param("username") String username, @Param("toAppointPeople") String toAppointPeople, @Param("toAppointDate") Date toAppointDate);

    @Modifying
    @Query("update DataIntegration o set o.is_dataIntegrationPeople=:accept where o.id=(select p.dataIntegration.id from Project p where p.id=:id)")
    public void updateAcceptByProjectId(@Param("id") Integer id, @Param("accept") Integer accept);

    @Modifying
    @Query("update DataIntegration o set o.is_dataIntegrationPeople=:reject,o.dataIntegrationPeople_reason=:reason where o.id=(select p.dataIntegration.id from Project p where p.id=:id)")
    public void updateRejectByProjectId(@Param("id") Integer id, @Param("reject") Integer reject, @Param("reason") String reason);

    @Modifying
    @Query("update DataIntegration o set o.dataIntegrationFinishDate=:toDealWithFinishDate where o.id=(select p.dataIntegration.id from Project p where p.id=:id)")
    public void updateDealWithByProjectId(@Param("id") Integer id, @Param("toDealWithFinishDate") Date toDealWithFinishDate);

    @Modifying
    @Query("update DataIntegration o set o.dataIntegrationToCheckPeople=:checkPeople,o.dataIntegrationCheckDate=:checkDate where o.id=(select p.dataIntegration.id from Project p where p.id=:id)")
    public void updateCheckByProjectId(@Param("id") Integer id, @Param("checkPeople") String checkPeople, @Param("checkDate") Date checkDate);
}
