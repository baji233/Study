package com.tjw.servlet;

public class ActionMapping {

    //配置文件中实现了Action接口的完整类名
    private String className;
    //配置文件中指定的方法名，如果没有，则默认为execute
    private String methodName = "execute";

    public ActionMapping() {
    }

    public ActionMapping(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "ActionMappingMap{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
