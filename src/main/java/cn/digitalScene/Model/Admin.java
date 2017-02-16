package cn.digitalScene.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 25065 on 2017/2/15.
 */
@Entity
@Table(name = "ds_admin")
public class Admin {
    @Id
    @GeneratedValue
    private Integer id;//主键

    private String username;//用户名

    private String nickname;//昵称

    private String password;//密码

    private Integer status;//状态，0正常，1锁定

    public Admin() {
    }

    public Admin(String username, String nickname, String password, Integer status) {
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
}
