package top.xucg.wepay.pay.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author xuchenguang
 * @since 2019.05.23
 */
public class MicroPayModel extends WXPayModel {


    @JSONField(name = "auth_code")
    private String authCode;


    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }


}
