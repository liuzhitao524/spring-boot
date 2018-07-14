//package com.hqins.demo.config.ds;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = SlaveDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "slaveSqlSessionFactory")
//public class SlaveDataSourceConfig {
//    static final String PACKAGE ="com.hqins.demo.dao.slave";
//    static final String MAPPER_LOCATION= "classpath:mapper/slave/*.xml";
//
//    @Value("${spring.datasources.slave.url}")
//    private String url;
//
//    @Value("${spring.datasources.slave.username}")
//    private String username;
//
//    @Value{"${spring.datasources.slave.password}"}
//    private String password;
//
//    @Value("${spring.datasources.slave.driver-class-name}")
//    private String driverClass;
//
//    @Bean(name="slaveDataSource")
//    public DataSource slaveDataSource(){
//        DruidDataSource   slaveDataSource = new DruidDataSource();
//        slaveDataSource.setUsername();
//        slaveDataSource.setUrl(url);
//        slaveDataSource.setDriverClassName(driverClass);
//        slaveDataSource.setUsername(username);
//        slaveDataSource.setPassword(password);
//        return slaveDataSource;
//    }
//    @Bean(name="slaveDataSourceTransactionManager")
//    public DataSourceTransactionManager slaveDataSourceTransactionManager(){
//
//    }
//
//}
