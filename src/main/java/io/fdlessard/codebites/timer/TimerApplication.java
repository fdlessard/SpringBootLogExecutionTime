package io.fdlessard.codebites.timer;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class TimerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimerApplication.class, args);
    }


    @Pointcut(
            "execution(public io.fdlessard.codebites.timer.domain.Customer io.fdlessard.codebites.timer.services.CacheableCustomerServiceImpl.getCustomerById(..))"
    )
    public void monitor() {
    }

    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("io.fdlessard.codebites.timer.TimerApplication.monitor()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }

    @Bean
    public CustomerKeyGenerator customerKeyGenerator() {
        // configure and return an implementation of Spring's KeyGenerator SPI
        return new CustomerKeyGenerator();
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return new CustomerJCacheManagerCustomizer();
    }
}




