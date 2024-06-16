package org.evote.backend.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;

@Configuration
public class TransactionManagerConfig {
    @Bean(name = "chainedTransactionManager")
    public ChainedTransactionManager transactionManager(
            @Qualifier("usersTransactionManager") org.springframework.transaction.PlatformTransactionManager usersTransactionManager,
            @Qualifier("votesTransactionManager") org.springframework.transaction.PlatformTransactionManager votesTransactionManager
    ) {
        return new ChainedTransactionManager(usersTransactionManager, votesTransactionManager);
    }
}
