package com.taoz.boost.sup.result;

/**
 * @author taozheng
 * @date 2023/3/13 - 22:25
 * @introduce:
 */
public enum ResultStatus {
    SUCCESS(200, "成功"),
    FAIL(-200, "失败"),
    FAIL_UNKNOWN_REASON(-201, "系统忙,请稍后再试"),
    CLIENT_ABORT_EXCEPTION_HANDLER(2000, "请稍后再试"),
    DATA_NOT_POWER(-4004, "无权操作"),
    SYSTEM_ACCESS_FAIL(2000, "未知系统访问"),
    AUTH_UNAUTHORIZED(403, "请重新登录"),
    DATA_CHECK_FAIL(-1006, "数据验证失败"),
    FILE_TYPE_CHECK_FAIL(-1008, "文件格式不支持"),
    GLOBAL_EXCEPTION(-1000, "系统忙,请稍后再试"),
    PARTIAL_SUCCESS(206, "部分成功"),
    USERNAME_OR_PASSWORD_ERROR(-1001, "用户名或密码错误"),
    USER_PASS_EDIT_FAIL(-300, "旧密码不正确"),
    USER_ALREADY_EXIST(-1005, "用户已存在"),
    USER_NOT_EXIST(-1006, "用户判断为空"),
    DATA_NOT_NULL(-1004, "字段不能为空"),
    PWD_LIMIT_FAIL(-2001, "密码重试次数"),
    SESSION_TIMEOUT(403, "会话超时,请重新登录"),
    REQUEST_PARAM_ERROR(412, "请求参数错误"),
    NOT_ACCEPTABLE(406, "服务器无法根据客户端请求内容特性完成请求"),
    FILE_PATH_NULL(-200, "获取图片/源文件/pdf路径为null"),
    FILE_NOT_FOUND(200, "文件不存在"),
    UN_SUPPORTED_ENCODING(-200, "不支持的Encoding类型");

    private int code;
    private String message;

    private ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
