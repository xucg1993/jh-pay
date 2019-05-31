package top.xucg.wepay.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import top.xucg.wepay.core.config.PayConfig;

/**
 * 配置模板
 *
 * @author xuchenguang
 * @since 2019.01.02
 */
@ConfigurationProperties(prefix = WinXinSdkProperties.WX_SDK_PREFIX)
public class WinXinSdkProperties {

    public static final String WX_SDK_PREFIX = "wx-sdk";

    private PayConfig payConfig;


    public PayConfig getPayConfig() {
        return payConfig;
    }

    public void setPayConfig(PayConfig payConfig) {
        this.payConfig = payConfig;
    }
}