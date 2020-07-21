package com.xcxgf.zhihuiyuan.common.enums;

/**
 * 园区所有异常类型
 */
public enum ServiceErrCode {
    REQ_PARAM_ERR(10001,"请求参数异常"),
    NOTFOUND_RESULT_ERR(10004,"未找到结果");


    private int code;

    ServiceErrCode(int code,String msg){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
