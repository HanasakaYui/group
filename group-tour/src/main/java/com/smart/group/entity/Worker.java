package com.smart.group.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Worker {
    /**
     * id
     */
    private Integer workerId;

    /**
     * 姓名
     */
    private String workerName;

    /**
     * 密码
     */
    private String workerPassword;

    private Date createDate;

    /**
     * 0表示为删除,1表示删除
     */
    private Integer isDel;
}