package com.jy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller

@RequestMapping("/Upload")
public class UploadController {

    //文件上传，jar包，依赖于commons。。。。 。springMVC要配置
    @ResponseBody
    @RequestMapping("upload")
    public Map up(MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("upload,..........,,,,,,,,,,,,,,,,,");
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
        Map map=new HashMap();
        map.put("code",1);
        map.put("data","image/"+file.getOriginalFilename());
        //返回文件的路径和名称
        return map;
    }

}
