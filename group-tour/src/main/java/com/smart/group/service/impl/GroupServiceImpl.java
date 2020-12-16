package com.smart.group.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.group.commons.request.FindsParams;
import com.smart.group.commons.request.UpdateParams;
import com.smart.group.commons.utils.ColaBeanUtils;
import com.smart.group.commons.vo.GroupVo;
import com.smart.group.commons.vo.Groups;
import com.smart.group.entity.Group;
import com.smart.group.entity.Worker;
import com.smart.group.exception.ServiceException;
import com.smart.group.mapper.GroupMapper;
import com.smart.group.mapper.WorkerMapper;
import com.smart.group.results.ResultCodes;
import com.smart.group.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Emilia
 * @Since: 2020.11.26 21:58
 */
@Service
@Slf4j
@DS("slave")
public class GroupServiceImpl implements GroupService {
    @Resource
    GroupMapper groupMapper;
    @Resource
    WorkerMapper workerMapper;

    @Override
    public Groups getList(FindsParams findsParams, int page, int size) {
        //分页查询
        List<GroupVo> groupVos = selectPage(findsParams, page, size);
        //封装数据 -- 获取总条数、上架数、待下架数、仓库中数、草稿箱数
        Groups groupList = new Groups();
        //数据集合
        groupList.setGroupVos(groupVos);
        //总条数
        groupList.setTotalSize(groupVos.size());
        //上架数
        groupList.setUpShelves((int) groupVos.stream().filter(groupVo -> groupVo.getStatus() == 1).count());
        //待下架数
        groupList.setDownShelves((int) groupVos.stream().filter(groupVo -> groupVo.getStatus() == 2).count());
        //仓库中数
        groupList.setWarehouse((int) groupVos.stream().filter(groupVo -> groupVo.getStatus() == 3).count());
        //草稿箱数
        groupList.setDrafts((int) groupVos.stream().filter(groupVo -> groupVo.getStatus() == 4).count());
        //返回数据
        return groupList;
    }

    /**
     * 分页查询
     *
     * @param findsParams
     * @param page
     * @param size
     * @return
     */
    private List<GroupVo> selectPage(FindsParams findsParams, int page, int size) {
        PageHelper.startPage(page, size);
        Group group = new Group();
        //复制参数
        BeanUtils.copyProperties(findsParams, group);
        //分页查询数据
        PageInfo<Group> pageInfo = new PageInfo<>(groupMapper.selectGroups(group));
        //如果数据为空则直接抛异常
        if (pageInfo.getList() == null) {
            throw new ServiceException(ResultCodes.DATA_IS_NOT_FIND);
        }
        //复制数据
        List<GroupVo> groupVos = ColaBeanUtils.copyListProperties(pageInfo.getList(), GroupVo::new);
        //获取更新人id
        List<Integer> workerIds = new ArrayList<>();
        pageInfo.getList().forEach(temp -> workerIds.add(temp.getWorkerId()));
        //查询更新人
        List<Worker> workers = workerMapper.selectWorkersByIds(workerIds);
        //复制名字
        getWorkersName(workers, groupVos);
        //返回vo分页数据
        return groupVos;
    }

    /**
     * 复制 workerName
     *
     * @param workers
     * @param groupVos
     */
    private void getWorkersName(List<Worker> workers, List<GroupVo> groupVos) {
        for (Worker worker : workers) {
            for (GroupVo groupVo : groupVos) {
                //id相同则表示是同一个更新人
                if (worker.getWorkerId().equals(groupVo.getWorkerId())) {
                    groupVo.setWorkerName(worker.getWorkerName());
                }
            }
        }
    }

    /**
     * 上架、下架、放入草稿箱、放入回收站的通用方法
     *
     * @param updateParams
     */
    @Override
    @DS("master")
    public Boolean toModifyGroups(UpdateParams updateParams) {
        //修改
        int count = groupMapper.updateGroups(updateParams.getCode(), updateParams.getGroupIds());
        log.info(count + "");
        //如果大于0则返回true,否则直接抛异常
        if (count > 0) {
            return true;
        } else {
            throw new ServiceException(ResultCodes.UPDATE_IS_ERROR);
        }
        //return Optional.of(count).map(num -> true).orElseThrow(() -> new ServiceException(ResultCodes.DATA_IS_WRONG));
    }
}
