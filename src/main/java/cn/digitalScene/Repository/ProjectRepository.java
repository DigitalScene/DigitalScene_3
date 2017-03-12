package cn.digitalScene.Repository;

import cn.digitalScene.Model.Project;
import cn.digitalScene.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 25065 on 2017/2/16.
 */
public interface ProjectRepository extends JpaRepository<Project,String>,JpaSpecificationExecutor<Project> {

    @Modifying
    @Query("update Project o set o.isDel=1 where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id") Integer id);

    @Modifying
    @Query("update Project o set o.status=1 where lower(o.id)=lower(:id) ")
    public void updateStatusById(@Param("id")Integer id);

    @Query("select o from Project o where lower(o.id)=lower(:id) ")
    public Project findById(@Param("id")Integer id);

}
