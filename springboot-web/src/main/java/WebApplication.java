import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: springboot-parent
 * @description: 启动类
 * @author: bin.liu
 * @create: 2019-03-14 15:31
 **/


@ComponentScan(basePackages = {"com.bin.liu.springboot.demo"})
@MapperScan("com.bin.liu.springboot.demo.mapper")
@EnableAutoConfiguration()
@PropertySource(value = {"classpath:application.properties","classpath:service.application.properties","classpath:dao.application.properties","classpath:entity.application.properties","classpath:common.application.properties"},ignoreResourceNotFound = true,encoding = "utf-8")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
