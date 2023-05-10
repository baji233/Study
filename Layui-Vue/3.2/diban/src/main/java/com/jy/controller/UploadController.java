package com.jy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller

@RequestMapping("/Upload")
public class UploadController {

    //文件上传，jar包，依赖于commons。。。。 。springMVC要配置
    @RequestMapping("upload")
    public String up(MultipartFile file, HttpServletRequest request) throws IOException {
    //文件已经上传到了java内存中了
    //把文件放入指定位置上
        //得到当前项目在tomcat中处于磁盘的真实路径
        //d:tomcat/workspace/xm/image
        String realPath=request.getServletContext().getRealPath("image");
        File mf=new File(realPath,file.getOriginalFilename());
        if(!mf.exists()){
            mf.mkdirs();//如果路径不存在就创建
        }
        file.transferTo(mf);//把上传的文件，放入到mf指定的路径下
        return "";
    }

}
