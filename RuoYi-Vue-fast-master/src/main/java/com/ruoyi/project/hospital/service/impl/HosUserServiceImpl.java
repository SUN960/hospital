package com.ruoyi.project.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.hospital.mapper.HosUserMapper;
import com.ruoyi.project.hospital.domain.HosUser;
import com.ruoyi.project.hospital.service.IHosUserService;

/**
 * 用户信息Service业务层处理
 *
 * @author ss
 * @date 2022-02-09
 */
@Service
public class HosUserServiceImpl implements IHosUserService
{
    @Autowired
    private HosUserMapper hosUserMapper;

    /**
     * 查询用户信息
     *
     * @param userId 用户信息ID
     * @return 用户信息
     */
    @Override
    public HosUser selectHosUserById(Long userId)
    {
        return hosUserMapper.selectHosUserById(userId);
    }

    /**
     * 查询用户信息列表
     *
     * @param hosUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<HosUser> selectHosUserList(HosUser hosUser)
    {
        return hosUserMapper.selectHosUserList(hosUser);
    }

    /**
     * 新增用户信息
     *
     * @param hosUser 用户信息
     * @return 结果
     */
    @Override
    public int insertHosUser(HosUser hosUser)
    {
        hosUser.setCreateTime(DateUtils.getNowDate());
        return hosUserMapper.insertHosUser(hosUser);
    }

    /**
     * 修改用户信息
     *
     * @param hosUser 用户信息
     * @return 结果
     */
    @Override
    public int updateHosUser(HosUser hosUser)
    {
        hosUser.setUpdateTime(DateUtils.getNowDate());
        return hosUserMapper.updateHosUser(hosUser);
    }

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteHosUserByIds(Long[] userIds)
    {
        return hosUserMapper.deleteHosUserByIds(userIds);
    }

    /**
     * 删除用户信息信息
     *
     * @param userId 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteHosUserById(Long userId)
    {
        return hosUserMapper.deleteHosUserById(userId);
    }
}
