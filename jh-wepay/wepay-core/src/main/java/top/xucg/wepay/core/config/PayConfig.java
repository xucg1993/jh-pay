package top.xucg.wepay.core.config;



import top.xucg.wepay.core.sdk.IWXPayDomain;
import top.xucg.wepay.core.sdk.WXPayConfig;

import java.io.*;

/**
 * @author xuchenguang
 * @since 2019.05.23
 */
public class PayConfig extends WXPayConfig implements Serializable {

    private String appId;
    private String mchId;
    private String payKey;
    private String certPath;

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getAppID() {
        return appId;
    }


    public String getMchID() {
        return mchId;
    }


    public String getKey() {
        return payKey;
    }


    public InputStream getCertStream() {
        ByteArrayInputStream certBis = null;
        try {
            String certPath = this.certPath;
            File file = new File(certPath);
            InputStream certStream = new FileInputStream(file);
            byte[] certData = new byte[(int) file.length()];
            certStream.read(certData);
            certStream.close();
            certBis = new ByteArrayInputStream(certData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return certBis;
    }


    public IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }


            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo("api.mch.weixin.qq.com", true);
            }
        };
    }
}
