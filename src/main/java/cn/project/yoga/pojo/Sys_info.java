package cn.project.yoga.pojo;

public class Sys_info {
    private Integer sysInfoId;

    private String sysInfoDetail;

    private Integer userId;

    private Integer ifRead;

    private Integer flag;

    public Integer getSysInfoId() {
        return sysInfoId;
    }

    public void setSysInfoId(Integer sysInfoId) {
        this.sysInfoId = sysInfoId;
    }

    public String getSysInfoDetail() {
        return sysInfoDetail;
    }

    public void setSysInfoDetail(String sysInfoDetail) {
        this.sysInfoDetail = sysInfoDetail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIfRead() {
        return ifRead;
    }

    public void setIfRead(Integer ifRead) {
        this.ifRead = ifRead;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}