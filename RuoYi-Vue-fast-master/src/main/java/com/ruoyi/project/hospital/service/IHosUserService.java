package com.ruoyi.project.hospital.service;

import java.util.List;
import com.ruoyi.project.hospital.domain.HosUser;

/**
 * 用户信息Service接口
 *
 * @author ss
 * @date 2022-02-09
 */
public interface IHosUserService
{
    /**
     * 查询用户信息
     *
     * @param userId 用户信息ID
     * @return 用户信息
     */
    public HosUser selectHosUserById(Long userId);

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
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户信息ID
     * @return 结果
     */
    public int deleteHosUserByIds(Long[] userIds);

    /**
     * 删除用户信息信息
     *
     * @param userId 用户信息ID
     * @return 结果
     */
    public int deleteHosUserById(Long userId);
}
