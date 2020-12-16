package com.smart.group.commons.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Emilia
 * @Since: 2020.11.27 17:34
 */
@Data
public class Groups {
    /**
     * 数据
     */
    private List<GroupVo> groupVos;

    /**
     * 总条数
     */
    private int totalSize;

    /**
     * 上架数
     */
    private int upShelves;

    /**
     * 待下架数
     */
    private int downShelves;

    /**
     * 仓库中
     */
    private int warehouse;

    /**
     * 草稿箱
     */
    private int drafts;
}
