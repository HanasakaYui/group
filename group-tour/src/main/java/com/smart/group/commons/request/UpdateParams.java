package com.smart.group.commons.request;

import lombok.Data;

import java.util.List;

/**
 * @Author: Emilia
 * @Since: 2020.11.28 14:46
 */
@Data
public class UpdateParams {
    /**
     * 1表示上架,2表示下架,3表示放入草稿箱,4表示放入回收站
     */
    private int code;

    /**
     * id集合
     */
    private List<Integer> groupIds;
}
