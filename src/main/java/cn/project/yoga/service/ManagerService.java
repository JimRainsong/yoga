package cn.project.yoga.service;

import cn.project.yoga.pojo.Ad;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.pojo.*;

import java.util.List;

public interface ManagerService {

    List<Venue> selAllVenues4_1(Integer currentPage,Integer pageSize,String venueName);

    int upVenueApprove(Integer venueId, Integer val);

    List<Teacher> selAllTeacherByapprove(Integer currentPage, Integer pageSize, String teacherName);

    List<Ad> selAllAdBylimit(Integer currentPage, Integer pageSize, Integer datas,String adtitle);

    int updateAdByAdid(Integer daId, Integer val);

    List<Ad> getadthree();

    List<Goods> limitAllGoods4_1(Integer currentPage, Integer pageSize, Integer type, String goodsName);

    List<Myorder> selAllOrderByuid4_1(int uid);

    String selGnameByGid4_1(Integer goodsId);

    int deletegoodsByGid4_1(Integer gId);

    /*分页查询所有学员信息*/
    public List<User_info> SelUser4(Integer currentPage,Integer pageSize );

    /*
     * 根据条件查找教练*/
    public List<Teacher> shearch( String teachername, String teacherSex,String teacherPhone,String teacherQq,Integer currentPage,Integer pageSize);

    /*
    * 根据类型查询订单*/
    public List<Tra_tea_ven> SelOder4( String time, String venname, String transcationType,Integer currentPage,Integer pageSize);

    /*
     * 查询所有订单*/
    public List<Tra_tea_ven> SelAllOrder4(Integer currentPage,Integer pageSize);
}

