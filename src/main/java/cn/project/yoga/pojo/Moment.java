package cn.project.yoga.pojo;

import java.util.Date;

public abstract class Moment {
    private Date time;
    private String img;
    private String name;
    private Integer id;
    private String detail;

    public abstract Date getTime();

    public abstract void setTime(Date time);

    public abstract String getImg();

    public abstract void setImg(String img);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Integer getId();

    public abstract void setId(Integer id);

    public abstract String getDetail();

    public abstract void setDetail(String detail);
}
