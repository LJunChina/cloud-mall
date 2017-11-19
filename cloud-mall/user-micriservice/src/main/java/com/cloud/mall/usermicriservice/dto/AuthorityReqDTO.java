package com.cloud.mall.usermicriservice.dto;

import java.io.Serializable;

/**
 * 权限request
 *
 * @author Jon_China
 * @create 2017/11/19
 */
public class AuthorityReqDTO implements Serializable {

    private static final long serialVersionUID = 3218445809112489706L;

    private String id;

    private String name;

    private String parentId;

    private Integer sortNum;

    private String style;

    private String icon;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
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
