import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: springboot-parent
 * @description: 启动类
 * @author: bin.liu
 * @create: 2019-03-14 15:31
 **/


@ComponentScan(basePackages = {"com.bin.liu.springboot.demo"})
@MapperScan("com.bin.liu.springboot.demo.mapper")
@EnableAutoConfiguration
//@SpringBootConfiguration
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
