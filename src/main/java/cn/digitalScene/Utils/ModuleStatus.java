package cn.digitalScene.Utils;

/**
 * Created by 25065 on 2017/3/14.
 */
/**
 * 模块状态枚举
 */
public enum ModuleStatus {
    NOTSTART(0,"未开始"),NOTAPPOINT(1,"待指派"),APPOINTING(2,"指派中"), PROGRESSING(3,"进行中"),
    NOTCHECK(4,"待审核"), FINISH(5,"已完成"),NONEED(6,"不需要");

    private Integer value;
    private String description;

    ModuleStatus(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public static ModuleStatus getByValue(Integer value){
        for (ModuleStatus s: ModuleStatus.values()){
            if (s.value.equals(value)){
                return s;
            }
        }
        return null;
    }

    public static String getNameByValue(Integer value) {
        ModuleStatus s = getByValue(value);
        return s == null ? null : s.name();
    }

    public static String getDescByValue(Integer value) {
        ModuleStatus s = getByValue(value);
        return s == null ? null : s.getDescription();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
