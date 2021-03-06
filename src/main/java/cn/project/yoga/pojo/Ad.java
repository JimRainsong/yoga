package cn.project.yoga.pojo;

public class Ad {
    private Integer adId;

    private String adTitle;

    private String adDetails;

    private String adImg;

    private Integer flag;

    private Integer examine;

    private String adTime;

    public String getAdTime() {
        return adTime;
    }

    public void setAdTime(String adTime) {
        this.adTime = adTime;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdDetails() {
        return adDetails;
    }

    public void setAdDetails(String adDetails) {
        this.adDetails = adDetails;
    }

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "adId=" + adId +
                ", adTitle='" + adTitle + '\'' +
                ", adDetails='" + adDetails + '\'' +
                ", adImg='" + adImg + '\'' +
                ", flag=" + flag +
                ", examine=" + examine +
                ", adTime='" + adTime + '\'' +
                '}';
    }
}