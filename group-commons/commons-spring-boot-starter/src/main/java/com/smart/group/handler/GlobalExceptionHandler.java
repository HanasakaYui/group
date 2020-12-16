package com.smart.group.handler;

import com.smart.group.exception.ServiceException;
import com.smart.group.results.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Emilia
 * @Since 2020.11.09 19:54
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public <T> BaseResult<T> handler(Exception exception) {
        log.error(exception.getMessage());
        return BaseResult.error();
    }

    /*@ExceptionHandler
    public <T> BaseResult<T> handler(Exception e) {
        if (e instanceof ServiceException) {
            return BaseResult.error(((ServiceException) e).getStatus(), ((ServiceException) e).getMsg());
        } else {
            return BaseResult.error(ResultCodes.ERROR);
        }
    }*/


    @ExceptionHandler(ServiceException.class)
    public <T> BaseResult<T> handler(ServiceException exception) {
        log.error("status：" + exception.getStatus()
                + ", msg：" + exception.getMsg()
                + ", tips：" + exception.getTips());
        return BaseResult.error(exception.getStatus(), exception.getMsg(),exception.getTips());
    }

}
