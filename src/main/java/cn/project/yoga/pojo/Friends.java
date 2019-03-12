package cn.project.yoga.pojo;

import java.util.Date;

public class Friends {
    private Integer fId;

    private Integer userId;

    private String fDetail;

    private Integer flag;

    private Date fTime;

    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getfDetail() {
        return fDetail;
    }

    public void setfDetail(String fDetail) {
        this.fDetail = fDetail;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}