package com.cs.ln.user.service.impl;

import com.cs.ln.user.UserService;
import com.cs.ln.user.model.User;
import com.cs.ln.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * {@link User 用户}服务实现类
 *
 * @Author liuchsh
 * @date 2018/9/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
