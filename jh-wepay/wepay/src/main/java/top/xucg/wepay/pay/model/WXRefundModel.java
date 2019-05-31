package top.xucg.wepay.pay.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author xuchenguang
 * @since 2019.05.23
 */
public class WXRefundModel extends WXPayModel {


    @JSONField(name = "out_refund_no")
    private String outRefundNo;
    @JSONField(name = "refund_fee")
    private String refundFee;
    @JSONField(name = "refund_fee_type")
    private String refundFeeType;
    @JSONField(name = "refund_desc")
    private String refundDesc;
    @JSONField(name = "refund_account")
    private String refundAccount;
    @JSONField(name = "refund_id")
    private String refundId;


    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }
}
