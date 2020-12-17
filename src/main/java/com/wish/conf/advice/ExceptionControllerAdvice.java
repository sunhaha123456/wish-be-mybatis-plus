package com.wish.conf.advice;

import com.wish.common.data.response.ResponseResult;
import com.wish.common.data.response.ResponseResultCode;
import com.wish.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 功能：controller 加强类
 * @author sunpeng
 * @date 2017
 */
@Slf4j
@ControllerAdvice(basePackages = {"com.wish.controler"})
public class ExceptionControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return ResponseResult.ok(body);
    }

    @ResponseBody
    @ExceptionHandler()
    public Object handler(BusinessException e) {
        log.error("【BusinessException】返回错误信息：{}", e.msg);
        return ResponseResult.build(e.code, e.msg);
    }

    @ResponseBody
    @ExceptionHandler()
    public Object handler(Exception e) {
    	log.error("【Exception】返回错误信息：{}", e);
        return ResponseResult.build(ResponseResultCode.SERVER_ERROR);
    }
}