package cn.project.yoga.pojo;

/**
 * 这个类封装的信息用于
 * 1.朋友圈的展示
 * 2.点击头像进入详情的页面内容展示
 */
public class Detail {
    private Integer roleId;
    private Integer userId;
    private String phone;
    private String netName;
    private String img;
    private String realName;
    private String sex;
    private Integer level;
    private Integer score;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNetName() {
        return netName;
    }

    public void setNetName(String netName) {
        this.netName = netName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                ", netName='" + netName + '\'' +
                ", img='" + img + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", level=" + level +
                ", score=" + score +
                '}';
    }
}
