package org.evote.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import javax.sql.DataSource;

@Configuration
public class DatabaseInitializationConfig {

    @Value("classpath:init_votes.sql")
    private Resource initDataScript1;



    @Bean
    public DataSourceInitializer dataSourceInitializer1(DataSource dataSource1) {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(initDataScript1);

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource1);
        initializer.setDatabasePopulator(databasePopulator);

        return initializer;
    }


}
