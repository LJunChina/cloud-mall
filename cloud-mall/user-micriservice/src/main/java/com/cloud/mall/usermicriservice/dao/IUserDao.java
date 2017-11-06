package com.cloud.mall.usermicriservice.dao;

import com.cloud.mall.usermicriservice.model.User;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public interface IUserDao {
    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 根据条件查询用户信息
     * @param user
     * @return
     */
    User getUserInfo(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUserById(User user);
}
