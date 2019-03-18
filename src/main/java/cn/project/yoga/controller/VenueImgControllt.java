package cn.project.yoga.controller;

import cn.project.yoga.utils.LayUiDataUtil;
import cn.project.yoga.utils.UpLoadFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/venueImg")
public class VenueImgControllt {

    @ResponseBody
    @RequestMapping(value = "/adImg")
    public LayUiDataUtil springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        System.out.println("-------------------------------------------");
      HttpSession session=request.getSession();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getServletContext());
        //检查form中是否有enctype="multipart/form-data"
      if(multipartResolver.isMultipart(request)){
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            System.out.println("开始获取图片");
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null){
                    /*session.setAttribute("img", file);*/
                    String mainpath="D:\\jet\\Project\\yoga\\src\\main\\resources\\static\\img\\vad\\";
                    /*IMGUtil.getImg(session,mainpath)*/
                    return LayUiDataUtil.ok(UpLoadFileUtil.upLoadFile(request,file,"vad"));
                }
            }
        }
        return LayUiDataUtil.error();
    }
}
