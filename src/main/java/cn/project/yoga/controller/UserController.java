package cn.project.yoga.controller;

import ch.qos.logback.core.util.FileUtil;
import cn.project.yoga.pojo.Ad;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.User;
import cn.project.yoga.pojo.User_info;
import cn.project.yoga.service.ManagerService;
import cn.project.yoga.service.UserService;
import cn.project.yoga.utils.*;
import cn.project.yoga.vo.LoginVo;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ManagerService managerService;


    @RequestMapping("/login")
    @ResponseBody
    public String login1(LoginVo vo) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            System.out.println(vo.getUserName());
            UsernamePasswordToken token = new UsernamePasswordToken(vo.getUserName(), vo.getPassword());
            System.out.println(token.getPrincipal().toString());
            token.setRememberMe(true);
            try {
                subject.login(token);
                return "登陆成功";
            } catch (UnknownAccountException uae) {
                return "未知的用户类型";
            } catch (IncorrectCredentialsException ice) {
                return "账号或者密码错误";
            } catch (LockedAccountException lae) {
                return "账号已被锁定";
            } catch (AuthenticationException ae) {
                return "账号或者密码错误";
            } catch (Exception e) {
                return "人品问题，登录失败";
            }
        } else {
            return "干哈?!你都已经登陆成功了";
        }
    }


    @RequestMapping("/register")
    @ResponseBody
    public String register1(@RequestParam(value = "username") String username, @RequestParam(value = "password1") String password1, @RequestParam(value = "password2") String password2) {

        if (!password1.matches(RegexUtil.REGEX_PASSWORD)) {
            return "密码格式有误请重新输入";
        }

        if (!password1.equals(password2)) {
            return "两次密码不一致";
        }
        //通过 username在数据库中找 user 判断是否重名

        User user = userService.selectUserByUserName(username);//搜索一个 TeacherService.selectUserbyUserName
        if (user != null) {
            return "；用户名已经存在了哦亲亲 请换一个";
        }
        // 进行MD5加密存入数据库 加密次数2次 盐值用户名
        String newpassword = Md5Encoder.md5Encode(username, password1);
        //将user1 插入至数据库(两张表)
        User user1 = new User();
        user1.setUserName(username);
        user1.setPassword(newpassword);
        int i1 = userService.addUser(user1);
        int i2 = userService.insert_userid_user(username);
        System.out.println(i1 + i2);
        return "注册成功";
    }

    /**
     * 修改用户信息
     * @author zjn
     * @param user
     * @return 字符串，更新成功/失败
     */
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateInfo(User_info user){
       String state = userService.updateUserInfo1(user);
        return state;
    }
    @RequestMapping("/lookAd")
    @ResponseBody
    public List<Ad> lookAd(){
        List<Ad> ad=userService.selectAd();
        return ad;
    }

    @RequestMapping("/getUserName")
    @ResponseBody
    public String getUserName(){
        Subject subject=SecurityUtils.getSubject();
        Session session=subject.getSession();
        String userName="";
        Collection collection=session.getAttributeKeys();
        userName=(String) subject.getPrincipal();
        String name=userService.selectUserNetName(userName);
        return name;
    }

    /**
     * 查询个人信息 zjn
     * @return
     */
    @RequestMapping("/selectMyInfo")
    @ResponseBody
    public User_info getUserInfo(){
        User_info user_info=userService.selectMyInfo();
        System.out.println(user_info.getLevel());
        return user_info;
    }

    /**
     * 用户充值
     * @return
     */
    @RequestMapping("/recharge")
    @ResponseBody
    public String recharge(Integer money){
        String state=userService.recharge(money);
        return state;
    }


    /**
     * 上传文件（头像）
     * @param request
     * @param imgName
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String upload(HttpServletRequest request,MultipartFile imgName,String mypath) throws IOException {
        /*String imgname=imgName.getOriginalFilename();
        System.out.println("图片名："+imgName);
        if (imgname==null || imgname.equals("")) {
            return "请选择文件";
        }


        //根据当前项目的路径获取到服务器的物理路径
        ServletContext context = request.getServletContext();
        String path1 = context.getRealPath("/img/head_imgs/");
        String path="D:\\idework\\yoga\\src\\main\\resources\\static\\img\\head_imgs";
        System.out.println(path);
       // System.out.println(path1);
        //判断当前服务器是否有upload文件夹
        File file = new File(path);
        File file1=new File(path1);
        if(!file.exists()) file.mkdirs();
        if (!file1.exists()) file.mkdirs();
        //在file文件夹里面创建一个文件对象*/
       // String filename=changeName(imgName.getOriginalFilename());
       /* File file2 = new File(path,filename);



        try {
            imgName.transferTo(file1);
            FileCopyUtils.copy(file2,new File(path,filename));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "上传失败";
        } catch (IOException e) {

            e.printStackTrace();
            return "上传失败";
        }

*/


      String source =  UpLoadFileUtil.upLoadFile(request,imgName,mypath);
      String state=userService.updateImg(source);


        return state;


            }





    public String changeName(String oldName){
        return UUID.randomUUID()+"_"+oldName;
    }


    /*
     * 根据ID查询学员详细信息*/
    @RequestMapping("/userDetail")
    @ResponseBody
    public User_info userDetail4(HttpSession session){
        int uId= (int) session.getAttribute("uId");
        User_info user_info=userService.SelUserById(uId);
        return user_info;
    }

    /*
     * 根据条件查询学员*/
    @RequestMapping("/shearch")
    @ResponseBody
    public List<User_info> Shearch(HttpServletRequest request){
        String netName=request.getParameter("netName");
        String sex=request.getParameter("sex");
        String qq=request.getParameter("qq");
        String phoneNumber=request.getParameter("phoneNumber");
        List<User_info>user_infos= userService.shearch(netName,sex,phoneNumber,qq);
        return user_infos ;
    }
    /*
     * 软删除学员*/
    @RequestMapping("/deluser")
    public String DelUser4(HttpServletRequest request){
        int uId=Integer.parseInt(request.getParameter("uId"));
        System.out.println(uId);
        userService.DelUserById4(uId);
        return "menager/hsn/user";
    }

    /*
    * 分页查询所有学员*/
    @RequestMapping("/userDatas")
    @ResponseBody
    public Map<String, Object> showuserDatas4(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                                @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize) {
        List<User_info> list = managerService.SelUser4(currentPage,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;

    }

}
