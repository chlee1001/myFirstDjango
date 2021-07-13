package com.chaehyeon.blog_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class BlogProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogProjectApplication.class, args);
    }

}
