package cn.digitalScene.Repository;

import cn.digitalScene.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 25065 on 2017/2/16.
 */
public interface AdminRepository extends JpaRepository<Admin,String>,JpaSpecificationExecutor<Admin> {

    @Query("delete from Admin o where lower(o.id)=lower(:id) ")
    public void delete(@Param("id")Integer id);

    @Query("select o from Admin o where lower(o.username)=lower(:username) ")
    public Admin findByUsername(@Param("username")String username);
}
