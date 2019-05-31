package top.xucg.wepay.pay.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author xuchenguang
 * @since 2019.05.23
 */
public class ResultJson {

    public static final Integer CODE_0 = 1000;
    public static final Integer CODE_1 = 1001;
    public static final Integer CODE_2 = 1002;
    public static final Integer CODE_3 = 1003;
    public static final Integer CODE_4 = 1004;
    public static final Integer CODE_5 = 1005;
    public static final Integer CODE_6 = 1006;
    public static final Integer CODE_7 = 1007;
    public static final Integer CODE_8 = 1008;
    public static final Integer CODE_9 = 1009;
    public static final Integer CODE_10 = 1010;
    public static final Integer CODE_11 = 1011;
    public static final Integer CODE_12 = 1012;
    public static final Integer CODE_13 = 1013;
    public static final Integer CODE_14 = 1014;
    public static final Integer CODE_15 = 1015;
    public static final Integer CODE_16 = 1016;
    public static final Integer CODE_17 = 1017;

    public static final Integer CURRENCY_EXCEPTION = 0;


    public static final Integer CHECK_LOGIN_EXCEPTION = -1;


    public static final Integer ARGS_EXCEPTION = -2;

    public static final String MSG_SUCCESS = "SUCCESS";

    public static final String MSG_FAIL = "FAIL";

    public static final String MSG_ERROR = "ERROR";

    public static final String INFO_EMPTY_STRING = "";
    public static final String INFO_INVALID = null;

    private Integer code;
    private String message;
    private Object info;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }


    public static String getResultJson(Integer code, String message, Object info) {
        return buildResult(code, message, info);
    }


    public static String getResultJsonSuccess() {
        return buildResult(CODE_1, "SUCCESS", "");
    }


    public static String getResultJsonSuccess(Object info) {
        return buildResult(CODE_1, "SUCCESS", info);
    }


    public static String getResultJsonSuccess(Integer code, String message) {
        return buildResult(code, message, "");
    }


    public static String getResultJsonSuccess(Integer code, Object info) {
        return buildResult(code, "SUCCESS", info);
    }


    public static String getResultJsonSuccess(Integer code, String message, Object info) {
        return buildResult(code, message, info);
    }


    public static String getResultJsonSuccess(String message, Object info) {
        return buildResult(CODE_1, message, info);
    }


    public static String getResultJsonSuccess(String message) {
        return buildResult(CODE_1, message, "");
    }


    public static String getResultJsonFail() {
        return buildResult(CODE_2, "FAIL", "");
    }


    public static String getResultJsonFail(String message) {
        return buildResult(CODE_2, message, "");
    }


    public static String getResultJsonFail(String message, Object info) {
        return buildResult(CODE_2, message, info);
    }


    public static String getResultJsonFail(Integer code, String message) {
        return buildResult(code, message, "");
    }


    public static String getResultJsonFail(Object info) {
        return buildResult(CODE_2, "FAIL", info);
    }


    public static String getResultJsonFail(Integer code, String message, Object info) {
        return buildResult(code, message, info);
    }


    public static String getResultJsonError() {
        return buildResult(CODE_0, "ERROR", "");
    }


    public static String getResultJsonError(Integer code) {
        return buildResult(CODE_0, "ERROR", "");
    }


    public static String getResultJsonError(Integer code, String message) {
        return buildResult(code, message, "");
    }


    public static String getResultJsonError(Integer code, Object info) {
        return buildResult(code, "ERROR", info);
    }


    public static String getResultJsonError(String message, Object info) {
        return buildResult(CODE_0, message, info);
    }


    public static String getResultJsonError(Integer code, String message, Object info) {
        return buildResult(code, message, info);
    }


    public static String buildResult(Integer code, String message, Object info) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(code);
        resultJson.setMessage(message);
        resultJson.setInfo(info);
        return JSONObject.toJSONString(resultJson, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty});
    }
}
