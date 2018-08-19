package com.cxl.springboot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cxl.springboot.mapper")
public class WebDemoApplication {

	public static void main(String[] args) {
		//启动了springboot程序，启动spring容器，启动内嵌的tomcat
		SpringApplication.run(WebDemoApplication.class, args);
	}
}
