package top.lamp;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.lamp.mapper")
@DubboComponentScan("top.lamp.apimpl")
public class BookTypeProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookTypeProviderApplication.class, args);
    }

}
