package cn.project.yoga.pojo;

public class Tra_tea_ven {
    private Integer transcationId;
    private String transcationType;
    private Integer uId;
    private Integer teacherId;
    private Integer venueId;
    private String time;
    private String venueName;
    private String teacherName;
    private String netName;
    private String realName;
    private String sex;
    private Integer flag;

    @Override
    public String toString() {
        return "Tra_tea_ven{" +
                "transcationId=" + transcationId +
                ", transcationType='" + transcationType + '\'' +
                ", uId=" + uId +
                ", teacherId=" + teacherId +
                ", venueId=" + venueId +
                ", time='" + time + '\'' +
                ", venueName='" + venueName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", netName='" + netName + '\'' +
                ", realName='" + realName + '\'' +
                ", flag=" + flag +
                '}';
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNetName() {
        return netName;
    }

    public void setNetName(String netName) {
        this.netName = netName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getTranscationId() {
        return transcationId;
    }

    public void setTranscationId(Integer transcationId) {
        this.transcationId = transcationId;
    }

    public String getTranscationType() {
        return transcationType;
    }

    public void setTranscationType(String transcationType) {
        this.transcationType = transcationType;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
