
package top.xucg.alipay.pay.model;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author xuchenguang
 * @since 2019.05.23
 */

public class ResultJson {

    public static final Integer CODE_ZERO = 0;
    public static final Integer CODE_ONE = 1001;
    public static final Integer CODE_TWO = 1002;
    public static final Integer CODE_THREE = 1003;
    public static final Integer CODE_FOUR = 1004;
    public static final Integer CODE_FIVE = 1005;
    public static final Integer CODE_SIX = 1006;
    public static final Integer CODE_SEVEN = 1007;
    public static final Integer CODE_EIGHT = 1008;
    public static final Integer CODE_NINE = 1009;
    public static final Integer CODE_TEN = 1010;
    public static final Integer CODE_ELEVEN = 1011;
    public static final Integer CODE_TWELVE = 1012;
    public static final Integer CODE_THIRTEEN = 1013;
    public static final Integer CODE_FOURTEEN = 1014;
    public static final Integer CODE_FIFTEEN = 1015;
    public static final Integer CODE_SIXTEEN = 1016;
    public static final Integer CODE_SEVENTEEN = 1017;


    /**
     * 系统异常
     */

    public static final Integer SYSTEM_ERROR = -1;


    /**
     * 参数异常
     */

    public static final Integer ARGS_EXCEPTION = -2;


    /**
     * 登录异常
     */

    public static final String MSG_SUCCESS = "SUCCESS";

    public static final String MSG_FAIL = "FAIL";

    public static final String MSG_ERROR = "ERROR";

    public static final String INFO_EMPTY_STRING = "";
    public static final String INFO_INVALID = null;

    private Integer code;
    private String msg;
    private Object info;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }


    public static String getResultJson(Integer code, String msg, Object info) {
        return buildResult(code, msg, info);
    }


    public static String getResultJsonSuccess() {
        return buildResult(CODE_ZERO, "SUCCESS", "");
    }


    public static String getResultJsonSuccess(Object info) {
        return buildResult(CODE_ZERO, "SUCCESS", info);
    }


    public static String getResultJsonSuccess(Integer code, String msg) {
        return buildResult(code, msg, "");
    }


    public static String getResultJsonSuccess(Integer code, Object info) {
        return buildResult(code, "SUCCESS", info);
    }


    public static String getResultJsonSuccess(Integer code, String msg, Object info) {
        return buildResult(code, msg, info);
    }


    public static String getResultJsonSuccess(String msg, Object info) {
        return buildResult(CODE_ZERO, msg, info);
    }


    public static String getResultJsonSuccess(String msg) {
        return buildResult(CODE_ZERO, msg, "");
    }


    public static String getResultJsonFail() {
        return buildResult(CODE_ONE, "FAIL", "");
    }


    public static String getResultJsonFail(String msg) {
        return buildResult(CODE_ONE, msg, "");
    }


    public static String getResultJsonFail(String msg, Object info) {
        return buildResult(CODE_ONE, msg, info);
    }


    public static String getResultJsonFail(Integer code, String msg) {
        return buildResult(code, msg, "");
    }


    public static String getResultJsonFail(Object info) {
        return buildResult(CODE_ONE, "FAIL", info);
    }


    public static String getResultJsonFail(Integer code, String msg, Object info) {
        return buildResult(code, msg, info);
    }


    public static String getResultJsonError() {
        return buildResult(CODE_ZERO, "ERROR", "");
    }


    public static String getResultJsonError(Integer code) {
        return buildResult(CODE_ZERO, "ERROR", "");
    }


    public static String getResultJsonError(Integer code, String msg) {
        return buildResult(code, msg, "");
    }


    public static String getResultJsonError(Integer code, Object info) {
        return buildResult(code, "ERROR", info);
    }


    public static String getResultJsonError(String msg, Object info) {
        return buildResult(SYSTEM_ERROR, msg, info);
    }


    public static String getResultJsonError(Integer code, String msg, Object info) {
        return buildResult(code, msg, info);
    }


    public static String buildResult(Integer code, String msg, Object info) {
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(code);
        resultJson.setMsg(msg);
        resultJson.setInfo(info);
        return JSONObject.toJSONString(resultJson, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty});
    }
}

