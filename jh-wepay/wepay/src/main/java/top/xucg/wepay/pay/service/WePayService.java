package top.xucg.wepay.pay.service;

import org.springframework.stereotype.Component;
import top.xucg.wepay.core.config.WePayConfig;
import top.xucg.wepay.pay.model.MicroPayModel;
import top.xucg.wepay.pay.model.WXPayModel;
import top.xucg.wepay.pay.model.WXRefundModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xuchenguang
 * @since 2019.05.23
 */
@Component
public interface WePayService {


    /**
     * 支付配置
     */
    void setConfig(WePayConfig config);

    /**
     * 付款码支付
     *
     * @param model
     * @return
     * @throws Exception
     */
    String microPay(MicroPayModel model) throws Exception;


    /**
     * 公众号支付
     *
     * @param model
     * @return
     * @throws Exception
     */
    String mpPay(WXPayModel model) throws Exception;


    /**
     * 小程序支付
     *
     * @param model
     * @return
     * @throws Exception
     */
    String miniAppPay(WXPayModel model) throws Exception;


    /**
     * 二维码 支付
     *
     * @param model
     * @return
     * @throws Exception
     */
    String scanCodePay(WXPayModel model) throws Exception;


    /**
     * APP支付
     *
     * @param model
     * @return
     * @throws Exception
     */
    String appPay(WXPayModel model) throws Exception;


    /**
     * H5 支付
     *
     * @param model
     * @return
     * @throws Exception
     */
    String wapPay(WXPayModel model) throws Exception;


    /**
     * 支付回调
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    String callback(HttpServletRequest request, HttpServletResponse response) throws Exception;


    /**
     * 支付结果查询
     *
     * @param model
     * @return
     * @throws Exception
     */
    String orderQuery(WXPayModel model) throws Exception;


    /**
     * 订单关闭
     *
     * @param model
     * @return
     * @throws Exception
     */
    String reverse(WXPayModel model) throws Exception;

    /**
     * 申请退款
     *
     * @param model
     * @return
     * @throws Exception
     */
    String refund(WXRefundModel model) throws Exception;

    /**
     * 退款查询
     *
     * @param model
     * @return
     * @throws Exception
     */
    String refundQuery(WXRefundModel model) throws Exception;


    /**
     * 微信退款回调
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    String refundCallback(HttpServletRequest request, HttpServletResponse response) throws Exception;


}
