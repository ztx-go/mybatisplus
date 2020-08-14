package com.example.demomb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@MapperScan("com.example.demomb.mapper")
@EnableSwagger2
@SpringBootApplication
public class DemombApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemombApplication.class, args);
    }

}
