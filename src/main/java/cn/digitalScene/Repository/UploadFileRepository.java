package cn.digitalScene.Repository;

import cn.digitalScene.Model.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 25065 on 2017/3/21.
 */
public interface UploadFileRepository extends JpaRepository<UploadFile,String>,JpaSpecificationExecutor<UploadFile> {

    @Modifying
    @Query("delete from UploadFile o where o.id=:id")
    public void delete(@Param("id")Integer id);

    @Query("select o from UploadFile o where o.moduleId=:moduleId")
    public List<UploadFile> findAllByModuleId(@Param("moduleId")String moduleId);
}
