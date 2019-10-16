package top.xucg.alipay.pay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import top.xucg.alipay.pay.model.ResultJson;
import top.xucg.alipay.pay.service.AliPayService;
import top.xucg.alipaycore.AliPayConstants;
import top.xucg.alipaycore.config.AliPayConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author xuchenguang
 * @since 2019.07.24
 */
public class AliPayServiceImpl implements AliPayService {
    private static final Log log = LogFactory.getLog("ALiPay SDK");
    private static final String FAST_INSTANT_TRADE_PAY = "FAST_INSTANT_TRADE_PAY";
    private static final String QUICK_WAP_WAY = "QUICK_WAP_WAY";

    protected AliPayConfig aliPayConfig;

    public AliPayConfig getConfig() {
        return aliPayConfig;
    }

    public void setConfig(AliPayConfig aliPayConfig) {
        this.aliPayConfig = aliPayConfig;
    }

    public String create(AlipayTradePayModel payModel, String notifyUrl) {
        try {
            AlipayClient client = aliPayConfig.getAliPayClient();

            AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();

            //回调地址
            request.setNotifyUrl(notifyUrl);

            //将实体放入Request请求
            request.setBizModel(payModel);

            //返回信息
            AlipayTradeCreateResponse response = client.execute(request);

            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }


    public String pay(AlipayTradePayModel payModel) {
        return this.pay(payModel, null);
    }

    public String pay(AlipayTradePayModel payModel, String appAuthToken) {

        AlipayClient alipayClient = aliPayConfig.getAliPayClient();
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        //将实体放入Request请求
        request.setBizModel(payModel);
        if (StringUtils.isNotBlank(appAuthToken)) {
            request.putOtherTextParam("app_auth_token", appAuthToken);
        }
        //返回信息
        try {
            AlipayTradePayResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return ResultJson.getResultJsonError();
    }

    public String preCreate(AlipayTradePrecreateModel payModel, String notifyUrl) {
        try {

            AlipayClient alipayClient = aliPayConfig.getAliPayClient();

            AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

            //回调地址
            request.setNotifyUrl(notifyUrl);

            //将实体放入Request请求
            request.setBizModel(payModel);

            //返回信息
            AlipayTradePrecreateResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }

    public String wapPay(AlipayTradeWapPayModel payModel, String notifyUrl, String returnUrl) {
        try {

            AlipayClient client = aliPayConfig.getAliPayClient();

            AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();

            //回调地址
            request.setNotifyUrl(notifyUrl);

            //支付后返回的页面
            request.setReturnUrl(returnUrl);

            //产品销售码
            payModel.setProductCode(QUICK_WAP_WAY);
            //将实体放入Request请求
            request.setBizModel(payModel);

            AlipayTradeWapPayResponse response = client.pageExecute(request);

            if (response.isSuccess()) {

                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultJson.getResultJsonError();
    }

    public String pagePay(AlipayTradePagePayModel payModel, String notifyUrl, String returnUrl) {
        try {
            AlipayClient alipayClient = aliPayConfig.getAliPayClient();
            //创建API对应的request
            AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

            //在公共参数中设置回跳和通知地址
            request.setReturnUrl(returnUrl);
            request.setNotifyUrl(notifyUrl);

            //产品销售码
            payModel.setProductCode(FAST_INSTANT_TRADE_PAY);

            //设置请求参数
            request.setBizModel(payModel);

            AlipayTradePagePayResponse response = alipayClient.pageExecute(request);

            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }

    public String appPay(AlipayTradeAppPayModel payModel, String notifyUrl, String returnUrl) {
        try {
            AlipayClient alipayClient = aliPayConfig.getAliPayClient();
            //创建API对应的request
            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();

            //在公共参数中设置回跳和通知地址
            request.setReturnUrl(returnUrl);
            request.setNotifyUrl(notifyUrl);
            //设置请求参数
            request.setBizModel(payModel);
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);

            log.info(response.getBody());

            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }

    public String query(AlipayTradeQueryModel queryModel) {
        return this.query(queryModel, null);
    }

    public String query(AlipayTradeQueryModel queryModel, String appAuthToken) {
        try {
            AlipayClient alipayClient = aliPayConfig.getAliPayClient();
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
            if (StringUtils.isNotBlank(appAuthToken)) {
                request.putOtherTextParam("app_auth_token", appAuthToken);
            }
            request.setBizModel(queryModel);

            AlipayTradeQueryResponse response = alipayClient.execute(request);

            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }

    public String refund(AlipayTradeRefundModel refundModel) {
        return this.refund(refundModel, null);
    }

    public String refund(AlipayTradeRefundModel refundModel, String appAuthToken) {
        try {
            AlipayClient alipayClient = aliPayConfig.getAliPayClient();

            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            if (StringUtils.isNotBlank(appAuthToken)) {
                request.putOtherTextParam("app_auth_token", appAuthToken);
            }
            request.setBizModel(refundModel);

            AlipayTradeRefundResponse response = alipayClient.execute(request);

            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }

    public String refundQuery(AlipayTradeFastpayRefundQueryModel refundQueryModel) {
        return this.refundQuery(refundQueryModel, null);
    }

    public String refundQuery(AlipayTradeFastpayRefundQueryModel refundQueryModel, String appAuthToken) {
        try {
            AlipayClient alipayClient = aliPayConfig.getAliPayClient();

            AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
            if (StringUtils.isNotBlank(appAuthToken)) {
                request.putOtherTextParam("app_auth_token", appAuthToken);
            }
            request.setBizModel(refundQueryModel);

            AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);

            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }

    public String close(AlipayTradeCloseModel closeModel) {
        return this.close(closeModel, null);
    }

    public String close(AlipayTradeCloseModel closeModel, String appAuthToken) {
        try {
            AlipayClient alipayClient = aliPayConfig.getAliPayClient();

            AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
            if (StringUtils.isNotBlank(appAuthToken)) {
                request.putOtherTextParam("app_auth_token", appAuthToken);
            }
            request.setBizModel(closeModel);

            AlipayTradeCloseResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }

    public String cancel(AlipayTradeCancelModel cancelModel) {
        return this.cancel(cancelModel, null);
    }

    public String cancel(AlipayTradeCancelModel cancelModel, String appAuthToken) {
        try {
            AlipayClient alipayClient = aliPayConfig.getAliPayClient();

            AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
            if (StringUtils.isNotBlank(appAuthToken)) {
                request.putOtherTextParam("app_auth_token", appAuthToken);
            }
            request.setBizModel(cancelModel);

            AlipayTradeCancelResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                return ResultJson.getResultJsonSuccess(response.getMsg(), response.getBody());
            }
            return ResultJson.getResultJsonFail(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return ResultJson.getResultJsonError();
    }

    public String notify(HttpServletRequest request) {
        HttpServletResponse response = null;
        PrintWriter out = null;
        try {
            out = response.getWriter();
            boolean signVerified = AlipaySignature.rsaCheckV1(buildParams(request), aliPayConfig.getPublicKey(),
                    aliPayConfig.getChartset(), aliPayConfig.getSingType());
            if (signVerified) {
                String appId = new String(request.getParameter("app_id").getBytes("ISO-8859-1"), "UTF-8");
                //商户订单号
                String outTradeNo = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
                //支付宝交易号
                String tradeNo = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
                //交易状态
                String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

                //已支付或支付成功
                if (AliPayConstants.TRADE_SUCCESS.equals(tradeStatus) || AliPayConstants.TRADE_FINISHED.equals(tradeStatus)) {
                    Map<String, String> map = new HashMap<String, String>(16);
                    map.put("appId", appId);
                    map.put("outTradeNo", outTradeNo);
                    map.put("tradeNo", tradeNo);
                    map.put("tradeStatus", tradeStatus);
                    return ResultJson.getResultJsonSuccess(map);
                }
                out.println("fail");
                return ResultJson.getResultJsonFail();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("fail");
        return ResultJson.getResultJsonError();
    }

    public Map<String, String> buildParams(HttpServletRequest request) {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = null;
        try {
            params = new HashMap<String, String>(16);
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
                params.put(name, valueStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }
}
