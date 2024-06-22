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
import java.util.Properties;

@Configuration
public class DatabaseInitializationConfig {

    @Value("classpath:init_users.sql")
    private Resource initDataScript1;

    @Value("classpath:init_votes.sql")
    private Resource initDataScript2;

    @Value("classpath:init_users_test.sql")
    private Resource initDataScript3;

    @Value("classpath:init_votes_test.sql")
    private Resource initDataScript4;

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
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.port")));
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
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

    @Profile("dev")
    @Bean
    public DataSourceInitializer dataSourceInitializer3() {
        System.out.println("LOOOL");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(initDataScript3);

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(usersDataSourceInit());
        initializer.setDatabasePopulator(databasePopulator);
        System.out.println("LOOOL2");
        return initializer;
    }

    @Profile("dev")
    @Bean
    public DataSourceInitializer dataSourceInitializer4() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(initDataScript4);

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(votesDataSourceInit());
        initializer.setDatabasePopulator(databasePopulator);

        return initializer;
    }

}