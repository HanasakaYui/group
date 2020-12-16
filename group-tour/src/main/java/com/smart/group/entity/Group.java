package com.smart.group.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 团建列表
 */
@Data
public class Group {
    /**
     * 产品id
     */
    private Long groupId;

    /**
     * 1表示上架中,2表示待下架,3表示仓库中,4不表示草稿箱,5表示回收站
     */
    private Integer status;

    /**
     * 1表示团建旅游,2表示拓展团建,3表示常规旅游,4表示奖励旅游
     */
    private Integer groupType;

    /**
     * 主要景点
     */
    private String attractions;

    /**
     * 线路名称
     */
    private String routeName;

    /**
     * 过期时间
     */
    private Date staleDate;

    /**
     * 价格
     */
    private Long price;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新人id
     */
    private Integer workerId;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 点击
     */
    private Integer click;

    /**
     * 创建时间
     */
    private Date createDate;

    private Integer version;

    /**
     * 0表示为删除,1表示删除
     */
    private Integer isDel;

    private List<Labels> labelsList;
}