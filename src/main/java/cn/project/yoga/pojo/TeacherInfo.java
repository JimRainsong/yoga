package cn.project.yoga.pojo;

public class TeacherInfo {
    private Integer tId;
    private Integer uId;
    private String netName;
    private String realName;
    private String phone;
    private String qq;
    private String idNum;
    private Double balance;
    private Double selfMoney;
    private String img;
    private String sex;
    private Integer ifAuth;
    private String authInfo;
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "tId=" + tId +
                ", uId=" + uId +
                ", netName='" + netName + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", idNum='" + idNum + '\'' +
                ", balance=" + balance +
                ", selfMoney=" + selfMoney +
                ", img='" + img + '\'' +
                ", sex='" + sex + '\'' +
                ", if_auth=" + ifAuth +
                ", auth_info='" + authInfo + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(Double selfMoney) {
        this.selfMoney = selfMoney;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
