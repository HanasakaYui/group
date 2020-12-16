package com.smart.group.exception;

import com.smart.group.results.ResultCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author Emilia
 * @Since 2020.11.09 15:31
 */
@Data
@NoArgsConstructor
public class BaseException extends RuntimeException {
    private int status;
    private String msg;
    private String tips;

    public BaseException(ResultCodes resultCode) {
        this.status = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.tips = resultCode.getTips();
    }
}
