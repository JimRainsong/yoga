package cn.project.yoga.vo;

public class TeacherVo {
    /**
     * 用来做修改用
     */
    private String netName;
    private String authInfo;
    private String realName;
    private String qq;
    private String phone;
    private String sex;
    private String idNum;
    private Integer tId;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getNetName() {
        return netName;
    }

    public void setNetName(String netName) {
        this.netName = netName;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    @Override
    public String toString() {
        return "TeacherVo{" +
                "netName='" + netName + '\'' +
                ", authInfo='" + authInfo + '\'' +
                ", realName='" + realName + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", idNum='" + idNum + '\'' +
                '}';
    }
}
