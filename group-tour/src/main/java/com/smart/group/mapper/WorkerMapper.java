package com.smart.group.mapper;

import com.smart.group.entity.Worker;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface WorkerMapper {
    int deleteByPrimaryKey(Integer workerId);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(Integer workerId);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);

    /**
     * 查询
     *
     * @param workerIds
     * @return
     */
    List<Worker> selectWorkersByIds(@Param("workerIds") List<Integer> workerIds);
}