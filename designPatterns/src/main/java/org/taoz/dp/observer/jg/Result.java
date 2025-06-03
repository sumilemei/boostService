package org.taoz.dp.observer.jg;


/**
 * @author taozheng
 * @date 2023/3/13 - 22:23
 * @introduce:
 */
public class Result<T>  {
    private int status = 200;
    private String message;
    private T data;

    public Result() {
    }

    public Result(ResultStatus status) {
        this.status = status.getCode();
        this.message = status.getMessage();
    }

    public Result(String message) {
        this.message = message;
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(ResultStatus status, T data) {
        this.status = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
