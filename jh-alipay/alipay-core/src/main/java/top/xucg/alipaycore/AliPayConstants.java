package top.xucg.alipaycore;

/**
 * @author xuchenguang
 * @since 2019.07.24
 */
public class AliPayConstants {

    /**
     * 已支付
     */
    public static final String TRADE_SUCCESS = "TRADE_SUCCESS";
    /**
     * 支付成功
     */
    public static final String TRADE_FINISHED = "TRADE_FINISHED";
    /**
     * 等待用户付款
     */
    public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
    /**
     * 交易超时关闭
     */
    public static final String TRADE_CLOSED = "TRADE_CLOSED";
    /**
     * 沙箱支付宝网关
     */
    public static final String GRATEWAY_URL_DEV = "https://openapi.alipaydev.com/gateway.do";
    /**
     * 正式支付宝网关
     */
    public static final String GRATEWAY_URL = "https://openapi.alipay.com/gateway.do";
    /**
     * 返回格式
     */
    public static final String FORMAT = "json";
    /**
     * 编码格式
     */
    public static final String CHARTSET = "UTF-8";
    /**
     * 签名算法类型
     */
    public static final String SING_TYPE = "RSA2";


}
