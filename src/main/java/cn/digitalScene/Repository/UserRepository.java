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
public interface UserRepository extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {

    @Modifying
    @Query("delete from User o where lower(o.id)=lower(:id) ")
    public void deleteByPrimaryKey(@Param("id")Integer id);

    @Modifying
    @Query("update User o set o.status=:status where lower(o.id)=lower(:id)")
    public void suoJieDing(@Param("id")Integer id,@Param("status")Integer status );

    @Query("select o.username from User o where lower(o.id)=lower(:id) ")
    public String findUsernameById(@Param("id")Integer id);

    @Query("select o.roleArrayList from User o where lower(o.id)=lower(:id) ")
    public List<Role> findRolesById(@Param("id")Integer id);


    @Query("select o.password from User o where lower(o.id)=lower(:id) ")
    public String findPasswordById(@Param("id")Integer id);

    @Modifying
    @Query("update User o set o.password=:password where lower(o.id)=lower(:id) ")
    public void updatePasswordById(@Param("password")String password,@Param("id")Integer id);

    @Query("select o from User o where lower(o.id)=lower(:id) ")
    public User findById(@Param("id")Integer id);

    @Query("select o.username from User o where lower(o.username)=lower(:username)")
    public String checkUsername(@Param("username") String username);

    @Query("select o from User o where lower(o.username)=lower(:username) ")
    public User findByUsername(@Param("username")String username);

    @Query("select o from User o,Role r where o.status=0 and o.id=r.user.id and r.role='user'")
    public List<User> findUsernameByStatus0AndUser();
}
