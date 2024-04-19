package org.evote.backend.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.evote.backend.users",
        entityManagerFactoryRef = "usersEntityManagerFactory",
        transactionManagerRef = "usersTransactionManager")
public class UsersDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.users")
    public DataSourceProperties usersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.users.configuration")
    public DataSource usersDataSource() {
        return usersDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "usersEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean usersEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean emf = builder
                .dataSource(usersDataSource())
                .packages("org.evote.backend.users")
                .build();
        emf.setEntityManagerFactoryInterface(jakarta.persistence.EntityManagerFactory.class);
        return emf;
    }

    @Bean(name = "usersTransactionManager")
    public PlatformTransactionManager usersTransactionManager(
            final @Qualifier("usersEntityManagerFactory") LocalContainerEntityManagerFactoryBean usersEntityManagerFactory) {
        return new JpaTransactionManager(usersEntityManagerFactory.getObject());
    }


}
