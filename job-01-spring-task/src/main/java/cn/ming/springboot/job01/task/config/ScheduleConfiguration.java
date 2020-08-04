package cn.ming.springboot.job01.task.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ren.xm
 * @description
 * @date 2020/8/4
 */
@Configuration
@EnableScheduling // 启动 Spring Task 的定时任务调度
public class ScheduleConfiguration {
}
