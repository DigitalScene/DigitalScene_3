package cn.digitalScene.Repository;

import cn.digitalScene.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 25065 on 2017/2/16.
 */
public interface ProjectRepository extends JpaRepository<Role,String>,JpaSpecificationExecutor<Role> {

    @Modifying
    @Query("delete from Role o where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);



}
