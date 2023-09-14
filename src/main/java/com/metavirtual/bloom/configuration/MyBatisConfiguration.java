package com.metavirtual.bloom.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.metavirtual.bloom")
public class MyBatisConfiguration {

}
