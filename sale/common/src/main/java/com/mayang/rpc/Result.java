package com.mayang.rpc;


import lombok.Data;

import java.io.Serializable;

/**
 * Dubbo接口返回值封装
 * @param <T>
 */

@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private Boolean success;

    private T data;

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAIL_CODE = 500;

    /**
     * 成功
     * @param data
     * @return
     */
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.TRUE);
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return success(null);
    }


        /**
         * 失败
         * @param code 错误码
         * @param message 错误信息
         * @return
         */
    public static <T> Result<T> fail(Integer code, String message) {
        Result<T> result=new Result<>();
        result.setSuccess(Boolean.FALSE);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> fail(String message) {
        return fail(FAIL_CODE, message);
    }


}
