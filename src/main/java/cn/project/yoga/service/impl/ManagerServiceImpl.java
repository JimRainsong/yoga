package cn.project.yoga.service.impl;


import cn.project.yoga.dao.*;
import cn.project.yoga.pojo.*;
import cn.project.yoga.dao.*;
import cn.project.yoga.dao.AdMapper;
import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.Ad;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private VenueMapper venueMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AdMapper adMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private MyorderMapper myorderMapper;

    @Autowired
    private User_infoMapper user_infoMapper;

    /*查询场馆信息表所有数据*/
    @Override
    public List<Venue> selAllVenues4_1(Integer currentPage,Integer pageSize,String venueName) {

        return venueMapper.selAllVenues4_1(currentPage,pageSize,venueName);
    }

    /*根据场馆id,更改认证信息*/
    @Override
    public int upVenueApprove(Integer venueId, Integer val) {
        return venueMapper.upApproveByvenueId(venueId,val);
    }

    /** zjl
     * 根据教练名字,模糊查询所有未认证教练*/
    @Override
    public List<Teacher> selAllTeacherByapprove(Integer currentPage, Integer pageSize, String teacherName) {
        return teacherMapper.selAllTeacherByName4_1(currentPage,pageSize,teacherName);
    }

    /** zjl
     * 根据已认证和未认证的参数,分页和模糊查询*/
    @Override
    public List<Ad> selAllAdBylimit(Integer currentPage, Integer pageSize, Integer datas,String adtitle) {
        return adMapper.selAllAdBylimitAndPage(currentPage,pageSize,datas,adtitle);
    }

    /**  zjl
     * 根据广告id,更改广告认证
     * */
    @Override
    public int updateAdByAdid(Integer daId, Integer val) {
        return adMapper.updateStateByAdid(daId,val);
    }

    /** zjl
     * 获取广告最新的三条
     * */
    @Override
    public List<Ad> getadthree() {
        return adMapper.selthreeads();
    }

    /** zjl
     * 商品查询 , 分页 ,模糊查询
     * */
    @Override
    public List<Goods> limitAllGoods4_1(Integer currentPage, Integer pageSize, Integer type, String goodsName) {
        return goodsMapper.limitSelAllGoods(currentPage,pageSize,type,goodsName);
    }

    /** zjl
     *   根据用户id,查询用户订单信息
    * */
    @Override
    public List<Myorder> selAllOrderByuid4_1(int uid) {
        return myorderMapper.selAllOrderByUserId4_1(uid);
    }

    /** zjl
     * 根据 商品id查询商品名称
     *
     * @param goodsId
     * @return
     */
    @Override
    public String selGnameByGid4_1(Integer goodsId) {
        return myorderMapper.selGnameBygid4_1(goodsId);
    }

    /** zjl
     *  根据商品id 删除商品
     * */
    @Override
    public int deletegoodsByGid4_1(Integer gId) {

        return goodsMapper.deletegoodsByGid4_1(gId);
    }

    @Override
    public List<User_info> SelUser4(Integer currentPage, Integer pageSize) {
        List<User_info> user_infos=user_infoMapper.SelUser4(currentPage,pageSize);
        return user_infos;
    }
}
