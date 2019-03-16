package com.bin.liu.springboot.demo.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: springboot-parent
 * @description: 测试配置
 * @author: bin.liu
 * @create: 2019-03-16 17:13
 **/

@Component
@ConfigurationProperties(prefix = "config")
@Data
public class TestConfig {

    String code;
    String name;
    List<String> hobby;
}
