package cn.project.yoga.vo;

import cn.project.yoga.pojo.Teacher;

import java.util.Date;

public class CourseVo {
     private Integer vid;
     private String tname;
     private String cname;
     private Date maxTime;
     private Date minTime;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    public Date getMinTime() {
        return minTime;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }


    public CourseVo(Integer vid, String tname, String cname, Date maxTime, Date minTime) {
        this.vid = vid;
        this.tname = tname;
        this.cname = cname;
        this.maxTime = maxTime;
        this.minTime = minTime;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
                "vid=" + vid +
                ", tname='" + tname + '\'' +
                ", cname='" + cname + '\'' +
                ", maxTime=" + maxTime +
                ", minTime=" + minTime +
                '}';
    }
}
