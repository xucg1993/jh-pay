package top.xucg.wepay.core.sdk;

import org.apache.http.client.HttpClient;

/**
 * 常量
 */
public class WXPayConstants {

    public enum SignType {
        MD5, HMACSHA256
    }

    public static final String DOMAIN_API = "api.mch.weixin.qq.com";
    public static final String DOMAIN_API2 = "api2.mch.weixin.qq.com";
    public static final String DOMAIN_APIHK = "apihk.mch.weixin.qq.com";
    public static final String DOMAIN_APIUS = "apius.mch.weixin.qq.com";


    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";
    public static final String HMACSHA256 = "HMAC-SHA256";
    public static final String MD5 = "MD5";

    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "sign_type";

    public static final String WXPAYSDK_VERSION = "WXPaySDK/3.0.9";
    public static final String USER_AGENT = WXPAYSDK_VERSION +
            " (" + System.getProperty("os.arch") + " " + System.getProperty("os.name") + " " + System.getProperty("os.version") +
            ") Java/" + System.getProperty("java.version") + " HttpClient/" + HttpClient.class.getPackage().getImplementationVersion();

    public static final String MICROPAY_URL_SUFFIX = "/payconfig/micropay";
    public static final String UNIFIEDORDER_URL_SUFFIX = "/payconfig/unifiedorder";
    public static final String ORDERQUERY_URL_SUFFIX = "/payconfig/orderquery";
    public static final String REVERSE_URL_SUFFIX = "/secapi/payconfig/reverse";
    public static final String CLOSEORDER_URL_SUFFIX = "/payconfig/closeorder";
    public static final String REFUND_URL_SUFFIX = "/secapi/payconfig/refund";
    public static final String REFUNDQUERY_URL_SUFFIX = "/payconfig/refundquery";
    public static final String DOWNLOADBILL_URL_SUFFIX = "/payconfig/downloadbill";
    public static final String REPORT_URL_SUFFIX = "/payitil/report";
    public static final String SHORTURL_URL_SUFFIX = "/tools/shorturl";
    public static final String AUTHCODETOOPENID_URL_SUFFIX = "/tools/authcodetoopenid";

    // sandbox
    public static final String SANDBOX_MICROPAY_URL_SUFFIX = "/sandboxnew/payconfig/micropay";
    public static final String SANDBOX_UNIFIEDORDER_URL_SUFFIX = "/sandboxnew/payconfig/unifiedorder";
    public static final String SANDBOX_ORDERQUERY_URL_SUFFIX = "/sandboxnew/payconfig/orderquery";
    public static final String SANDBOX_REVERSE_URL_SUFFIX = "/sandboxnew/secapi/payconfig/reverse";
    public static final String SANDBOX_CLOSEORDER_URL_SUFFIX = "/sandboxnew/payconfig/closeorder";
    public static final String SANDBOX_REFUND_URL_SUFFIX = "/sandboxnew/secapi/payconfig/refund";
    public static final String SANDBOX_REFUNDQUERY_URL_SUFFIX = "/sandboxnew/payconfig/refundquery";
    public static final String SANDBOX_DOWNLOADBILL_URL_SUFFIX = "/sandboxnew/payconfig/downloadbill";
    public static final String SANDBOX_REPORT_URL_SUFFIX = "/sandboxnew/payitil/report";
    public static final String SANDBOX_SHORTURL_URL_SUFFIX = "/sandboxnew/tools/shorturl";
    public static final String SANDBOX_AUTHCODETOOPENID_URL_SUFFIX = "/sandboxnew/tools/authcodetoopenid";


    //自定义
    public static final String TRADE_TYPE_NATIVE = "NATIVE";
    public static final String TRADE_TYPE_JSAPI = "JSAPI";
    public static final String TRADE_TYPE_MWEB = "MWEB";
    public static final String TRADE_TYPE_APP = "APP";
    public static final String RETURN_CODE = "return_code";
    public static final String RESULT_CODE = "result_code";
    public static final String REFUND_CODE = "refund_status";
    public static final String ERR_CODE = "err_code";
    public static final String ERR_CODE_DES = "err_code_des";
    public static final String TRADE_STATE = "trade_state";
    public static final String REFUNDCLOSE = "REFUNDCLOSE";
    public static final String CHANGE = "CHANGE";
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";
    public static final String REFUND = "REFUND";
    public static final String NOTPAY = "NOTPAY";
    public static final String CLOSED = "CLOSED";
    public static final String REVOKED = "REVOKED";
    public static final String USERPAYING = "USERPAYING";
    public static final String PAYERROR = "PAYERROR";
    public static final String ORDERPAID = "ORDERPAID";
    public static final String SYSTEMERROR = "SYSTEMERROR";
    public static final String ORDERCLOSED = "ORDERCLOSED";
    public static final String SIGNERROR = "SIGNERROR";
    public static final String REQUIRE_POST_METHOD = "REQUIRE_POST_METHOD";
    public static final String XML_FORMAT_ERROR = "XML_FORMAT_ERROR";
    public static final String REFUNDNOTEXIST = "REFUNDNOTEXIST";
    public static final String INVALID_TRANSACTIONID = "INVALID_TRANSACTIONID";
    public static final String PARAM_ERROR = "PARAM_ERROR";
    public static final String APPID_NOT_EXIST = "APPID_NOT_EXIST";
    public static final String MCHID_NOT_EXIST = "MCHID_NOT_EXIST";
    public static final String BIZERR_NEED_RETRY = "BIZERR_NEED_RETRY";
    public static final String TRADE_OVERDUE = "TRADE_OVERDUE";
    public static final String USER_ACCOUNT_ABNORMAL = "USER_ACCOUNT_ABNORMAL";
    public static final String INVALID_REQ_TOO_MUCH = "INVALID_REQ_TOO_MUCH";
    public static final String NOTENOUGH = "NOTENOUGH";
    public static final String ORDERNOTEXIST = "ORDERNOTEXIST";
    public static final String FREQUENCY_LIMITED = "FREQUENCY_LIMITED";
}

