package top.xucg.wepay.pay.pay;

import org.springframework.beans.factory.annotation.Autowired;
import top.xucg.wepay.core.config.PayConfig;
import top.xucg.wepay.core.sdk.WXPay;

/**
 * @author xuchenguang
 * @since 2019.01.03
 */
public class WXBase {


    @Autowired
    PayConfig config;

    public void setConfig(PayConfig config) {
        this.config = config;
    }

    //    @Autowired
//    WinXinSdkConfigService sdkConfigService;

    /**
     * 微信预支付
     *
     * @param
     * @return
     */
    WXPay getWXPay() throws Exception {
//        PayConfig config = new PayConfig();
//        config.setAppId(sdkConfigService.getPayAppId());
//        config.setMchId(sdkConfigService.getPayMchId());
//        config.setPayKey(sdkConfigService.getPayKey());
//        config.setCertPath(sdkConfigService.getPayCertPath());
        return new WXPay(config);
    }

    PayConfig getWXConfig() throws Exception {
//        PayConfig config = new PayConfig();
//        config.setAppId(sdkConfigService.getPayAppId());
//        config.setMchId(sdkConfigService.getPayMchId());
//        config.setPayKey(sdkConfigService.getPayKey());
//        config.setCertPath(sdkConfigService.getPayCertPath());
        return config;
    }

}