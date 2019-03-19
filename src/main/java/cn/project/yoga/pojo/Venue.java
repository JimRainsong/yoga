package cn.project.yoga.pojo;

public class Venue {
    private Integer venueId;

    private Integer userId;

    private String venueName;

    private String venueAddress;

    private String venuePhone;



    private String qq;

    private String venueImg;

    private String venueDetails;

    private String authInfo;

    private Integer authState;

    private Integer flag;

    private Integer venueMoney;

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenuePhone() {
        return venuePhone;
    }

    public void setVenuePhone(String venuePhone) {
        this.venuePhone = venuePhone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getVenueImg() {
        return venueImg;
    }

    public void setVenueImg(String venueImg) {
        this.venueImg = venueImg;
    }

    public String getVenueDetails() {
        return venueDetails;
    }

    public void setVenueDetails(String venueDetails) {
        this.venueDetails = venueDetails;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public Integer getAuthState() {
        return authState;
    }

    public void setAuthState(Integer authState) {
        this.authState = authState;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getVenueMoney() {
        return venueMoney;
    }

    public void setVenueMoney(Integer venueMoney) {
        this.venueMoney = venueMoney;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId=" + venueId +
                ", userId=" + userId +
                ", venueName='" + venueName + '\'' +
                ", venueAddress='" + venueAddress + '\'' +
                ", venuePhone='" + venuePhone + '\'' +
                ", qq='" + qq + '\'' +
                ", venueImg='" + venueImg + '\'' +
                ", venueDetails='" + venueDetails + '\'' +
                ", authInfo='" + authInfo + '\'' +
                ", authState=" + authState +
                ", flag=" + flag +
                ", venueMoney=" + venueMoney +
                '}';


    }
}