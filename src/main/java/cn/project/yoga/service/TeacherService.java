package cn.project.yoga.service;

import cn.project.yoga.pojo.*;
import cn.project.yoga.utils.ResultUtil;
import cn.project.yoga.vo.TeacherVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface TeacherService {


    //注册 插入user信息
    int insertUser(User user1);

    //通过username查到 其在user表中的id  并将此id插入teacher表的user_id
    int insert_userid_teacher2(String username);


    int updateIfauthById4_1(Integer teacherId, Integer val);

    Double selectBalanceByTeacherName2(String name);

    List<TeaMoment> allMoments2();

    String selectTeacherNameByTeacherId2(Integer teacherId);

    TeacherInfo selectSingleTeacherByUserName2(String userName);

    /**
     * 分页查询所有教练信息
     */
    public List<Teacher> showTea4(Integer currentPage,Integer pageSize);

    /**
     * 软删除教练
     */
    public int DelTea4(int teacherId);

    /**
     * 根据ID查教练信息
     */
    public Teacher SelTeaById4(int teacherId);



    /**
     * 更新教练数据
     */
    ResultUtil updateTeacher2(TeacherVo vo);

    /**
     * 教练端发布动态
     */
    ResultUtil postNewMoment2(String content);

    /**
     * 教练查看自己的场馆
     */
    Venue selectMyVenueByCurrentUserId2(Integer tId);

    /**
     * 上传教练头像
     */
    ResultUtil uploadHeadImg2(MultipartFile file);

    int connectRoleIdAndUserId2(String username);

    /**
     * 根据当前登录的账号去查询此账号关注的人的信息
     */
    Collection<? extends Detail> selectMyFollowedTeaByCurrentUserId2(Integer currentUserId);

    /**
     * 根据“用户id”查找一个教练
     * @param userId
     * @return
     */
    TeacherInfo selectTeacherByItsUserId2(Integer userId);

    List<TeaMoment> onlyFollowedallMoments2(Integer currentUserId);
}
