package com.cloud.mall.usermicriservice.model.vo;

import com.cloud.mall.usermicriservice.model.User;

/**
 * 用户VO
 *
 * @author Jon_China
 * @create 2017/11/12
 */
public class UserVO extends User {
    private static final long serialVersionUID = -2581494209891247630L;

    private int pageNum;

    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
