package top.xucg.wepay.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.xucg.wepay.core.config.PayConfig;

/**
 * 自动配置类
 *
 * @author xuchenguang
 * @since 2019.01.02
 */
@Configuration
@ConditionalOnClass(PayConfig.class)
@EnableConfigurationProperties(WinXinSdkProperties.class)
public class WinXinSdkAutoConfiguration {

    private final WinXinSdkProperties winXinSdkProperties;

    public WinXinSdkAutoConfiguration(WinXinSdkProperties winXinSdkProperties) {
        this.winXinSdkProperties = winXinSdkProperties;
    }

    @Bean
    @ConditionalOnMissingBean(PayConfig.class)
//    @ConditionalOnProperty(prefix = "wx-sdk", value = "enabled", havingValue = "true")
    PayConfig payConfig() {

        return winXinSdkProperties.getPayConfig();
    }

}