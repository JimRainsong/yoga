package cn.project.yoga.pojo;

public class My_course {
    private Integer myCourseId;

    private Integer courseId;

    private Integer userId;

    private Integer ifFinish;

    private Integer ifCancle;

    public Integer getMyCourseId() {
        return myCourseId;
    }

    public void setMyCourseId(Integer myCourseId) {
        this.myCourseId = myCourseId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIfFinish() {
        return ifFinish;
    }

    public void setIfFinish(Integer ifFinish) {
        this.ifFinish = ifFinish;
    }

    public Integer getIfCancle() {
        return ifCancle;
    }

    public void setIfCancle(Integer ifCancle) {
        this.ifCancle = ifCancle;
    }
}