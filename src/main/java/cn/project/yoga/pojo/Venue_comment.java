package cn.project.yoga.pojo;

public class Venue_comment {
    private Integer commentId;

    private Integer venueId;

    private User_info userInfo;

    private String comment;

    private String commentType;

    private Integer flag;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public User_info getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User_info userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Venue_comment{" +
                "commentId=" + commentId +
                ", venueId=" + venueId +
                ", user=" + userInfo +
                ", comment='" + comment + '\'' +
                ", commentType='" + commentType + '\'' +
                ", flag=" + flag +
                '}';
    }
}