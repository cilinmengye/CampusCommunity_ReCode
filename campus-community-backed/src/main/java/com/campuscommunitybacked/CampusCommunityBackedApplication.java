package com.campuscommunitybacked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 初始化Springboot：
 * 创建Maven工程
 * 导入spring-boot-stater-web起步依赖
 * 编写Controller
 * 提供启动类↓
 */
@SpringBootApplication
public class CampusCommunityBackedApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusCommunityBackedApplication.class, args);
    }

}
