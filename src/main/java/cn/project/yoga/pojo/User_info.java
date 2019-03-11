package cn.project.yoga.pojo;

public class User_info {
    private Integer infoId;

    private Integer userId;

    private String phoneNumber;

    private String qq;

    private Integer balance;

    private Integer score;

    private Integer flag;

    private String headImg;

    private Double totalMoney;

    private Integer infoState;

    private String netName;

    private String realName;

    private String idCard;

    private Integer level;

    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User_info{" +
                "infoId=" + infoId +
                ", userId=" + userId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", qq='" + qq + '\'' +
                ", balance=" + balance +
                ", score=" + score +
                ", flag=" + flag +
                ", headImg='" + headImg + '\'' +
                ", totalMoney=" + totalMoney +
                ", infoState=" + infoState +
                ", netName='" + netName + '\'' +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", level=" + level +
                '}';
    }
}