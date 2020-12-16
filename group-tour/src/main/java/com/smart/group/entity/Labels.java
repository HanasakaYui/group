package com.smart.group.entity;

import lombok.Data;

/**
 * 类型标签表
 */
@Data
public class Labels {
    /**
     * 标签类型id
     */
    private Integer labelId;

    /**
     * 1表示热门,2表示推荐,3表示新品
     */
    private Integer labelType;
}