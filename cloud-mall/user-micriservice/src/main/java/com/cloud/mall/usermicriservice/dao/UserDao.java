package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int saveUser(User user);
}
