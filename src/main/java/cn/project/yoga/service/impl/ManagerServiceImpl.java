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
import cn.project.yoga.service.UserService;
import cn.project.yoga.utils.ManagerUtil;
import cn.project.yoga.utils.UpLoadFileUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


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
    @Autowired
    private UserMapper userMapper;

    /*查询场馆信息表所有数据*/
    @Override
    public List<Venue> selAllVenues4_1(Integer currentPage, Integer pageSize, String venueName) {

        return venueMapper.selAllVenues4_1(currentPage, pageSize, venueName);
    }

    /*根据场馆id,更改认证信息*/
    @Override
    public int upVenueApprove(Integer venueId, Integer val) {
        return venueMapper.upApproveByvenueId(venueId, val);
    }

    /**
     * zjl
     * 根据教练名字,模糊查询所有未认证教练
     */
    @Override
    public List<Teacher> selAllTeacherByapprove(Integer currentPage, Integer pageSize, String teacherName) {
        return teacherMapper.selAllTeacherByName4_1(currentPage, pageSize, teacherName);
    }

    /**
     * zjl
     * 根据已认证和未认证的参数,分页和模糊查询
     */
    @Override
    public List<Ad> selAllAdBylimit(Integer currentPage, Integer pageSize, Integer datas, String adtitle) {
        return adMapper.selAllAdBylimitAndPage(currentPage, pageSize, datas, adtitle);
    }

    /**
     * zjl
     * 根据广告id,更改广告认证
     */
    @Override
    public int updateAdByAdid(Integer daId, Integer val) {
        return adMapper.updateStateByAdid(daId, val);
    }

    /**
     * zjl
     * 获取广告最新的三条
     */
    @Override
    public List<Ad> getadthree() {
        return adMapper.selthreeads();
    }

    /**
     * zjl
     * 商品查询 , 分页 ,模糊查询
     */
    @Override
    public List<Goods> limitAllGoods4_1(Integer currentPage, Integer pageSize, Integer type, String goodsName) {
        return goodsMapper.limitSelAllGoods(currentPage, pageSize, type, goodsName);
    }

    /**
     * zjl
     * 根据用户id,查询用户订单信息
     */
    @Override
    public List<Myorder> selAllOrderByuid4_1(int uid) {
        return myorderMapper.selAllOrderByUserId4_1(uid);
    }

    /**
     * zjl
     * 根据 商品id查询商品名称
     *
     * @param goodsId
     * @return
     */
    @Override
    public String selGnameByGid4_1(Integer goodsId) {
        return myorderMapper.selGnameBygid4_1(goodsId);
    }

    /**
     * zjl
     * 根据商品id 删除商品
     */
    @Override
    public int deletegoodsByGid4_1(Integer gId) {

        return goodsMapper.deletegoodsByGid4_1(gId);
    }

    @Override
    public List<User_info> SelUser4(Integer currentPage, Integer pageSize) {
        List<User_info> user_infos = user_infoMapper.SelUser4(currentPage, pageSize);
        return user_infos;
    }

    @Override
    public List<Teacher> shearch(String teachername, String teacherSex, String teacherPhone, String teacherQq,Integer currentPage,Integer pageSize) {
        List<Teacher> teachers=teacherMapper.shearch(teachername,teacherSex,teacherPhone,teacherQq,currentPage,pageSize);
        return teachers;
    }

    @Override
    public List<Tra_tea_ven> SelOder4(String time, String venname,  String transcationType,Integer currentPage,Integer pageSize) {
        List<Tra_tea_ven> tra_tea_vens=userMapper.SelOder4(time,venname,transcationType,currentPage,pageSize);
        return tra_tea_vens;
    }

    @Override
    public List<Tra_tea_ven> SelAllOrder4(Integer currentPage,Integer pageSize) {
        return userMapper.SelAllOrder4(currentPage,pageSize);
    }

    /** zjl
     *  商品更新 , 对图片和商品信息进行操作
     * */
    @Override
    public int updategoodsAndImg(Goods goods, String imgFile) {
            int result = goodsMapper.updategoods4_1(goods,imgFile);
        return result;
    }

    /** zjl
     * 添加商品
     * */
    @Override
    public ManagerUtil addgoods4_1(String gName1, Integer gPrice1, Integer gStock1, String gDescrption1,String gtype1, String imgFile) {
        if (gName1 ==null || gPrice1 == null || gStock1 ==null || gDescrption1 ==null || gtype1 ==null || imgFile ==null){
            return ManagerUtil.error("不允许空值,请重写填写");
        }
        if (gStock1 <=0){
            return  ManagerUtil.error("库存必须大于等于1;请重新输入");
        }
        int result = goodsMapper.addgoods4_1(gName1,gPrice1,gStock1,gDescrption1,gtype1,imgFile);
        if (result >0){
            return ManagerUtil.ok("添加成功");
        }
        return ManagerUtil.error("添加失败");
    }

    /**   zjl
     *  用户付款后 , 对商品表的库存和用户的余额进行扣除
     *  map.put("out_trade_no",out_trade_no);
     *         map.put("total_amount",total_amount);
     *         map.put("goodsIds",goodsIds);
     *         map.put("goodscount",goodscount);
     *         map.put("allmoney",allmoney);
     *         goodsprice
     * */
    @Override
    public int updateUserMoneyAndGoods4_1(Map<String, Object> map) {
       String username  = (String) SecurityUtils.getSubject().getPrincipal();/*shiro 里面获取用户名*/
       //String username = "朱俊陇(测试用)";  //测试
        int u_id = userMapper.selUserIdByName4_1(username);
        int allmoney = Integer.parseInt(map.get("allmoney").toString()) ;
        //根据用户id,去用户信息表扣除余额
        int updatResult = user_infoMapper.updateUserMoneyById4_1(u_id,allmoney);
        //将字符串转为数组
        String[] goods_id = map.get("goodsIds").toString().split(",");
        String[] goods_count = map.get("goodscount").toString().split(",");
        String[] goods_price = map.get("goodsprice").toString().split(",");
        System.out.println("输出字符串数组=="+goods_id+"而======"+goods_count);
        //调用订单mapper , 将数据插进表里
        try {
            for (int i = 0; i < goods_id.length; i++) {
                myorderMapper.insertData4_1(u_id,Integer.parseInt(goods_id[i]),Integer.parseInt(goods_count[i]),Integer.parseInt(goods_count[i])*Integer.parseInt(goods_price[i]));
            }
            return 100;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -20;
        }
    }

    /** zjl
     *  获取商品类型
    *
     */
    @Override
    public List<String> getAllGoodsType4_1() {
        return goodsMapper.selAllGoodsType4_1();
    }
}
