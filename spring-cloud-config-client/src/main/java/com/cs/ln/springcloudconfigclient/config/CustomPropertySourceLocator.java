package com.cs.ln.springcloudconfigclient.config;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 写注释
 *
 * @Author liuchsh
 * @date 2018/9/19
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomPropertySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        Map<String, Object> source = new HashMap<>();
        source.put("server.port", "9090");
        MapPropertySource mapPropertySource = new MapPropertySource("myProperty", source);
        return mapPropertySource;

//        return new MapPropertySource("customProperty",
//                Collections.<String, Object>singletonMap("property.from.sample.custom.source", "worked as intended"));
    }

}
