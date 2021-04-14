package com.springboot.demo.springbootdemo;

import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import java.util.Set;

@Configuration
public class Config {

    @Bean
    public SimpleCacheManager simpleCacheManager(Set<Cache> caches) {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        simpleCacheManager.setCaches(caches);

        return simpleCacheManager;
    }

    @Bean(name = "employees")
    public ConcurrentMapCacheFactoryBean getEmployeesCache() {
        return new ConcurrentMapCacheFactoryBean();
    }

    @Bean(name = "empl")
    public ConcurrentMapCacheFactoryBean getEmplCache() {
        return new ConcurrentMapCacheFactoryBean();
    }

    @Bean
    public SpringSecurityDialect thymeleaf() {
        return new SpringSecurityDialect();
    }
}
