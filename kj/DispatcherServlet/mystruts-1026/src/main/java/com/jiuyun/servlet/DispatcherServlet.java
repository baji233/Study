package com.jiuyun.servlet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

/**
 * @author cj
 * @create 2022年10月27日 18:37:38
 */
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    //用于存储所有的xml配置信息。key：actionId ; value: 类名和方法
    private Map<String, ActionMapping> actionMappingMap;

    @Override
    public void init() throws ServletException {
        //初始化时，调度Servlet会使用类加载器获取指定xml文件的路径
        String path = DispatcherServlet.class.getClassLoader().getResource("my_struts.xml").getPath();
        try {
            //xml配置文件全部加载到actionMappingMap中
            actionMappingMap = getActionMapping(path);
            log.debug("配置文件加载完毕：" + actionMappingMap);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doService(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doService(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //path：请求URI中项目名后的路径
        String path = request.getRequestURI().substring(request.getContextPath().length() + 1);
        log.debug("path:" + path);
        //通过路径匹配映射关系对象
        ActionMapping actionMapping = actionMappingMap.get(path.substring(0, path.lastIndexOf(".")));//key是路径里*.do中的*
        if(actionMapping != null) { //actionMapping: Action的实现类和方法
            Class clazz = Class.forName(actionMapping.getClassName());
            Object object = clazz.newInstance();
            //Method m = Class c.getMethod(mName,pType.class);
            Method method = clazz.getMethod(actionMapping.getMethodName(), HttpServletRequest.class, HttpServletResponse.class);//actionMapping.getMethodName() : execute,save,delete
            String viewPath = (String) method.invoke(object, request, response);//调用execute方法或者save方法...会返回跳转类型:跳转页面
            String type = viewPath.substring(0, viewPath.indexOf(":"));
            String url = viewPath.substring(viewPath.indexOf(":") + 1);
            if("forward".equals(type)) {
                request.getRequestDispatcher(url).forward(request,response);
            } else {
                response.sendRedirect(url);
            }
        }
    }

    /**
     * 通过路径加载配置文件，获取所有action配置
     * @param path
     * @return
     * @throws DocumentException
     */
    private Map<String, ActionMapping> getActionMapping(String path) throws DocumentException {
        Map<String, ActionMapping> actionMappingMap = new HashMap<>();
        //通过SAX扫描器加载xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(path);
        Element root = document.getRootElement();
        List<Element> actionList = root.elements();
        for (Element element : actionList) {
            actionMappingMap.put(element.attributeValue("id"), new ActionMapping(element.attributeValue("class"), element.attributeValue("method")));
        }
        return actionMappingMap;
    }
}
