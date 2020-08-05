package cn.ming.springboot.task.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author ren.xm
 * @description
 * @date 2020/8/5
 */
@Configuration
public class DataSourceConfiguration {

    /**
     * 创建 user 数据源的配置对象
     */
    @Primary
    @Bean(name = "userDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.user") // 读取 spring.datasource.user 配置到 DataSourceProperties 对象
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 创建 user 数据源
     */
    @Primary //@Primay 注解，表示其是主数据源
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user.hikari") // 读取 spring.datasource.user 配置到 HikariDataSource 对象
    public DataSource userDataSource() {
        // 获得 DataSourceProperties 对象
        DataSourceProperties properties =  this.userDataSourceProperties();
        // 创建 HikariDataSource 对象
        return createHikariDataSource(properties);
    }

    /**
     * 创建 quartz 数据源的配置对象
     */
    @Bean(name = "quartzDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.quartz") // 读取 spring.datasource.quartz 配置到 DataSourceProperties 对象
    public DataSourceProperties quartzDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 创建 quartz 数据源
     */
    @Bean(name = "quartzDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.quartz.hikari")
    @QuartzDataSource // @QuartzDataSource 注解，表示其是 Quartz 的数据源
    public DataSource quartzDataSource() {
        // 获得 DataSourceProperties 对象
        DataSourceProperties properties =  this.quartzDataSourceProperties();
        // 创建 HikariDataSource 对象
        return createHikariDataSource(properties);
    }

    private static HikariDataSource createHikariDataSource(DataSourceProperties properties) {
        // 创建 HikariDataSource 对象
        HikariDataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        // 设置线程池名
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return dataSource;
    }

}
