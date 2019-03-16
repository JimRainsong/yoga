package cn.project.yoga.pojo;

import java.util.Date;

/**
 * 这个类与数据库视图moments_stu对应，用来展示朋友圈
 */
public class StuMoment extends Moment {
    private Date time;
    private String img;
    private String name;
    private Integer id;
    private String detail;

    @Override
    public String toString() {
        return "StuMoment{" +
                "time=" + time +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String getImg() {
        return img;
    }

    @Override
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getDetail() {
        return detail;
    }

    @Override
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
