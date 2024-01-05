//package team.weyoung.config;
//
//import com.mybatisflex.core.mybatis.FlexConfiguration;
//import com.mybatisflex.spring.boot.ConfigurationCustomizer;
//import org.apache.ibatis.logging.stdout.StdOutImpl;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author Tunan
// * @version 1.0
// * @since 2023/11/1
// */
//@Configuration
//public class MyConfigurationCustomizer implements ConfigurationCustomizer {
//
//    /**
//     * 自定义配置 MyBatis-flex
//     * @param configuration MyBatis-flex 配置
//     *                     开启日志输出到控制台
//     */
//    @Override
//    public void customize(FlexConfiguration configuration) {
//        configuration.setLogImpl(StdOutImpl.class);
//    }
//}