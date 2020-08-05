package cn.ming.springboot.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 任晓明
 * @description
 * @date 2020/8/5
 */
@SpringBootApplication
public class Application02 {

    public static void main(String[] args) {
        // 设置 Tomcat 随机端口
        System.setProperty("server.port", "0");

        // 启动 Spring Boot 应用
        SpringApplication.run(Application.class, args);
    }

}