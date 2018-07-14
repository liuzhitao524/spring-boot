package com.hqins.demo.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = SlaveDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveDataSourceConfig {
    static final String PACKAGE ="com.hqins.demo.dao.slave";
    static final String MAPPER_LOCATION= "classpath:mapper/slave/*.xml";

    @Value("${spring.datasource.slave.url}")
    private String url;

    @Value("${spring.datasource.slave.username}")
    private String username;

    @Value("${spring.datasource.slave.password}")
    private String password;

    @Value("${spring.datasource.slave.driver-class-name}")
    private String driverClass;

    @Bean(name="slaveDataSource")
    public DataSource slaveDataSource(){
        DruidDataSource   slaveDataSource = new DruidDataSource();
        slaveDataSource.setUrl(url);
        slaveDataSource.setDriverClassName(driverClass);
        slaveDataSource.setUsername(username);
        slaveDataSource.setPassword(password);
        return slaveDataSource;
    }
    @Bean(name="slaveDataSourceTransactionManager")
    public DataSourceTransactionManager slaveDataSourceTransactionManager(){
            return new DataSourceTransactionManager(slaveDataSource());
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(slaveDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SlaveDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
