package com.example.demo;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {//ExecutorService אני נשתמשת
  @Bean(name = "myPool")//שם של הPOOL
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // כמה טרדים יחכו תמיד לעבודה
        executor.setMaxPoolSize(5);  //  כמה מקסימום טרדים בעומס
        executor.initialize();
        return executor;
    }

}
