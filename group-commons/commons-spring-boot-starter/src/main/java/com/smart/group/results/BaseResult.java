package com.smart.group.results;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 返回结果封装类
 * @author
 */
@Data
@Builder
@AllArgsConstructor
public class BaseResult<T> {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回说明
     */
    private String msg;

    /**
     * 提示
     */
    private String tips;

    /**
     * 返回数据
     */
    private T data;


    public BaseResult() {
    }

    public BaseResult(T data) {
        this();
        this.data = data;
    }

    public BaseResult(ResultCodes codes, T data) {
        this.code = codes.code;
        this.msg = codes.msg;
        this.tips = codes.tips;
        this.data = data;
    }

    public BaseResult(ResultCodes codes) {
        this.code = codes.code;
        this.msg = codes.msg;
        this.tips = codes.tips;
    }

    /**
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> success(T data) {
        return success(ResultCodes.SUCCESS, data);
    }

    /**
     * @param codeEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> success(ResultCodes codeEnum, T data) {
        return new BaseResult<>(codeEnum, data);
    }

    public static <T> BaseResult<T> error() {
        return new BaseResult<T>(ResultCodes.ERROR);
    }


    public static <T> BaseResult<T> error(ResultCodes codeEnum) {
        return error(codeEnum, null);
    }

    public static <T> BaseResult<T> error(ResultCodes codeEnum, T data) {
        return new BaseResult<>(codeEnum, data);
    }

    public static <T> BaseResult<T> error(int code, String msg, String tips) {
        return BaseResult
                .<T>builder()
                .code(code)
                .msg(msg)
                .tips(tips).build();
    }
}
