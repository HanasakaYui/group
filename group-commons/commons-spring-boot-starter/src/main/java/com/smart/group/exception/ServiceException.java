package com.smart.group.exception;


import com.smart.group.results.ResultCodes;

/**
 * @Author Emilia
 * @Since 2020.11.09 15:32
 */
public class ServiceException extends BaseException {

    public ServiceException(ResultCodes resultCode) {
        super(resultCode);
    }
}
