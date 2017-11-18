package com.cloud.mall.usermicriservice.model;

import java.io.Serializable;

public class Authority implements Serializable {


    private static final long serialVersionUID = -2266059186608916384L;
    /**
     * 
     * authority.id
     */
    private String id;

    /**
     * 
     * authority.name
     */
    private String name;

    /**
     * 
     * authority.parentid
     */
    private String parentid;

    /**
     * 
     * authority.sortnum
     */
    private Integer sortnum;

    /**
     * 
     * authority.style
     */
    private String style;

    /**
     * 
     * authority.icon
     */
    private String icon;

    /**
     * 
     * authority.available
     */
    private String available;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
