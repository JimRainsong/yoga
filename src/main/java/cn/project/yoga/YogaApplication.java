package cn.project.yoga;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.project.yoga.dao")
public class YogaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YogaApplication.class, args);
    }

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        bean.setName("druid");
        Map map = new HashMap();
        map.put("loginUserName", "admin");
        map.put("loginPassword", "123456");
        bean.setInitParameters(map);
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.setOrder(1);
        Map map = new HashMap();
        map.put("exclusions", "*.js,*.css,/yoga/druid/*");
        bean.addUrlPatterns("/*");
        bean.setInitParameters(map);
        return bean;
    }



}
