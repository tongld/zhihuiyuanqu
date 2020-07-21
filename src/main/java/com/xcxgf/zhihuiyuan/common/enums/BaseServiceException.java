package com.xcxgf.zhihuiyuan.common.enums;

/*
异常类型
 */
public class BaseServiceException extends RuntimeException  {
    private int code;

    public BaseServiceException(String message, ServiceErrCode serviceErrCode) {//构造器的第二个参数是上面创建的那个枚举，之后把枚举里面定义的code给了这个code
        super(message);
        this.code = serviceErrCode.getCode();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
