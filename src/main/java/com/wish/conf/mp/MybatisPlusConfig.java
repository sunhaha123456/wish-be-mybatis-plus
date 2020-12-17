package com.wish.conf.mp;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
public class MybatisPlusConfig {

//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        return new MybatisPlusInterceptor();
//    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}