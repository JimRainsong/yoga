package cn.project.yoga.pojo;

import java.util.Date;

public class Transcation {
    private Integer transcationId;

    private String transcationType;

    private Integer uId;

    private Integer teaTeacherId;

    private Integer venueId;

    private Date time;

    private Double sysGet;

    private Double venueGet;

    private Double teacherGet;

    private Integer flag;

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

    public Integer getTeaTeacherId() {
        return teaTeacherId;
    }

    public void setTeaTeacherId(Integer teaTeacherId) {
        this.teaTeacherId = teaTeacherId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getSysGet() {
        return sysGet;
    }

    public void setSysGet(Double sysGet) {
        this.sysGet = sysGet;
    }

    public Double getVenueGet() {
        return venueGet;
    }

    public void setVenueGet(Double venueGet) {
        this.venueGet = venueGet;
    }

    public Double getTeacherGet() {
        return teacherGet;
    }

    public void setTeacherGet(Double teacherGet) {
        this.teacherGet = teacherGet;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}