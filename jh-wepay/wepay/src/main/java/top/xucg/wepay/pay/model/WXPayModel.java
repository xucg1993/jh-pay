package top.xucg.wepay.pay.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author xuchenguang
 * @since 2019.05.23
 */
public class WXPayModel {
    @JSONField(name = "appid")
    private String appId;

    @JSONField(name = "sub_appid")
    private String subAppId;

    @JSONField(name = "mch_id")
    private String mchId;

    @JSONField(name = "sub_mch_id")
    private String subMchId;

    @JSONField(name = "device_info")
    private String deviceInfo;

    @JSONField(name = "nonce_str")
    private String nonceStr;

    @JSONField(name = "sign")
    private String sign;

    @JSONField(name = "sign_type")
    private String signType;

    @JSONField(name = "body")
    private String body;

    @JSONField(name = "detail")
    private String detail;

    @JSONField(name = "attach")
    private String attach;

    @JSONField(name = "transaction_id")
    private String transactionId;

    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    @JSONField(name = "total_fee")
    private String totalFee;

    @JSONField(name = "fee_type")
    private String feeType;

    @JSONField(name = "spbill_create_ip")
    private String spbillCreateIp;

    @JSONField(name = "goods_tag")
    private String goodsTag;

    @JSONField(name = "limit_pay")
    private String limitPay;

    @JSONField(name = "time_start")
    private String timeStart;

    @JSONField(name = "time_expire")
    private String timeExpire;

    @JSONField(name = "receipt")
    private String receipt;

    @JSONField(name = "notify_url")
    private String notifyUrl;

    @JSONField(name = "openid")
    private String openId;

    @JSONField(name = "product_id")
    private String productId;

    @JSONField(name = "code_url")
    private String codeUrl;

    @JSONField(name = "key")
    private String payKey;

    @JSONField(name = "trade_type")
    private String tradeType;


    public String getAppId() {
        return appId;
    }


    public WXPayModel setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public WXPayModel setSubAppId(String subAppId) {
        this.subAppId = subAppId;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public WXPayModel setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public WXPayModel setSubMchId(String subMchId) {
        this.subMchId = subMchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public WXPayModel setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public WXPayModel setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WXPayModel setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSignType() {
        return signType;
    }

    public WXPayModel setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public String getBody() {
        return body;
    }

    public WXPayModel setBody(String body) {
        this.body = body;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public WXPayModel setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public WXPayModel setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public WXPayModel setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public WXPayModel setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public WXPayModel setTotalFee(String totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public String getFeeType() {
        return feeType;
    }

    public WXPayModel setFeeType(String feeType) {
        this.feeType = feeType;
        return this;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public WXPayModel setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
        return this;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public WXPayModel setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
        return this;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public WXPayModel setLimitPay(String limitPay) {
        this.limitPay = limitPay;
        return this;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public WXPayModel setTimeStart(String timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public WXPayModel setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
        return this;
    }

    public String getReceipt() {
        return receipt;
    }

    public WXPayModel setReceipt(String receipt) {
        this.receipt = receipt;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public WXPayModel setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public WXPayModel setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public WXPayModel setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public WXPayModel setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
        return this;
    }

    public String getPayKey() {
        return payKey;
    }

    public WXPayModel setPayKey(String payKey) {
        this.payKey = payKey;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public WXPayModel setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }


}
