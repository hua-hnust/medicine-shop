package com.medicine.shop.configurations;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

/** 数据库配置
 * @Author xhua
 * @Date 2020/3/21 23:23
 **/
@Configuration
@MapperScan(basePackages = {"com.medicine.shop.mapper"},sqlSessionFactoryRef = "sqlSessionFactory")
public class DbConfiguration {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    /** 数据源 **/
    @Primary
    @Bean("dbConfig")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws SQLException {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     *  mysql分页插件
     * @return
     */
    @Bean("pagePlugins")
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor().setDialectType(DbType.MYSQL.getDb());
    }

    /** 会话工厂 **/
    @Primary
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dbConfig")DataSource dataSource, @Qualifier("pagePlugins") PaginationInterceptor paginationInterceptor) throws Exception{
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        Interceptor[] plugins = {paginationInterceptor};
        factoryBean.setPlugins(plugins);
        return factoryBean.getObject();
    }

    /** 事务控制 **/
    @Primary
    @Bean("transaction")
    public DataSourceTransactionManager transactionManager(@Qualifier("dbConfig") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @PostConstruct
    @Bean("globalConfig")
    public GlobalConfig globalConfig(){
        // 全局配置文件
        GlobalConfig globalConfig = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        // 默认为自增
        dbConfig.setIdType(IdType.AUTO);
        // 手动指定db 的类型, 这里是mysql
        dbConfig.setDbType(DbType.MYSQL);
        globalConfig.setDbConfig(dbConfig);
        // 逻辑删除注入器
        LogicSqlInjector injector = new LogicSqlInjector();
        globalConfig.setSqlInjector(injector);
        return globalConfig;
    }
}
