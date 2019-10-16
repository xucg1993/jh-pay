package top.xucg.alipaycore.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * @author xuchenguang
 * @since 2019.07.24
 */
public class AliPayConfig {

    /**
     * 支付宝网关
     */
    private String gratewayUrl;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 商户私钥
     */
    private String privateKey;
    /**
     * 支付宝公钥
     */
    private String publicKey;
    /**
     * 返回格式
     */
    private String format = "json";

    /**
     * 编码格式
     */
    private String chartset = "UTF-8";

    /**
     * 签名算法类型
     */
    private String singType = "RSA2";

    public String getGratewayUrl() {
        return gratewayUrl;
    }

    public void setGratewayUrl(String gratewayUrl) {
        this.gratewayUrl = gratewayUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getChartset() {
        return chartset;
    }

    public void setChartset(String chartset) {
        this.chartset = chartset;
    }

    public String getSingType() {
        return singType;
    }

    public void setSingType(String singType) {
        this.singType = singType;
    }

    public AlipayClient getAliPayClient() {
        return new DefaultAlipayClient(gratewayUrl, appId, privateKey,
                format, chartset,
                publicKey, singType);
    }
}
