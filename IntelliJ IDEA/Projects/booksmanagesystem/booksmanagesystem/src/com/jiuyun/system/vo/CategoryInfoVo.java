package com.jiuyun.system.vo;

public class CategoryInfoVo {
	String cateGoryId;
    String cateGoryName;
    String cateGoryStructure;

    public CategoryInfoVo(){

    }

    public CategoryInfoVo(String cateGoryId, String cateGoryName,String cateGoryStructure) {
        this.cateGoryId = cateGoryId;
        this.cateGoryName = cateGoryName;
        this.cateGoryStructure=cateGoryStructure;
    }

    public String getCateGoryId() {
        return cateGoryId;
    }

    public void setCateGoryId(String cateGoryId) {
        this.cateGoryId = cateGoryId;
    }

    public String getCateGoryName() {
        return cateGoryName;
    }

    public void setCateGoryName(String cateGoryName) {
        this.cateGoryName = cateGoryName;
    }

    public String getCateGoryStructure() {
        return cateGoryStructure;
    }

    public void setCateGoryStructure(String cateGoryStructure) {
        this.cateGoryStructure = cateGoryStructure;
    }

}
