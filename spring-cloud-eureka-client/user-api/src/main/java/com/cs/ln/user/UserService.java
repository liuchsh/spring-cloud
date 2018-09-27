package com.cs.ln.user;

import com.cs.ln.user.model.User;

import java.util.Collection;

/**
 * {@link User 用户}服务
 *
 * @Author liuchsh
 * @date 2018/9/22
 */
public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return 如果保存成功，返回true,否则返回false
     */
    boolean save(User user);

    /**
     * 查询所有用户对象
     * @return 不会返回null
     */
    Collection<User> findAll();
}
