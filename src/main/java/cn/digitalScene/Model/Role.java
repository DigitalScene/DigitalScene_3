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

    public String getRoleName(){
        return RoleName.getDescriptionByValue(this.getRole());
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

    public static enum RoleName{
        admin("admin","管理员"),user("user","普通用户");

        private String value;
        private String description;

        RoleName() {
        }

        RoleName(String value, String description) {
            this.value = value;
            this.description = description;
        }

        public static RoleName getByValue(String value){
            for (RoleName rn:RoleName.values()){
                if (rn.value.equals(value)){
                    return rn;
                }
            }
            return null;
        }

        public static String getNameByValue(String value){
            RoleName rn=getByValue(value);
            return rn == null ? null :rn.name();
        }

        public static String getDescriptionByValue(String value){
            RoleName rn=getByValue(value);
            return rn == null ? null :rn.getDescription();
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
