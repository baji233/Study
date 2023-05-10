package com.jy.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Integer menuId;

    private String menuName;

    private String menuUrl;

    private Integer mfId;

    List<Menu> erji=new ArrayList<>();

    public List<Menu> getErji() {

        return erji;
    }

    public void setErji(List<Menu> erji) {
        this.erji = erji;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getMfId() {
        return mfId;
    }

    public void setMfId(Integer mfId) {
        this.mfId = mfId;
    }
}