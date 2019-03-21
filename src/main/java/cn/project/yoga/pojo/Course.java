package cn.project.yoga.pojo;

import java.util.Date;
import java.util.List;

public class Course {
    private Integer courseId;

    private Integer venueId;

    /*private Integer teacherId;*/
    private Teacher teacher;

    private Date startTime;

    private Date overTime;

    private Double courseMoney;

    private Integer coursePeople;

    private Integer flag;

    private String courseState;

    private String courseName;


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseState() {
        return courseState;
    }

    public void setCourseState(String courseState) {
        this.courseState = courseState;
    }

    private List<My_course> myCourses;

    public List<My_course> getMyCourses() {
        return myCourses;
    }

    public void setMyCourses(List<My_course> myCourses) {
        this.myCourses = myCourses;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    /*public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }*/

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Double getCourseMoney() {
        return courseMoney;
    }

    public void setCourseMoney(Double courseMoney) {
        this.courseMoney = courseMoney;
    }

    public Integer getCoursePeople() {
        return coursePeople;
    }

    public void setCoursePeople(Integer coursePeople) {
        this.coursePeople = coursePeople;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", venueId=" + venueId +
                ", teacher=" + teacher +
                ", startTime=" + startTime +
                ", overTime=" + overTime +
                ", courseMoney=" + courseMoney +
                ", coursePeople=" + coursePeople +
                ", flag=" + flag +
                ", myCourses=" + myCourses +
                '}';
    }
}