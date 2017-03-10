package cn.digitalScene.Model;

import javax.persistence.*;

/**
 * Created by 25065 on 2017/3/10.
 */
@Entity
@Table(name = "ds_role")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    //角色
    private String role;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private User user;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
