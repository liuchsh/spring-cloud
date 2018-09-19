package com.cs.ln.springcloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringCloudConfigClientApplication.class);
		springApplication.run(args);




//		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}



}
