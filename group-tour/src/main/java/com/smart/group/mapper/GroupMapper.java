package com.smart.group.mapper;

import com.smart.group.entity.Group;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface GroupMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    /**
     * 查询所有路线信息
     *
     * @param group
     * @return
     */
    List<Group> selectGroups(@Param("group") Group group);

    /**
     * 上架、下架、放入草稿箱、放入回收站
     *
     * @param code     1表示上架,2表示下架,3表示放入草稿箱,4表示放入回收站
     * @param groupIds
     * @return
     */
    int updateGroups(@Param("code") int code, @Param("groupIds") List<Integer> groupIds);
}