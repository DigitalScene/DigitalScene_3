package cn.digitalScene.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 25065 on 2017/2/15.
 */
@Entity
@Table(name = "ds_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;//主键

    private String username;//用户名

    private String nickname;//昵称

    private String password;//密码

    private Integer status;//状态，0正常，1锁定

    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.LAZY,mappedBy = "user")
    private List<Role> roleArrayList=new ArrayList<>();

    public User() {
    }

    public User(String username, String nickname, String password, Integer status) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Role> getRoleArrayList() {
        return roleArrayList;
    }

    public void setRoleArrayList(List<Role> roleArrayList) {
        this.roleArrayList = roleArrayList;
    }

    public void addRoleArrayList(Role role){
        role.setUser(this);
        this.getRoleArrayList().add(role);
    }
}
