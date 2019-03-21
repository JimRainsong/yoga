package cn.project.yoga.controller;


import cn.project.yoga.alipayconfig.AlipayConfig;
import cn.project.yoga.pojo.*;
import cn.project.yoga.service.ManagerService;
import cn.project.yoga.service.TeacherService;
import cn.project.yoga.service.UserService;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.ManagerUtil;
import cn.project.yoga.utils.UUIDCreate;
import cn.project.yoga.utils.UpLoadFileUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;


@Controller
@RequestMapping("/manager")
public class ManagerController {
    private String imgFile; //全局变量,保存图片对象
    Map<String,Object> map = new HashMap<>(); //全局map

    @Autowired
    private ManagerService managerService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;


    @Autowired
    private VenueService service;

    /*场馆分页查询数据*/
    @RequestMapping("/selallvenues")
    @ResponseBody
    public Map<String, Object> allvenues4_1(@RequestParam(value = "page", defaultValue = "1", required = false) Integer currentPage, @RequestParam(value = "rows"
            , defaultValue = "10", required = false) Integer
            pageSize, String venueName) {
        List<Venue> listvenues4_1 = managerService.selAllVenues4_1(currentPage, pageSize, venueName);
        PageInfo pageinfo = new PageInfo(listvenues4_1);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", listvenues4_1);
        map.put("total", pageinfo.getTotal());
        return map;
    }


    /*场馆认证*/
    @RequestMapping("/updatevenue")
    @ResponseBody
    public ManagerUtil updatevenue4_1(Integer venueId, Integer val) {
        System.out.println("获取前端参数:" + venueId + "认证数据=" + val);
        int res = managerService.upVenueApprove(venueId, val);
        if (res > 0) {
            return ManagerUtil.ok("更改成功");
        }
        return ManagerUtil.error("更改失败");
    }

    /*查询所有未认证的教练信息*/
    @RequestMapping("/selallteacher")
    @ResponseBody
    public Map<String, Object> selAllTeacher(@RequestParam(value = "page", defaultValue = "1", required = false) Integer currentPage, @RequestParam(value = "rows"
            , defaultValue = "10", required = false) Integer
            pageSize, String teacherName) {
        List<Teacher> listteacher = managerService.selAllTeacherByapprove(currentPage, pageSize, teacherName);
        PageInfo pageInfoTwo = new PageInfo(listteacher);
        Map<String, Object> mapTwo = new HashMap<>();
        mapTwo.put("rows", listteacher);
        mapTwo.put("total", pageInfoTwo.getTotal());
        return mapTwo;
    }

    /*更改教练认证信息*/
    @RequestMapping("/updateteacher")
    @ResponseBody
    public ManagerUtil updateTeacher(Integer teacherId, Integer val) {
        int result = teacherService.updateIfauthById4_1(teacherId, val);
        if (result > 0) {
            return ManagerUtil.ok("认证成功");
        }
        return ManagerUtil.error("认证失败");
    }

    /*分页及模糊查询广告*/
    @RequestMapping("/selallad")
    @ResponseBody
    public Map<String, Object> allAdAndLimit(@RequestParam(value = "page", defaultValue = "1", required = false) Integer currentPage, @RequestParam(value = "rows"
            , defaultValue = "10", required = false) Integer
            pageSize, Integer datas, String adtitles) {
        System.out.println("获取数据广告++++++++++++++++++" + adtitles);
        System.out.println("获取数据++++++++++++++++++" + datas);
        List<Ad> listAd = managerService.selAllAdBylimit(currentPage, pageSize, datas, adtitles);
        PageInfo pagefo = new PageInfo(listAd);
        Map<String, Object> admap = new HashMap<>();
        admap.put("rows", listAd);
        admap.put("total", pagefo.getTotal());
        return admap;
    }

    /*认证更新广告*/
    @RequestMapping("/updatead")
    @ResponseBody
    public ManagerUtil updatead(Integer adId, Integer val) {
        System.out.println(adId + "daId" + "*****" + val);

        int result = managerService.updateAdByAdid(adId, val);
        if (result > 0) {
            return ManagerUtil.ok("认证成功");
        }
        return ManagerUtil.error("认证失败");
    }

    /*获取广告表前三个广告的所有数据*/
    @RequestMapping("/getads")
    @ResponseBody
    public Map<String, Object> listad() {
        List<Ad> listad = managerService.getadthree();
        Map<String, Object> admaps = new HashMap<>();
        admaps.put("rows", listad);
        return admaps;
    }

    /**
     * 查询出所有场馆信息传到前端
     */
    @RequestMapping("/showvenues")
    @ResponseBody
    public List<Venue> ShowVenues(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));

        int total = service.SelVenNum();
        int totalpage = 0;
        if (total / 4 != 0) {
            totalpage = total / 4 + 1;
        } else {
            totalpage = total / 4;
        }
        int lim = page * 4 - 4;
        List<Venue> venues = service.selectAllVenue4(lim);
        return venues;
    }

    /**
     * 分页,模糊查询所有商品信息
     */
    @RequestMapping("/getallgoods")
    @ResponseBody
    public Map<String, Object> allGoodsLimit(@RequestParam(value = "page", defaultValue = "1", required = false) Integer currentPage, @RequestParam(value = "rows"
            , defaultValue = "10", required = false) Integer
            pageSize, Integer type, String goodsName) {
        System.out.println("测试获取前端传参:+" + type + "名字:" + goodsName);
        List<Goods> listgoods = managerService.limitAllGoods4_1(currentPage, pageSize, type, goodsName);
        PageInfo pageinfogoods = new PageInfo(listgoods);
        Map<String, Object> goodsmap = new HashMap<>();
        goodsmap.put("rows", listgoods);
        goodsmap.put("total", pageinfogoods.getTotal());
        return goodsmap;
    }

    /**
     * 获取订单表的信息
     */
    @RequestMapping("/getmygoods")
    @ResponseBody
    public List<Myorder> listmyorder() {
        String username  = (String) SecurityUtils.getSubject().getPrincipal();/*shiro 里面获取用户名*/
        int uid = userService.getUserGoods4_1(username);
        List<Myorder> listorder = managerService.selAllOrderByuid4_1(uid);
        for (Myorder myorder : listorder) {
            myorder.setgName(managerService.selGnameByGid4_1(myorder.getGoodsId()));
        }
        return listorder;
    }

    @RequestMapping("/deletegoods")
    @ResponseBody
    public ManagerUtil deletegoods(Integer gId) {
        int result = managerService.deletegoodsByGid4_1(gId);
        if (result > 0) {
            return ManagerUtil.ok("删除成功");
        }
        return ManagerUtil.error("删除失败");
    }


    /*
   删除场馆
    */
    @RequestMapping("/delven")
    public String DelVen4(HttpServletRequest request) {
        int venue_id = Integer.parseInt(request.getParameter("venueId"));
        int row = service.DelVen4(venue_id);
        return "manager/hsn/Mvenue";
    }

    @RequestMapping("/venueDetail")
    @ResponseBody
    public Venue VenDetail4(HttpSession session) {
        int venueId = (int) session.getAttribute("venueId");
        Venue venue = service.SelVenById4(venueId);
        System.out.println(venue);
        return venue;
    }

    @RequestMapping("/shearch")
    @ResponseBody
    public List<Venue> ShearchVenue4(HttpServletRequest request) {
        String venname = request.getParameter("venname");
        String addrass = request.getParameter("addrass");
        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        List<Venue> venues = service.shearch(venname, addrass, phone, qq);
        System.out.println(venues);
        return venues;
    }


    /**
     * zjl
     * 更新商品数据 , 图片
     */
    @RequestMapping("/updategoods")
    @ResponseBody
    public ManagerUtil ipdategoods4_1(Goods goods) {
        System.out.println("修改商品信息,接收前端传参=" + goods);
        int result = managerService.updategoodsAndImg(goods, imgFile);
        imgFile = "";
        if (result > 0) {
            return ManagerUtil.ok("修改成功");
        }
        return ManagerUtil.error("修改失败");
    }

    /**
     * zjl
     * 专门接收图片
     */
    @RequestMapping("/updateimg")
    @ResponseBody
    public String getimg(HttpServletRequest request) throws IllegalStateException, IOException {
        System.out.println("-------------------------------------------");
        HttpSession session = request.getSession();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();
            System.out.println("开始获取图片");
            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String imgPath = UpLoadFileUtil.upLoadFile(request, file, "goodsImg");
                    System.out.println("图片路径获取==" + imgPath);
                    imgFile = imgPath;
                }
            }
        }
        return "success";
    }
    /** zjl
     * 获取商品的类型
     * */
    @RequestMapping("/getgoodstype")
    @ResponseBody
    public List<String> getAllGoodsType(){
        return managerService.getAllGoodsType4_1();
    }

    /**  zjl
     * 添加商品
     * */
    @RequestMapping("/addgoods")
    @ResponseBody
    public ManagerUtil addgoods(String gName1, Integer gPrice1, Integer gStock1, String gDescrption1, String gtype1) {
        System.out.println("获取前端传参:" + gName1 + "==" + gPrice1 + "==" + gStock1 + "===" + gDescrption1);
        return managerService.addgoods4_1(gName1, gPrice1, gStock1, gDescrption1, gtype1, imgFile);
    }

    @RequestMapping("/alipay")
    @ResponseBody
    public String alipay(String allmoney, String goodsIds,String goodscount, HttpServletRequest request,String goodsprice, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        System.out.println("获取前端参数数据=="+goodsIds+"=====数量==="+goodscount);


        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = UUIDCreate.createID();
        //付款金额，必填
        String total_amount = allmoney;
        //订单名称，必填
        String subject = "商品";
        //商品描述，可空
        String body = "物美价廉";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        //输出
        map.put("out_trade_no",out_trade_no);
        map.put("total_amount",total_amount);
        map.put("goodsIds",goodsIds);
        map.put("goodscount",goodscount);
        map.put("allmoney",allmoney);
        map.put("goodsprice",goodsprice);
        return result;
    }

    @RequestMapping("/success")
    public String success(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        int result = managerService.updateUserMoneyAndGoods4_1(map);
        map = null;
       if (result >0){
           return "manager/paysuccess";
       }

        return "manager/paysuccess";
    }
}
