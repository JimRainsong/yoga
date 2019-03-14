package cn.project.yoga.utils;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UpLoadFileUtil {
    public static String upLoadFile(HttpServletRequest request, MultipartFile imgName, String mypath){
        System.out.println("====================file名字===="+imgName.getName());
        ServletContext context = request.getServletContext();
        String mainpath=context.getRealPath("/img/"+mypath+"/");
        String path ="D:\\idework\\yoga\\src\\main\\resources\\static\\img\\"+mypath+"\\";
        //判断这个文件夹是否存在，不存在则创建
        File files = new File(path);
        if (!files.exists()) {
            files.mkdirs();
        }
        File mainfile = new File(mainpath);
        if (!mainfile.exists()) {
            mainfile.mkdirs();
        }
        //1.先得到名字
        String fileName = UUID.randomUUID().toString();
        String fileNames=imgName.getOriginalFilename();
        //2.得到扩展名
        String extend = fileNames.substring(fileNames.lastIndexOf("."));
        //3.得到完整文件名
        fileName+=extend;
        File fileover=new File(path+fileName);
        System.out.println("===================================开始保存文件");
        try {
            imgName.transferTo(fileover);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("====================================开始复制文件");
        try {
            FileCopyUtils.copy(fileover, new File(mainpath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(mainpath+fileName);
        String source="/yoga/img/"+mypath+"/"+fileName;



        return source;
    }
}
