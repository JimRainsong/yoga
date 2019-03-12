package cn.project.yoga.service;

import cn.project.yoga.pojo.*;

import java.util.List;

public interface UserService {

    User selectUserByUserName(String userName);


    String updateUserInfo1(User user);


    List<Venue> selectMyVenue1(int user_id);


    String buyVipCard1(int user_id,int vip_type_id,int venue_id);


    List<Myself_course> selectMySelfCourse1(int user_id);



    List<My_course> selectMyCourse1(int user_id);


    List<Attention> selectAllAttention1();


    List<Course> venueCourse1(int venue_id);



    String intoCourse1(int user_id,int course_id,int venue_id);



    String orderSelfCourse1(int user_id,int teacher_id,int venue_id);


    String foucusOnOthers(int user_id,int other_user_id);


    List<Ad> selectAd();
}
