package com.cs.ln.biz.service;

import com.cs.ln.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * 使用Feign调用远程服务
 *
 * @Author liuchsh
 * @date 2018/9/27
 */
@FeignClient("user-service-provider")
public interface IBizService {

    @RequestMapping(method = RequestMethod.POST, value="/user/save", consumes = "application/json")
    public User saveUser(User user);

    @RequestMapping(method = RequestMethod.GET, value="/user/list")
    public Collection<User> findAllUser();
}
