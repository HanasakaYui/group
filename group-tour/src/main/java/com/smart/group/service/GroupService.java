package com.smart.group.service;

import com.smart.group.commons.request.FindsParams;
import com.smart.group.commons.request.UpdateParams;
import com.smart.group.commons.vo.Groups;

/**
 * @Author: Emilia
 * @Since: 2020.11.26 21:57
 */
public interface GroupService {
    /**
     * 分页查询所有数据
     * @param findsParams
     * @param page
     * @param size
     * @return
     */
    Groups getList(FindsParams findsParams, int page, int size);

    /**
     * 修改
     * @param updateParams
     * @return
     */
    Boolean toModifyGroups(UpdateParams updateParams);
}
