package com.ruoyi.hospital.mapper;

import java.util.List;
import com.ruoyi.hospital.domain.HosUser;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public interface HosUserMapper 
{
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息主键
     * @return 用户信息
     */
    public HosUser selectHosUserByUserId(Long userId);

    /**
     * 查询用户信息列表
     * 
     * @param hosUser 用户信息
     * @return 用户信息集合
     */
    public List<HosUser> selectHosUserList(HosUser hosUser);

    /**
     * 新增用户信息
     * 
     * @param hosUser 用户信息
     * @return 结果
     */
    public int insertHosUser(HosUser hosUser);

    /**
     * 修改用户信息
     * 
     * @param hosUser 用户信息
     * @return 结果
     */
    public int updateHosUser(HosUser hosUser);

    /**
     * 删除用户信息
     * 
     * @param userId 用户信息主键
     * @return 结果
     */
    public int deleteHosUserByUserId(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHosUserByUserIds(Long[] userIds);
}
