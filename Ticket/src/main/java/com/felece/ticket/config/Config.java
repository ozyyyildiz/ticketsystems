package com.felece.ticket.config;

import com.felece.ticket.populators.impl.*;
import com.felece.ticket.populators.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class Config{

    @Value("${db.driver}")
    private String driver;

    @Value("${db.password}")
    private String password;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String show_sql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl_auto;

    @Value("${entitymanager.packagesToScan}")
    private String packages_to_scan;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(packages_to_scan);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", dialect);
        hibernateProperties.put("hibernate.show_sql", show_sql);
        hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddl_auto);
        hibernateProperties.put("hibernate.enable_lazy_load_no_trans", "true");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public TicketPopulator ticketPopulator(){
        return new TicketPopulatorImpl();
    }

    @Bean
    public UserPopulator userPopulator(){
        return new UserPopulatorImpl();
    }

    @Bean
    public SeatPopulator seatPopulator(){
        return new SeatPopulatorImpl();
    }

    @Bean
    public VehiclePopulator vehiclePopulator(){
        return new VehiclePopulatorImpl();
    }

    @Bean
    public RoutePopulator routePopulator(){
        return new RoutePopulatorImpl();
    }


}
