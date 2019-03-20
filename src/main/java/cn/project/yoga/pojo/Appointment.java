package cn.project.yoga.pojo;

import java.util.Date;

public class Appointment {

    //数据库 视图 appointment的 类 用于 查询  学员预约教练的 信息查询

    private Integer cId;
    private Integer uId;
    private Integer tId;
    private Integer vId;
    private Date startTime;
    private Date endTime;
    private Integer state;
    private String uPhone;
    private String uQq;
    private String uName;
    private String uReal_name;
    private Integer uLevel;
    private String uSex;
    private String uImg;
    private String tName;
    private String tPhone;
    private String tQq;
    private String tImg;
    private String tSex;
    private String vName;
    private String vAddress;
    private String vPhone;
    private String vQq;
    private String vImg;
    private String vDetail;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuQq() {
        return uQq;
    }

    public void setuQq(String uQq) {
        this.uQq = uQq;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuReal_name() {
        return uReal_name;
    }

    public void setuReal_name(String uReal_name) {
        this.uReal_name = uReal_name;
    }

    public Integer getuLevel() {
        return uLevel;
    }

    public void setuLevel(Integer uLevel) {
        this.uLevel = uLevel;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    public String gettQq() {
        return tQq;
    }

    public void settQq(String tQq) {
        this.tQq = tQq;
    }

    public String gettImg() {
        return tImg;
    }

    public void settImg(String tImg) {
        this.tImg = tImg;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvAddress() {
        return vAddress;
    }

    public void setvAddress(String vAddress) {
        this.vAddress = vAddress;
    }

    public String getvPhone() {
        return vPhone;
    }

    public void setvPhone(String vPhone) {
        this.vPhone = vPhone;
    }

    public String getvQq() {
        return vQq;
    }

    public void setvQq(String vQq) {
        this.vQq = vQq;
    }

    public String getvImg() {
        return vImg;
    }

    public void setvImg(String vImg) {
        this.vImg = vImg;
    }

    public String getvDetail() {
        return vDetail;
    }

    public void setvDetail(String vDetail) {
        this.vDetail = vDetail;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "cId=" + cId +
                ", uId=" + uId +
                ", tId=" + tId +
                ", vId=" + vId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", state=" + state +
                ", uPhone='" + uPhone + '\'' +
                ", uQq='" + uQq + '\'' +
                ", uName='" + uName + '\'' +
                ", uReal_name='" + uReal_name + '\'' +
                ", uLevel=" + uLevel +
                ", uSex='" + uSex + '\'' +
                ", uImg='" + uImg + '\'' +
                ", tName='" + tName + '\'' +
                ", tPhone='" + tPhone + '\'' +
                ", tQq='" + tQq + '\'' +
                ", tImg='" + tImg + '\'' +
                ", tSex='" + tSex + '\'' +
                ", vName='" + vName + '\'' +
                ", vAddress='" + vAddress + '\'' +
                ", vPhone='" + vPhone + '\'' +
                ", vQq='" + vQq + '\'' +
                ", vImg='" + vImg + '\'' +
                ", vDetail='" + vDetail + '\'' +
                '}';
    }
}
