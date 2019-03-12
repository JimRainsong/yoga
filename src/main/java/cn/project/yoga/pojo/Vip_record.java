package cn.project.yoga.pojo;

import java.util.Date;

public class Vip_record {
    private Integer vipId;

    private Integer userId;

    private Date updateTime;

    private Integer flag;

    private Date registTime;

   /* private Integer vipTypeId;*/

    private Vip_type vipType;

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

   /* public Integer getVipTypeId() {
        return vipTypeId;
    }

    public void setVipTypeId(Integer vipTypeId) {
        this.vipTypeId = vipTypeId;
    }*/

    public Vip_type getVipType() {
        return vipType;
    }

    public void setVipType(Vip_type vipType) {
        this.vipType = vipType;
    }
}