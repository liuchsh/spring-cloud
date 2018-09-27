package com.cs.ln.biz.controller;

import com.cs.ln.biz.service.BizService;
import com.cs.ln.biz.service.IBizService;
import com.cs.ln.user.model.User;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Random;

/**
 * 客户端的业务服务控制器
 *
 * @Author liuchsh
 * @date 2018/9/22
 */
@RestController
@RequestMapping("/biz")
public class BizController {

    private static final Random random = new Random();

    @Autowired
    private BizService bizService;

    @Autowired
    private IBizService iBizService;

//    @HystrixCommand(fallbackMethod = "errorContent",
//            commandProperties = {
//                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")})
    @PostMapping("/saveUser")
    public User saveUser(User user) throws InterruptedException {

//        int sleepTime = random.nextInt(200);
//        System.out.println("保存用户睡眠了" + sleepTime + "毫秒");
//
//        Thread.sleep(sleepTime);


//        if(bizService.saveUser(user)) {
//            return user;
//        }else {
//            return null;
//        }

        return iBizService.saveUser(user);
    }

    @GetMapping("/findAllUser")
    public Collection<User> findAllUser() {
        return iBizService.findAllUser();
    }

    @GetMapping("/helloWorld")
    public String hellWorld() {
        return new HelloWorldCommand().execute();
    }

    // TODO must return: class com.cs.ln.user.model.User or its subclass
    // TODO 为什么返回Object不行
    // 明白了，没有错
    public User errorContent(User user) {
        System.out.println("能拿到User? : " + user);
        return new User();
    }

    /**
     * 编程方式实现Hystrix 超时 容错
     */
    private static class HelloWorldCommand extends com.netflix.hystrix.HystrixCommand<String> {


        protected HelloWorldCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("HelloWorld"),
                    100);
        }

        @Override
        protected String run() throws Exception {
            int value = random.nextInt(200);

            System.out.println("helloWorld() costs " + value + " ms.");

            Thread.sleep(value);

            return "Hello,World";
        }

        //容错执行
        @Override
        protected String getFallback() {
            return "容错getFallback()";
        }
    }

}
