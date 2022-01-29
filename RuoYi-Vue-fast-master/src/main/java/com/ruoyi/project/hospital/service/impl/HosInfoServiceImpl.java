package com.ruoyi.project.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.hospital.mapper.HosInfoMapper;
import com.ruoyi.project.hospital.domain.HosInfo;
import com.ruoyi.project.hospital.service.IHosInfoService;

/**
 * 预约信息Service业务层处理
 * 
 * @author hospital
 * @date 2022-01-28
 */
@Service
public class HosInfoServiceImpl implements IHosInfoService 
{
    @Autowired
    private HosInfoMapper hosInfoMapper;

    /**
     * 查询预约信息
     * 
     * @param appointId 预约信息ID
     * @return 预约信息
     */
    @Override
    public HosInfo selectHosInfoById(Long appointId)
    {
        return hosInfoMapper.selectHosInfoById(appointId);
    }

    /**
     * 查询预约信息列表
     * 
     * @param hosInfo 预约信息
     * @return 预约信息
     */
    @Override
    public List<HosInfo> selectHosInfoList(HosInfo hosInfo)
    {
        return hosInfoMapper.selectHosInfoList(hosInfo);
    }

    /**
     * 新增预约信息
     * 
     * @param hosInfo 预约信息
     * @return 结果
     */
    @Override
    public int insertHosInfo(HosInfo hosInfo)
    {
        hosInfo.setCreateTime(DateUtils.getNowDate());
        return hosInfoMapper.insertHosInfo(hosInfo);
    }

    /**
     * 修改预约信息
     * 
     * @param hosInfo 预约信息
     * @return 结果
     */
    @Override
    public int updateHosInfo(HosInfo hosInfo)
    {
        hosInfo.setUpdateTime(DateUtils.getNowDate());
        return hosInfoMapper.updateHosInfo(hosInfo);
    }

    /**
     * 批量删除预约信息
     * 
     * @param appointIds 需要删除的预约信息ID
     * @return 结果
     */
    @Override
    public int deleteHosInfoByIds(Long[] appointIds)
    {
        return hosInfoMapper.deleteHosInfoByIds(appointIds);
    }

    /**
     * 删除预约信息信息
     * 
     * @param appointId 预约信息ID
     * @return 结果
     */
    @Override
    public int deleteHosInfoById(Long appointId)
    {
        return hosInfoMapper.deleteHosInfoById(appointId);
    }
}
