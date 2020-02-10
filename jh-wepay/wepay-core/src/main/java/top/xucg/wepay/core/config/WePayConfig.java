package top.xucg.wepay.core.config;


import top.xucg.wepay.core.sdk.IWXPayDomain;
import top.xucg.wepay.core.sdk.WXPayConfig;

import java.io.*;

/**
 * @author xuchenguang
 * @since 2019.05.23
 */
public class WePayConfig extends WXPayConfig implements Serializable {

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

    @Override
    public String getAppID() {
        return appId;
    }

    @Override
    public String getMchID() {
        return mchId;
    }

    @Override
    public String getKey() {
        return payKey;
    }


    @Override
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

    @Override
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
