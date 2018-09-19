package com.cs.ln.springcloudconfigclient.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spirng的时间监听机制
 *
 * @Author liuchsh
 * @date 2018/9/18
 */
public class SpringEventListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>(){

               @Override
               public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
                   System.out.println("接收到事件："  + myApplicationEvent.getSource()  + "@" + myApplicationEvent.getApplicationContext());
               }
        });
        context.refresh();
        context.publishEvent(new MyApplicationEvent(context, "Hello World"));
        context.publishEvent(new MyApplicationEvent(context, 1));
        context.publishEvent(new MyApplicationEvent(context, new Integer(100)));
    }

    private static class MyApplicationEvent extends ApplicationEvent {

        private ApplicationContext applicationContext;


        public MyApplicationEvent(ApplicationContext applicationContext, Object source) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }
    }
}
