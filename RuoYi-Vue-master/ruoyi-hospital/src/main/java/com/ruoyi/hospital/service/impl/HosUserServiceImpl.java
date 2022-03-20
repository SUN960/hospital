package com.ruoyi.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.HosUserMapper;
import com.ruoyi.hospital.domain.HosUser;
import com.ruoyi.hospital.service.IHosUserService;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@Service
public class HosUserServiceImpl implements IHosUserService 
{
    @Autowired
    private HosUserMapper hosUserMapper;

    /**
     * 查询用户信息
     * 
     * @param userId 用户信息主键
     * @return 用户信息
     */
    @Override
    public HosUser selectHosUserByUserId(Long userId)
    {
        return hosUserMapper.selectHosUserByUserId(userId);
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
     * @param userIds 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteHosUserByUserIds(Long[] userIds)
    {
        return hosUserMapper.deleteHosUserByUserIds(userIds);
    }

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteHosUserByUserId(Long userId)
    {
        return hosUserMapper.deleteHosUserByUserId(userId);
    }
}
