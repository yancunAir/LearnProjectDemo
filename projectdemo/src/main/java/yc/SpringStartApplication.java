package yc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring启动类
 * author:yancun
 */

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"yc"})
public class SpringStartApplication {



    public static void main(String[] args){

        SpringApplication.run(SpringStartApplication.class,args);

    }




}
