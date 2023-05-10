package com.tjw.servlet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    //用于存储所有的xml配置信息。key：请求路径 ； value: 类名和方法名
    private Map<String, ActionMapping> actionMappingMap;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doService(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doService(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载myData.xml和初始化ActionMappingMap类
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化时DispatcherServlet会使用类加载器获取指定xml文件的路径
        String xmlPath = DispatcherServlet.class.getClassLoader().getResource("myData.xml").getPath();
        try {
            actionMappingMap = getActionMapping(xmlPath);
            log.debug("配置文件加载完毕：" + actionMappingMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过路径加载xml文件，获取所有myActions配置
     * @param xmlPath
     * @return
     */
    private Map<String, ActionMapping> getActionMapping(String xmlPath) throws DocumentException {
        Map<String, ActionMapping> xmlMap = new HashMap<>();
        //通过SAX扫描器加载xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(xmlPath);
        Element root = document.getRootElement();
        List<Element> actionElementList = root.elements();
        for(Element e : actionElementList){
            xmlMap.put(e.attributeValue("id"), new ActionMapping(e.attributeValue("class"), e.attributeValue("method")));
        }
        return xmlMap;
    }

    private void doService(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ServletException, IOException {
        //path：请求URI中项目名后的路径
        String path = req.getRequestURI().substring(req.getContextPath().length() + 1);
        //通过路径匹配映射关系对象
        ActionMapping actionMapping = actionMappingMap.get(path.substring(0,path.lastIndexOf(".")));
        if(actionMapping != null){
            //如果myData.xml中存在此path的映射
            Class clas= Class.forName(actionMapping.getClassName());//actionMapping: Action的实现类
            Object object = clas.newInstance();
            //clas.getMethod(方法名，参数类型.class); 其中方法名例如execute、save、delete...
            Method method =  clas.getMethod(actionMapping.getMethodName(),HttpServletRequest.class,HttpServletResponse.class);
            //执行完方法后返回typeOrURI：跳转类型:跳转页面
            String typeOrURL = (String)method.invoke(object,req,resp);
            String type = typeOrURL.substring(0,typeOrURL.indexOf(":"));
            String url = type.substring(typeOrURL.indexOf(":") + 1);
            //根据type和url判断跳转类型和页面
            if("forward".equals(type)){
                //转发
                req.getRequestDispatcher(url).forward(req,resp);
            }else if("redirect".equals(type)){
                //重定向
                resp.sendRedirect(url);
            }
        }
    }
}

















