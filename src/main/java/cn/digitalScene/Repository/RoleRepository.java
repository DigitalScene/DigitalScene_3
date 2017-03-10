package cn.digitalScene.Repository;

import cn.digitalScene.Model.Role;
import cn.digitalScene.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 25065 on 2017/2/16.
 */
public interface RoleRepository extends JpaRepository<Role,String>,JpaSpecificationExecutor<Role> {

    @Modifying
    @Query("delete from Role o where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);



}
