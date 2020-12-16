package com.smart.group.controller;

import com.smart.group.commons.request.FindsParams;
import com.smart.group.commons.request.UpdateParams;
import com.smart.group.commons.vo.Groups;
import com.smart.group.results.BaseResult;
import com.smart.group.service.GroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: Emilia
 * @Since: 2020.11.26 21:55
 */
@RestController
@RequestMapping("/group")
public class GroupController {
    @Resource
    GroupService groupService;

    /**
     * 查询所有旅游信息
     * @param findsParams 条件参数
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/get")
    public BaseResult<Groups> getList(FindsParams findsParams, int page, int size) {
        Groups groupsList = groupService.getList(findsParams, page, size);
        return BaseResult.success(groupsList);
    }

    /**
     * 上架、下架、放入草稿箱、放入回收站的方法
     * @param updateParams
     * @return
     */
    @PutMapping("/update")
    public BaseResult<Boolean> modifyGroups(@RequestBody UpdateParams updateParams) {
        Boolean success = groupService.toModifyGroups(updateParams);
        return BaseResult.success(success);
    }
}
