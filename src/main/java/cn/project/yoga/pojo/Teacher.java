package cn.project.yoga.pojo;

public class Teacher {
    private Integer teacherId;

    private Integer userId;

    private Integer uId;

    private String teacherName;

    private String teacherPhone;

    private String teacherQq;

    private String teacherIdnum;

    private Integer teacherMoney;

    private Integer selfMoney;

    private String teacherImg;

    private String teacherSex;

    private Integer ifAuth;

    private String authInfo;

    private Integer flag;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherQq() {
        return teacherQq;
    }

    public void setTeacherQq(String teacherQq) {
        this.teacherQq = teacherQq;
    }

    public String getTeacherIdnum() {
        return teacherIdnum;
    }

    public void setTeacherIdnum(String teacherIdnum) {
        this.teacherIdnum = teacherIdnum;
    }

    public Integer getTeacherMoney() {
        return teacherMoney;
    }

    public void setTeacherMoney(Integer teacherMoney) {
        this.teacherMoney = teacherMoney;
    }

    public Integer getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(Integer selfMoney) {
        this.selfMoney = selfMoney;
    }

    public String getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public Integer getIfAuth() {
        return ifAuth;
    }

    public void setIfAuth(Integer ifAuth) {
        this.ifAuth = ifAuth;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", userId=" + userId +
                ", uId=" + uId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherQq='" + teacherQq + '\'' +
                ", teacherIdnum='" + teacherIdnum + '\'' +
                ", teacherMoney=" + teacherMoney +
                ", selfMoney=" + selfMoney +
                ", teacherImg='" + teacherImg + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", ifAuth=" + ifAuth +
                ", authInfo='" + authInfo + '\'' +
                ", flag=" + flag +
                '}';
    }
}