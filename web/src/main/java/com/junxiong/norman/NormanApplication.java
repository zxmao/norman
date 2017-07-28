package com.junxiong.norman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author zhangjunxiong
 * @since 2017/7/27
 */
@SpringBootApplication
//@ComponentScan({"com.delivery.request"})
@EnableJpaRepositories("com.junxiong.norman.repo")
@EntityScan("com.junxiong.norman.entity")
public class NormanApplication {
    public static void main(String[] args) {
        SpringApplication.run(NormanApplication.class, args);
    }
}
