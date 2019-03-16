package cn.project.yoga.pojo;

public class Venue_teacher {
    private Integer venueTeacherId;

    private Integer venueId;

    private Integer teacherId;

    private Teacher teacher;

    private Integer teacherState;

    private Integer flag;

    public Integer getVenueTeacherId() {
        return venueTeacherId;
    }

    public void setVenueTeacherId(Integer venueTeacherId) {
        this.venueTeacherId = venueTeacherId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getTeacherState() {
        return teacherState;
    }

    public void setTeacherState(Integer teacherState) {
        this.teacherState = teacherState;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Venue_teacher{" +
                "venueTeacherId=" + venueTeacherId +
                ", venueId=" + venueId +
                ", teacher=" + teacher +
                ", teacherState=" + teacherState +
                ", flag=" + flag +
                " tid"+teacherId+
                '}';
    }
}