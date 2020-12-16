package com.smart.group.commons.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

/**
 * @Author: Emilia
 * @Since: 2020.11.27 11:53
 */
@Data
@Validated
public class FindsParams {
    /**
     * 1表示上架中,2表示待下架,3表示仓库中,4表示草稿箱,5表示回收站
     */
    @Size(min = 1,max = 5)
    private Integer status;

    /**
     * 1表示团建旅游,2表示拓展团建,3表示常规旅游,4表示奖励旅游
     */
    @Size(min = 1,max = 4)
    private Integer groupType;

    /**
     * 线路名称
     */
    private String routeName;
}
