package com.zyx;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication //same as @Configuration @EnableAutoConfiguration @ComponentScan 
@MapperScan("com.zyx.mapper")
//@ComponentScan(basePackages= {"com.zyx.controller","com.zyx.service","com.zyx.mapper","com.zyx.model","com.zyx.mapper"})
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
