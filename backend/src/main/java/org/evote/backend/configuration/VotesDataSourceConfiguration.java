package org.evote.backend.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.evote.backend.votes",
        entityManagerFactoryRef = "votesEntityManagerFactory",
        transactionManagerRef = "votesTransactionManager")
public class VotesDataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.votes")
    public DataSourceProperties votesDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.votes.configuration")
    public DataSource votesDataSource() {
        return votesDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "votesEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean votesEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean emf = builder
                .dataSource(votesDataSource())
                .packages("org.evote.backend.votes")
                .build();
        emf.setEntityManagerFactoryInterface(jakarta.persistence.EntityManagerFactory.class);
        return emf;
    }

    @Bean(name = "votesTransactionManager")
    @Primary
    public PlatformTransactionManager votesTransactionManager(
            final @Qualifier("votesEntityManagerFactory") LocalContainerEntityManagerFactoryBean votesEntityManagerFactory) {
        return new JpaTransactionManager(votesEntityManagerFactory.getObject());
    }
}
