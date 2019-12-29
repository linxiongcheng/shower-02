package org.yuan.boot.webmvc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yuan.boot.DbCoreApplication;
import org.yuan.boot.db.DbMybatisPlusApplication;
import org.yuan.boot.webmvc.WebMvcCoreApplication;

/**
 * @program: learning-demo-02
 * @description:
 * @author: yuane
 * @create: 2019-12-29 23:15
 */
@SpringBootApplication(scanBasePackageClasses = {WebMvcCoreApplication.class, DbCoreApplication.class, DbMybatisPlusApplication.class})
public class WebMvcApplication05 {
    public static void main(String[] args) {
        SpringApplication.run(WebMvcCoreApplication.class, args);
    }
}