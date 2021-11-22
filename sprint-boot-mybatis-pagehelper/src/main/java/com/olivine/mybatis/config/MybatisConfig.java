package com.olivine.mybatis.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author jphao
 * @date 2021/11/21 22:07
 * @description mybatis 配置类
 */
@Configuration
@MapperScan("com.olivine.mybatis.mapper")
public class MybatisConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:mapper/**Mapper.xml"));
        sqlSessionFactory.setTypeAliasesPackage("com.olivine.mybatis.domain");

        // 分页插件 pagehelper
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");

        // 配置参数分页
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "pageNum=pageNumKey;pageSize=pageSizeKey");
        pageInterceptor.setProperties(properties);

        sqlSessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
        return sqlSessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

/*    *//**
     * 事务管理器
     * @param hikariDataSource
     * @return
     *//*
    @Bean
    public PlatformTransactionManager transactionManager(DataSource hikariDataSource) {
        return new DataSourceTransactionManager(hikariDataSource);
    }

    *//**
     * 配置 transactionTemplate
     * @param transactionManager
     * @return
     *//*
    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }*/
}
