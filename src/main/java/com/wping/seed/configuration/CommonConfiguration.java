package com.wping.seed.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * describe:
 *
 * @author Wping.gao
 * @date 2018/12/06
 */
@Configuration
public class CommonConfiguration {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(@Value("${thread.pool.corePoolSize}") int corePoolSize,
                                                         @Value("${thread.pool.maxPoolSize}") int maxPoolSize,
                                                         @Value("${thread.pool.queueCapacity}") int queueCapacity,
                                                         @Value("${thread.pool.keepAliveSeconds}") int keepAliveSeconds,
                                                         @Value("${thread.pool.allowCoreThreadTimeOut}") boolean allowCoreThreadTimeOut) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
        return threadPoolTaskExecutor;
    }
}
