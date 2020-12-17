package com.wish.common.exception;

import com.wish.common.data.response.ResponseResult;
import com.wish.common.data.response.ResponseResultCode;

/**
 * 功能：
 *      业务异常类
 * @author sunpeng
 * @date 2017
 */
public class BusinessException extends RuntimeException {

    public int code;

    public String msg;

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String msg) {
        this.code = 500;
        this.msg = msg;
    }

    public BusinessException(ResponseResultCode res) {
        this.code = res.getCode();
        this.msg = res.getMsg();
    }

    public BusinessException(ResponseResult res) {
        this.code = res.getCode();
        this.msg = res.getMsg();
    }
}