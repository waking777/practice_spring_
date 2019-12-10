package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，他的作用和bean.xml作用是一样的
 *      spring中的新注解
 * Configuration
 *      作用：指定当前类是一个配置类
 * ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：value和basePackages作用一样，我们使用此注解就相当于在xml里面配置了
 *      <context:component-scan base-package="com.itheima"></context:component-scan>
 * Bean
 *      作用：用于吧当前方法的返回值作为bean对象存入spring的容器中
 *      属性：name 指定bean的id  没写默认当前方法的名称
 *      细节：当我们使用注解配置方法时，如果方法有参数，spring会去容器中查找有没有可用的bean对象，查找的方式
 *      和Autowired方式一样的
 */
@Configuration
@ComponentScan(basePackages = "com.itheima")
public class SpringConfiguration {


    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource() throws Exception {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306:practice_xml_ioc");
        ds.setUser("root");
        ds.setPassword("root");
        return ds;
    }


}
