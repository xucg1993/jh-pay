package top.xucg.wepay.pay.service.impl;

import org.apache.commons.lang3.StringUtils;
import top.xucg.wepay.core.config.WePayConfig;
import top.xucg.wepay.core.sdk.AesUtil;
import top.xucg.wepay.core.sdk.WXPay;
import top.xucg.wepay.core.sdk.WXPayConstants;
import top.xucg.wepay.core.sdk.WXPayUtil;
import top.xucg.wepay.pay.model.MicroPayModel;
import top.xucg.wepay.pay.model.ResultJson;
import top.xucg.wepay.pay.model.WXPayModel;
import top.xucg.wepay.pay.model.WXRefundModel;
import top.xucg.wepay.pay.service.WePayService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author xuchenguang
 * @since 2019.05.31
 */
public class WePayServiceImpl implements WePayService {

    protected WePayConfig payConfig;


    public WePayConfig getPayConfig() {
        return payConfig;
    }

    public void setConfig(WePayConfig config) {
        this.payConfig = config;
    }

    /**
     * 付款码支付
     *
     * @param model
     * @return
     * @throws Exception
     */
    public String microPay(MicroPayModel model) throws Exception {
        WXPayUtil.getLogger().info("付款码支付");

        WXPay wxpay = new WXPay(getPayConfig());


        Map<String, String> payModelMap = WXPayUtil.parseMap(model, Map.class);


        Map<String, String> response = wxpay.microPay(payModelMap);


        WXPayUtil.getLogger().info(response.toString());

        if (wxpay.isResponseSignatureValid(response)) {
            return ResultJson.getResultJsonSuccess(response);
        }

        return ResultJson.getResultJsonFail(response);
    }

    /**
     * 公众号支付
     *
     * @param model
     * @return
     * @throws Exception
     */
    public String mpPay(WXPayModel model) throws Exception {
        WXPayUtil.getLogger().info("JSAPI支付");

        model.setTradeType(WXPayConstants.TRADE_TYPE_JSAPI);

        WXPay wxpay = new WXPay(getPayConfig());

        Map<String, String> payModelMap = WXPayUtil.parseMap(model, Map.class);


        Map<String, String> result = wxpay.unifiedOrder(payModelMap);

        WXPayUtil.buildMiniPayMap(result, getPayConfig().getKey());

        WXPayUtil.getLogger().info(result.toString());

        if (WXPayUtil.isPayResult(result)) {
            return ResultJson.getResultJsonSuccess(result);
        }

        return ResultJson.getResultJsonFail(result);
    }

    public String miniAppPay(WXPayModel model) throws Exception {
        WXPayUtil.getLogger().info("小程序支付");

        model.setTradeType(WXPayConstants.TRADE_TYPE_JSAPI);

        WXPay wxpay = new WXPay(getPayConfig());


        Map<String, String> payModelMap = WXPayUtil.parseMap(model, Map.class);


        Map<String, String> result = wxpay.unifiedOrder(payModelMap);

        WXPayUtil.buildMiniPayMap(result, getPayConfig().getKey());

        WXPayUtil.getLogger().info(result.toString());

        if (WXPayUtil.isPayResult(result)) {
            return ResultJson.getResultJsonSuccess(result);
        }

        return ResultJson.getResultJsonFail(result);
    }

    public String scanCodePay(WXPayModel model) throws Exception {
        WXPayUtil.getLogger().info("二维码 支付");


        model.setTradeType(WXPayConstants.TRADE_TYPE_NATIVE);

        WXPay wxpay = new WXPay(getPayConfig());

        Map<String, String> payModelMap = WXPayUtil.parseMap(model, Map.class);


        Map<String, String> result = wxpay.unifiedOrder(payModelMap);


        WXPayUtil.getLogger().info(result.toString());

        if (WXPayUtil.isPayResult(result)) {
            return ResultJson.getResultJsonSuccess(result);
        }

        return ResultJson.getResultJsonFail(result);
    }

    public String appPay(WXPayModel model) throws Exception {
        WXPayUtil.getLogger().info("APP 支付");


        model.setTradeType(WXPayConstants.TRADE_TYPE_APP);

        WXPay wxpay = new WXPay(getPayConfig());


        Map<String, String> payModelMap = WXPayUtil.parseMap(model, Map.class);


        Map<String, String> result = wxpay.unifiedOrder(payModelMap);


        WXPayUtil.getLogger().info(result.toString());

        if (WXPayUtil.isPayResult(result)) {
            return ResultJson.getResultJsonSuccess(result);
        }

        return ResultJson.getResultJsonFail(result);
    }

    public String wapPay(WXPayModel model) throws Exception {
        WXPayUtil.getLogger().info("H5 支付");


        model.setTradeType(WXPayConstants.TRADE_TYPE_MWEB);

        WXPay wxpay = new WXPay(getPayConfig());


        Map<String, String> payModelMap = WXPayUtil.parseMap(model, Map.class);


        Map<String, String> result = wxpay.unifiedOrder(payModelMap);


        WXPayUtil.getLogger().info(result.toString());

        if (WXPayUtil.isPayResult(result)) {
            return ResultJson.getResultJsonSuccess(result);
        }

        return ResultJson.getResultJsonFail(result);
    }

    public String callback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String xmlData = WXPayUtil.getRequestBody(request);


            if (StringUtils.isBlank(xmlData)) {

                response.getWriter().println(WXPayUtil.resultFail());

                return null;
            }

            WXPay wxpay = new WXPay(getPayConfig());


            Map<String, String> notifyMap = WXPayUtil.xmlToMap(xmlData);


            if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {


                WXPayUtil.getLogger().info("微信支付回调: 成功" + xmlData);
                return ResultJson.getResultJsonSuccess(notifyMap);
            }


            WXPayUtil.getLogger().info("微信支付回调: 失败" + xmlData);
            response.getWriter().println(WXPayUtil.resultFail());

            return ResultJson.getResultJsonFail(notifyMap);
        } catch (IOException e) {
            e.printStackTrace();


            WXPayUtil.getLogger().info("微信支付回调: 系统错误");
            return ResultJson.getResultJsonError();
        }
    }

    public String orderQuery(WXPayModel model) throws Exception {
        WXPay wxpay = new WXPay(getPayConfig());


        Map<String, String> payModelMap = WXPayUtil.parseMap(model, Map.class);


        try {
            Map<String, String> result = wxpay.orderQuery(payModelMap);

            if (WXPayUtil.isPayResult(result)) {


                String tradeState = result.get(WXPayConstants.TRADE_STATE);

                if (WXPayConstants.SUCCESS.equals(tradeState)) {


                    WXPayUtil.getLogger().info("微信支付查询结果:支付成功" + result);
                    return ResultJson.getResultJsonSuccess(result);
                }

                if (WXPayConstants.REFUND.equals(tradeState)) {

                    WXPayUtil.getLogger().info("微信支付查询结果: 转入退款" + result);
                    return ResultJson.getResultJsonSuccess(ResultJson.CODE_TWO, WXPayConstants.REFUND, result);
                }

                if (WXPayConstants.NOTPAY.equals(tradeState)) {

                    WXPayUtil.getLogger().info("微信支付查询结果: 未支付" + result);
                    return ResultJson.getResultJsonSuccess(ResultJson.CODE_THREE, WXPayConstants.NOTPAY, result);
                }

                if (WXPayConstants.CLOSED.equals(tradeState)) {

                    WXPayUtil.getLogger().info("微信支付查询结果: 已关闭" + result);
                    return ResultJson.getResultJsonSuccess(ResultJson.CODE_FOUR, WXPayConstants.CLOSED, result);
                }

                if (WXPayConstants.REVOKED.equals(tradeState)) {

                    WXPayUtil.getLogger().info("微信支付查询结果: 已取消" + result);
                    return ResultJson.getResultJsonSuccess(ResultJson.CODE_FIVE, WXPayConstants.REVOKED, result);
                }

                if (WXPayConstants.USERPAYING.equals(tradeState)) {

                    WXPayUtil.getLogger().info("微信支付查询结果: 已撤销" + result);
                    return ResultJson.getResultJsonSuccess(ResultJson.CODE_SIX, WXPayConstants.USERPAYING, result);
                }

                if (WXPayConstants.PAYERROR.equals(tradeState)) {
                    WXPayUtil.getLogger().info("微信支付查询结果: 支付错误" + result);
                    return ResultJson.getResultJsonSuccess(ResultJson.CODE_SEVEN, WXPayConstants.PAYERROR, result);
                }
            }
            return ResultJson.getResultJsonFail();
        } catch (Exception e) {
            e.printStackTrace();


            WXPayUtil.getLogger().info("微信支付查询: 系统错误");
            return ResultJson.getResultJsonError();
        }
    }

    public String reverse(WXPayModel model) throws Exception {
        try {

            WXPay wxpay = new WXPay(getPayConfig());


            Map<String, String> payModelMap = WXPayUtil.parseMap(model, Map.class);

            Map<String, String> result = wxpay.reverse(payModelMap);

            String errCode = result.get(WXPayConstants.ERR_CODE);

            if (WXPayUtil.isPayResult(result)) {


                WXPayUtil.getLogger().info("微信支付关闭订单结果: 关闭成功" + result);
                return ResultJson.getResultJsonSuccess(result);
            }
            if (WXPayConstants.ORDERPAID.equals(errCode)) {


                WXPayUtil.getLogger().info("微信支付关闭订单结果: 已支付" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_TWO, WXPayConstants.ORDERPAID, result);
            }
            if (WXPayConstants.SYSTEMERROR.equals(errCode)) {


                WXPayUtil.getLogger().info("微信支付关闭订单结果: 系统错误" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_THREE, WXPayConstants.SYSTEMERROR, result);
            }
            if (WXPayConstants.ORDERCLOSED.equals(errCode)) {


                WXPayUtil.getLogger().info("微信支付关闭订单结果: 已关闭" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_FOUR, WXPayConstants.ORDERCLOSED, result);
            }
            if (WXPayConstants.SIGNERROR.equals(errCode)) {


                WXPayUtil.getLogger().info("微信支付关闭订单结果: 签名错误" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_FIVE, WXPayConstants.SIGNERROR, result);
            }
            if (WXPayConstants.REQUIRE_POST_METHOD.equals(errCode)) {


                WXPayUtil.getLogger().info("微信支付关闭订单结果: 请使用post方法" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_SIX, WXPayConstants.REQUIRE_POST_METHOD, result);
            }
            if (WXPayConstants.XML_FORMAT_ERROR.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付关闭订单结果: XML格式错误" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_SEVEN, WXPayConstants.XML_FORMAT_ERROR, result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        WXPayUtil.getLogger().info("微信支付关闭订单结果: 系统错误");
        return ResultJson.getResultJsonError();
    }

    public String refund(WXRefundModel model) throws Exception {
        WXPay wxpay = new WXPay(getPayConfig());


        Map<String, String> refundModelMap = WXPayUtil.parseMap(model, Map.class);

        Map<String, String> result = wxpay.refund(refundModelMap);

        String errCode = result.get(WXPayConstants.ERR_CODE);


        if (WXPayUtil.isPayResult(result)) {
            WXPayUtil.getLogger().info("微信支付申请退款结果: 已申请" + result);
            return ResultJson.getResultJsonSuccess(result);
        }
        if (WXPayConstants.SYSTEMERROR.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 系统超时等" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_TWO, WXPayConstants.SYSTEMERROR, result);
        }
        if (WXPayConstants.BIZERR_NEED_RETRY.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 退款业务流程错误" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_THREE, WXPayConstants.BIZERR_NEED_RETRY, result);
        }
        if (WXPayConstants.TRADE_OVERDUE.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 订单已经超过退款期限" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_FOUR, WXPayConstants.TRADE_OVERDUE, result);
        }
        if (WXPayConstants.ERROR.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 业务错误" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_FIVE, WXPayConstants.ERROR, result);
        }
        if (WXPayConstants.USER_ACCOUNT_ABNORMAL.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 退款请求失败" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_SIX, WXPayConstants.USER_ACCOUNT_ABNORMAL, result);
        }
        if (WXPayConstants.INVALID_REQ_TOO_MUCH.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 无效请求过多" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_SEVEN, WXPayConstants.INVALID_REQ_TOO_MUCH, result);
        }
        if (WXPayConstants.NOTENOUGH.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 余额不足" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_EIGHT, WXPayConstants.NOTENOUGH, result);
        }
        if (WXPayConstants.INVALID_TRANSACTIONID.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 无效transaction_id" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_NINE, WXPayConstants.INVALID_TRANSACTIONID, result);
        }
        if (WXPayConstants.PARAM_ERROR.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 参数错误" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_TEN, WXPayConstants.PARAM_ERROR, result);
        }
        if (WXPayConstants.APPID_NOT_EXIST.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: APPID不存在" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_ELEVEN, WXPayConstants.APPID_NOT_EXIST, result);
        }
        if (WXPayConstants.MCHID_NOT_EXIST.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: MCHID不存在" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_TWELVE, WXPayConstants.MCHID_NOT_EXIST, result);
        }
        if (WXPayConstants.ORDERNOTEXIST.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 订单号不存在" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_THIRTEEN, WXPayConstants.ORDERNOTEXIST, result);
        }
        if (WXPayConstants.REQUIRE_POST_METHOD.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 请使用post方法" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_FOURTEEN, WXPayConstants.REQUIRE_POST_METHOD, result);
        }
        if (WXPayConstants.SIGNERROR.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: 签名错误" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_FIFTEEN, WXPayConstants.SIGNERROR, result);
        }
        if (WXPayConstants.XML_FORMAT_ERROR.equals(errCode)) {


            WXPayUtil.getLogger().info("微信支付申请退款结果: XML格式错误" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_SIXTEEN, WXPayConstants.XML_FORMAT_ERROR, result);
        }
        if (WXPayConstants.FREQUENCY_LIMITED.equals(errCode)) {

            WXPayUtil.getLogger().info("微信支付申请退款结果: 频率限制" + result);
            return ResultJson.getResultJsonSuccess(ResultJson.CODE_SEVENTEEN, WXPayConstants.FREQUENCY_LIMITED, result);
        }

        return ResultJson.getResultJsonFail(result);
    }

    public String refundQuery(WXRefundModel model) throws Exception {
        try {
            WXPay wxpay = new WXPay(getPayConfig());


            Map<String, String> refundModelMap = WXPayUtil.parseMap(model, Map.class);

            Map<String, String> result = wxpay.refundQuery(refundModelMap);

            String errCode = result.get(WXPayConstants.ERR_CODE);


            if (WXPayUtil.isPayResult(result)) {
                WXPayUtil.getLogger().info("微信支付退款查询: 成功" + result);
                return ResultJson.getResultJsonSuccess(result);
            }
            if (WXPayConstants.SYSTEMERROR.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付退款查询: 系统超时" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_TWO, WXPayConstants.SYSTEMERROR, result);
            }
            if (WXPayConstants.REFUNDNOTEXIST.equals(errCode)) {


                WXPayUtil.getLogger().info("微信支付退款查询: 查询失败" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_THREE, WXPayConstants.REFUNDNOTEXIST, result);
            }
            if (WXPayConstants.INVALID_TRANSACTIONID.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付退款查询: 无效transaction_id" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_FOUR, WXPayConstants.INVALID_TRANSACTIONID, result);
            }
            if (WXPayConstants.PARAM_ERROR.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付退款查询: 参数错误" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_FIVE, WXPayConstants.PARAM_ERROR, result);
            }
            if (WXPayConstants.APPID_NOT_EXIST.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付退款查询: APPID不存在" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_SIX, WXPayConstants.APPID_NOT_EXIST, result);
            }
            if (WXPayConstants.MCHID_NOT_EXIST.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付退款查询: MCHID不存在" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_SEVEN, WXPayConstants.MCHID_NOT_EXIST, result);
            }
            if (WXPayConstants.REQUIRE_POST_METHOD.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付退款查询: 请使用post方法" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_EIGHT, WXPayConstants.REQUIRE_POST_METHOD, result);
            }
            if (WXPayConstants.SIGNERROR.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付退款查询: 签名错误" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_NINE, WXPayConstants.SIGNERROR, result);
            }
            if (WXPayConstants.XML_FORMAT_ERROR.equals(errCode)) {

                WXPayUtil.getLogger().info("微信支付退款查询: XML格式错误" + result);
                return ResultJson.getResultJsonSuccess(ResultJson.CODE_TEN, WXPayConstants.XML_FORMAT_ERROR, result);
            }

            return ResultJson.getResultJsonFail(result);
        } catch (Exception e) {
            e.printStackTrace();

            WXPayUtil.getLogger().info("微信支付退款查询: 系统错误");
            return ResultJson.getResultJsonError();
        }
    }

    public String refundCallback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String xmlData = WXPayUtil.getRequestBody(request);

        try {
            WXPay wxpay = new WXPay(getPayConfig());

            Map<String, String> notifyMap = WXPayUtil.xmlToMap(xmlData);

            if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {


                String reqInfo = notifyMap.get("req_info");


                String key = WXPayUtil.MD5(getPayConfig().getKey()).toLowerCase();


                String decrypt = AesUtil.decrypt(reqInfo, key);


                Map<String, String> xmlValue = WXPayUtil.xmlToMap(decrypt);


                String refundCode = xmlValue.get(WXPayConstants.REFUND_CODE);


                if (WXPayConstants.SUCCESS.equals(refundCode)) {

                    WXPayUtil.getLogger().info("微信申请退款结果: 退款成功" + xmlValue);
                    response.getWriter().println(WXPayUtil.resultSuccess());
                    return ResultJson.getResultJsonSuccess(xmlValue);
                }
                if (WXPayConstants.CHANGE.equals(refundCode)) {


                    response.getWriter().println(WXPayUtil.resultFail());

                    WXPayUtil.getLogger().info("微信申请退款结果: 退款异常" + xmlValue);

                    return ResultJson.getResultJson(ResultJson.CODE_TWO, WXPayConstants.CHANGE, xmlValue);
                }
                if (WXPayConstants.REFUNDCLOSE.equals(refundCode)) {

                    response.getWriter().println(WXPayUtil.resultFail());

                    WXPayUtil.getLogger().info("微信申请退款结果: 退款关闭" + xmlValue);

                    return ResultJson.getResultJson(ResultJson.CODE_THREE, WXPayConstants.REFUNDCLOSE, xmlValue);
                }

            } else {

                response.getWriter().println(WXPayUtil.resultFail());
                WXPayUtil.getLogger().info("微信申请退款结果: 接收微信服务器通知失败");
                return ResultJson.getResultJson(ResultJson.CODE_FOUR, "", "");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        response.getWriter().println(WXPayUtil.resultFail());
        WXPayUtil.getLogger().info("微信申请退款结果: 系统错误");
        return ResultJson.getResultJsonError();
    }
}
