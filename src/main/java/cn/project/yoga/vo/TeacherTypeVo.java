package cn.project.yoga.vo;

public class TeacherTypeVo {
    private Integer vid;
    private Integer teype;



    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getTeype() {
        return teype;
    }

    public void setTeype(Integer teype) {
        this.teype = teype;
    }

    @Override
    public String toString() {
        return "TeacherTypeVo{" +
                "vid=" + vid +
                ", teype=" + teype +
                '}';
    }
}
