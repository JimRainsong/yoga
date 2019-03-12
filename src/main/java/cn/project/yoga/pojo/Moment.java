package cn.project.yoga.pojo;

import java.util.Date;

/**
 * 这个类与数据库视图moments对应，用来展示朋友圈
 */
public class Moment {
    private Date time;
    private String img;
    private String name;
    private Integer id;
    private String detail;

    @Override
    public String toString() {
        return "Moment{" +
                "time=" + time +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
