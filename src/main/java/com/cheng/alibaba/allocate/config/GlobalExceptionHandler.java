package com.cheng.alibaba.allocate.config;

import com.cheng.alibaba.allocate.common.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse handleException(Exception e) {
        // 打印异常堆栈信息
        log.error("GlobalException is {}", e);
        return CommonResponse.error(e.getMessage());
    }

    /**
     * 处理所有参数校验异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResponse argsCheck(MethodArgumentNotValidException  e) {
        List<FieldError> bindingResult = e.getBindingResult().getFieldErrors();
        String errMsg = "["+bindingResult.get(0).getField()+"] " + bindingResult.get(0).getDefaultMessage();
        return CommonResponse.error(errMsg);
    }
}
