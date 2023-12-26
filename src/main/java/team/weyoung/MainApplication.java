package team.weyoung;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 主类（项目启动入口）
 *
 * @author <a href="https://github.com/Tunan81">图南</a>
 */

@EnableScheduling
@SpringBootApplication
@MapperScan("team.weyoung.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println("接口地址:" + "<a href='http://localhost:8101/api/doc.html'>接口地址</a>");
        System.out.println("(♥◠‿◠)ﾉﾞ  项目启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "  ██       ██             ██    ██                                           \n" +
                " ░██      ░██            ░░██  ██                                     █████  \n" +
                " ░██   █  ░██    █████    ░░████      ██████    ██   ██   ███████    ██░░░██ \n" +
                " ░██  ███ ░██   ██░░░██    ░░██      ██░░░░██  ░██  ░██  ░░██░░░██  ░██  ░██ \n" +
                " ░██ ██░██░██  ░███████     ░██     ░██   ░██  ░██  ░██   ░██  ░██  ░░██████ \n" +
                " ░████ ░░████  ░██░░░░      ░██     ░██   ░██  ░██  ░██   ░██  ░██   ░░░░░██ \n" +
                " ░██░   ░░░██  ░░██████     ░██     ░░██████   ░░██████   ███  ░██    █████  \n" +
                " ░░       ░░    ░░░░░░      ░░       ░░░░░░     ░░░░░░   ░░░   ░░    ░░░░░   \n"
        );
    }
}
