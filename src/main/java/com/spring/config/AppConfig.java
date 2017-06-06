package com.spring.config;

import com.spring.SpringApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
@Configuration
public class AppConfig {

    @Bean
    public SpringApp springApp(){
        return new SpringApp();
    }
}


