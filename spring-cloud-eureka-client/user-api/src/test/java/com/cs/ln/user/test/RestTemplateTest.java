package com.cs.ln.user.test;

import com.cs.ln.user.model.User;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

/**
 * TODO 写注释
 *
 * @Author liuchsh
 * @date 2018/9/25
 */
public class RestTemplateTest {

    public static void main(String[] args) {

        // 自定义http实现
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        // 用来实现自定义的协议
        //restTemplate.setMessageConverters(...);
        // 用来设置拦截器
//        restTemplate.setInterceptors(...);

        Collection<User> users = restTemplate.getForObject("http://localhost:8080/biz/findAllUser", Collection.class);

        System.out.println(users);
    }
}
