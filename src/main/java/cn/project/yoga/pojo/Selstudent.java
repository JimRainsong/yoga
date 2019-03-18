package cn.project.yoga.pojo;

import java.util.Date;

public class Selstudent {
    private Integer venueId;

    private Integer vipTypeId;

    private Integer cardPrice;

    private String cardName;

    private String cardInfo;

    private Integer vipId;

    private Integer userId;

    private Date updateTime;

    private String netName;

    private String phoneNumber;

    private String idCard;

    private Integer balance;

    private Integer flag;

    private String useDate;

    private Date registTime;

    private String headImg;

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = "<img src='"+headImg+"'  class=\"layui-nav-img\" >";
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getVipTypeId() {
        return vipTypeId;
    }

    public void setVipTypeId(Integer vipTypeId) {
        this.vipTypeId = vipTypeId;
    }

    public Integer getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(Integer cardPrice) {
        this.cardPrice = cardPrice;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

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

    public String getNetName() {
        return netName;
    }

    public void setNetName(String netName) {
        this.netName = netName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }
}