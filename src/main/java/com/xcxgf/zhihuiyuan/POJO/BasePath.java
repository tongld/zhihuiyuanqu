package com.xcxgf.zhihuiyuan.POJO;

public enum BasePath {
    imgBasePath("0","/usr/src/java/file"),
    imgUploadBase("1","zhihuiyuanqu/upload/");

    private String code;
    private String message;

    BasePath(String code,String message){
        this.code=code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
