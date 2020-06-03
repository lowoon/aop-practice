package aop.demo;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "aop.demo")
@EnableSqlService
@PropertySource("/database.properties")
public class AppContext {
    @Value("${db.driverClass}")
    Class<? extends Driver> driverClass;
    @Value("${db.url}")
    String url;

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriverClass(Driver.class);
        ds.setUrl("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8");
        ds.setUsername("spring");
        ds.setPassword("book");
        return ds;
    }

    @Configuration
    @Profile("production")
    public static class ProductionAppContext {
        @Bean
        public MailSender mailSender() {
            return new JavaMailSender();
        }
    }

    @Configuration
    @Profile("test")
    public static class TestAppContext {
        @Bean
        public MailSender mailSender() {
            return new DummyMailSender();
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
