package yc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * 启动类
 */

@SpringBootApplication
@Configuration
@Controller
public class SpringStartApplication extends SpringBootServletInitializer {



    public static void main(String[] args){

        SpringApplication.run(SpringStartApplication.class,args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringStartApplication.class);
    }


}
