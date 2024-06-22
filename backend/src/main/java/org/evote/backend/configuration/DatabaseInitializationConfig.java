package org.evote.backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.sql.DataSource;

@Configuration
public class DatabaseInitializationConfig {

    @Value("classpath:init_users.sql")
    private Resource initDataScript1;

    @Value("classpath:init_votes.sql")
    private Resource initDataScript2;

    @Autowired
    private Environment env;

    @Bean
    public DataSource usersDataSourceInit() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.users.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.users.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.users.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.users.password"));
        return dataSource;
    }

    @Bean
    public DataSource votesDataSourceInit() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.votes.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.votes.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.votes.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.votes.password"));

        return dataSource;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        System.out.println("host: " + env.getProperty("spring.mail.host"));
        System.out.println("port: " + env.getProperty("spring.mail.port"));
        System.out.println("username: " + env.getProperty("spring.mail.username"));
        System.out.println("password: " + env.getProperty("spring.mail.password"));
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.port")));
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));
        return mailSender;
    }

    @Profile("prod")
    @Bean
    public DataSourceInitializer dataSourceInitializer1() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(initDataScript1);

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(usersDataSourceInit());
        initializer.setDatabasePopulator(databasePopulator);

        return initializer;
    }

    @Profile("prod")
    @Bean
    public DataSourceInitializer dataSourceInitializer2() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(initDataScript2);

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(votesDataSourceInit());
        initializer.setDatabasePopulator(databasePopulator);

        return initializer;
    }
}