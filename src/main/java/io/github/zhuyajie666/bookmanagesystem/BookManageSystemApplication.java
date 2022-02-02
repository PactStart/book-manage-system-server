package io.github.zhuyajie666.bookmanagesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "io.github.zhuyajie666.bookmanagesystem.dao")
@SpringBootApplication
public class BookManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManageSystemApplication.class, args);
    }

}
