package com.hui.domain;


import com.hui.enums.AppHttpCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/* *
* @Author: 廖耀华
* @Description: 统一返回结果类
* @Date: 2024/8/15 12:00
* */
public class Result<T> {

    private Integer code; //编码：200成功，400或其它数字为失败
    private String msg; //信息
    private Long timestamp; // 当前时间
    private T data; //数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 200;
        result.timestamp = System.currentTimeMillis();
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 200;
        result.timestamp = System.currentTimeMillis();
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 400;
        result.timestamp = System.currentTimeMillis();
        return result;
    }

    public static Result okResult(AppHttpCodeEnum appHttpCodeEnum) {
        return setAppHttpCodeEnum(appHttpCodeEnum, appHttpCodeEnum.getErrorMessage());
    }


    public Result<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }
    public static Result okResult(int code, String msg) {
        Result result = new Result();
        return result.ok(code, null, msg);
    }
    private static Result setAppHttpCodeEnum(AppHttpCodeEnum enums, String errorMessage){
        return okResult(enums.getCode(),errorMessage);
    }
    public static Result errorResult(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums,enums.getErrorMessage());
    }
}