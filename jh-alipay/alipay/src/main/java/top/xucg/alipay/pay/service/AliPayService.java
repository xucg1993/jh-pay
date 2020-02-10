package top.xucg.alipay.pay.service;

import com.alipay.api.domain.*;
import top.xucg.alipaycore.config.AliPayConfig;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xuchenguang
 * @since 2019.07.24
 */
public interface AliPayService {

    /**
     * 支付配置
     */
    void setConfig(AliPayConfig config);

    /**
     * 交易创建
     * out_trade_no  商户订单号 *
     * total_amount  订单总金额，单位为元，精确到小数点后两位 *
     * subject       订单标题  *
     * body          对交易或商品的描述
     * buyer_id      买家的支付宝唯一用户号 *
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.create/
     *
     * @param payModel
     * @param notifyUrl
     * @return
     */
    String create(AlipayTradePayModel payModel, String notifyUrl);

    /**
     * 线下交易预创建
     * 支付宝二维码收款
     * out_trade_no 商户订单号 *
     * total_amount 订单总金额，单位为元，精确到小数点后两位 *
     * subject 订单标题 *
     * body 对交易或商品的描述
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.precreate/
     *
     * @param payModel
     * @param notifyUrl 回调
     * @return
     */
    String preCreate(AlipayTradePrecreateModel payModel, String notifyUrl);

    /**
     * 统一收单交易支付接口
     * 付款码
     * out_trade_no 商户订单号 *
     * auth_code 支付授权码 *
     * total_amount 订单总金额，单位为元，精确到小数点后两位 *
     * subject 订单标题 *
     * body 对交易或商品的描述
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.precreate/
     *
     * @param payModel
     * @return
     */
    String pay(AlipayTradePayModel payModel);

    /**
     * 代子商户发起
     * 如上
     *
     * @param payModel
     * @param appAuthToken
     * @return
     */
    String pay(AlipayTradePayModel payModel, String appAuthToken);

    /**
     * 手机网站支付接口2.0
     * out_trade_no 商户订单号 *
     * total_amount 订单总金额，单位为元，精确到小数点后两位 *
     * subject 订单标题 *
     * quit_url 用户付款中途退出返回商户网站的地址 *
     * body 对交易或商品的描述
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.wap.pay/
     *
     * @param payModel
     * @param notifyUrl
     * @param returnUrl
     * @return
     */
    String wapPay(AlipayTradeWapPayModel payModel, String notifyUrl, String returnUrl);

    /**
     * 电脑网站支付
     * 支付宝API文档：https://docs.open.alipay.com/270/alipay.trade.page.pay/
     *
     * @param payModel
     * @param notifyUrl
     * @param returnUrl
     * @return
     */
    String pagePay(AlipayTradePagePayModel payModel, String notifyUrl, String returnUrl);

    /**
     * app支付
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.app.pay/
     *
     * @param payModel
     * @param notifyUrl
     * @param returnUrl
     * @return
     */
    String appPay(AlipayTradeAppPayModel payModel, String notifyUrl, String returnUrl);

    /**
     * 统一收单线下交易查询
     * out_trade_no 商户订单号   ~*
     * trade_no     支付宝交易号 ~*
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.query/
     *
     * @return
     */
    String query(AlipayTradeQueryModel queryModel);

    /**
     * 代商户查询
     *
     * @param queryModel
     * @param appAuthToken
     * @return
     */
    String query(AlipayTradeQueryModel queryModel, String appAuthToken);

    /**
     * 统一收单交易退款
     * out_trade_no 商户订单号~*
     * trade_no 支付宝交易号  ~*
     * refund_amount 退款金额  *
     * out_request_no   如需部分退款，则此参数必传
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.refund/
     *
     * @return
     */
    String refund(AlipayTradeRefundModel refundModel);

    /**
     * 代商户退款
     *
     * @param refundModel
     * @param appAuthToken
     * @return
     */
    String refund(AlipayTradeRefundModel refundModel, String appAuthToken);

    /**
     * 统一收单交易退款查询
     * trade_no支付宝交易号  ~*
     * out_trade_no商户订单号 ~*
     * out_request_no退款请求号 *
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.fastpay.refund.query/
     *
     * @param refundQueryModel
     * @return
     */
    String refundQuery(AlipayTradeFastpayRefundQueryModel refundQueryModel);

    /**
     * 统一收单交易退款查询  代商户
     *
     * @param refundQueryModel
     * @param appAuthToken
     * @return
     */
    String refundQuery(AlipayTradeFastpayRefundQueryModel refundQueryModel, String appAuthToken);

    /**
     * 统一收单交易关闭
     * trade_no     支付宝交易号 ~*
     * out_trade_no 商户订单号   ~*
     * operator_id  卖家端自定义的的操作员 ID
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.close/
     *
     * @param closeModel
     * @return
     */
    String close(AlipayTradeCloseModel closeModel);

    /**
     * 代商户关闭订单
     *
     * @param closeModel
     * @param appAuthToken
     * @return
     */
    String close(AlipayTradeCloseModel closeModel, String appAuthToken);


    /**
     * 统一收单交易撤销
     * out_trade_no  商户订单号   ~*
     * trade_no      支付宝交易号 ~*
     * 支付宝API文档：https://docs.open.alipay.com/api_1/alipay.trade.cancel/
     *
     * @param cancelModel
     * @return
     */
    String cancel(AlipayTradeCancelModel cancelModel);

    /**
     * 代商户撤销订单
     *
     * @param cancelModel
     * @param appAuthToken
     * @return
     */
    String cancel(AlipayTradeCancelModel cancelModel, String appAuthToken);

    /**
     * 支付回调
     *
     * @param request
     * @return
     */
    String notify(HttpServletRequest request);

    /**
     * 获取回调返回的数据
     *
     * @param request
     * @return
     */
    Map<String, String> buildParams(HttpServletRequest request);
}
