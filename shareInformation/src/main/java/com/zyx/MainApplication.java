package com.zyx;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication //same as @Configuration @EnableAutoConfiguration @ComponentScan 
@MapperScan("com.zyx")
//@ComponentScan(basePackages= {"com.zyx.controller","com.zyx.service","com.zyx.dao","com.zyx.model"})
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
