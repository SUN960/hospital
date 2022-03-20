package com.ruoyi.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.HosInfoMapper;
import com.ruoyi.hospital.domain.HosInfo;
import com.ruoyi.hospital.service.IHosInfoService;

/**
 * 预约信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@Service
public class HosInfoServiceImpl implements IHosInfoService 
{
    @Autowired
    private HosInfoMapper hosInfoMapper;

    /**
     * 查询预约信息
     * 
     * @param appointId 预约信息主键
     * @return 预约信息
     */
    @Override
    public HosInfo selectHosInfoByAppointId(Long appointId)
    {
        return hosInfoMapper.selectHosInfoByAppointId(appointId);
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
     * @param appointIds 需要删除的预约信息主键
     * @return 结果
     */
    @Override
    public int deleteHosInfoByAppointIds(Long[] appointIds)
    {
        return hosInfoMapper.deleteHosInfoByAppointIds(appointIds);
    }

    /**
     * 删除预约信息信息
     * 
     * @param appointId 预约信息主键
     * @return 结果
     */
    @Override
    public int deleteHosInfoByAppointId(Long appointId)
    {
        return hosInfoMapper.deleteHosInfoByAppointId(appointId);
    }
}
