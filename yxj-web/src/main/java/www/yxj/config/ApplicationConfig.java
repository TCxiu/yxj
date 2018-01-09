package www.yxj.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "www.yxj")
@MapperScan(basePackages = "www.yxj.mapper")
public class ApplicationConfig{
    @Bean
    public DruidDataSource dataSource() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.0.102:3306/yxj?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("203204");
        return dataSource;
    }

    @Bean("sqlSessionFactory")
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("www.yxj");
        return sqlSessionFactoryBean;
    }
}
