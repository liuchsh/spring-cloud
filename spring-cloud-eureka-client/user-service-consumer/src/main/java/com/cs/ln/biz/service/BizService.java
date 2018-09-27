package com.cs.ln.biz.service;

import com.cs.ln.user.UserService;
import com.cs.ln.user.model.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * TODO 写注释
 *
 * @Author liuchsh
 * @date 2018/9/22
 */
@Service
public class BizService {

    private static final String USER_SERVICE_URL_PREFIX = "http://user-service-provider";

    @Autowired
    private RestTemplate restTemplate;


    public boolean saveUser(User user) {
        User returnValue = restTemplate.postForObject(USER_SERVICE_URL_PREFIX + "/user/save", user, User.class);
        return returnValue != null;
    }

    public Collection<User> findAllUser() {
        return restTemplate.getForObject(USER_SERVICE_URL_PREFIX + "/user/list", Collection.class);
    }


}
