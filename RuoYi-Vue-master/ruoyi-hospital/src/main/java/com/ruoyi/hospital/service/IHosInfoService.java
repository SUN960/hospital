package com.ruoyi.hospital.service;

import java.util.List;
import com.ruoyi.hospital.domain.HosInfo;

/**
 * 预约信息Service接口
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public interface IHosInfoService 
{
    /**
     * 查询预约信息
     * 
     * @param appointId 预约信息主键
     * @return 预约信息
     */
    public HosInfo selectHosInfoByAppointId(Long appointId);

    /**
     * 查询预约信息列表
     * 
     * @param hosInfo 预约信息
     * @return 预约信息集合
     */
    public List<HosInfo> selectHosInfoList(HosInfo hosInfo);

    /**
     * 新增预约信息
     * 
     * @param hosInfo 预约信息
     * @return 结果
     */
    public int insertHosInfo(HosInfo hosInfo);

    /**
     * 修改预约信息
     * 
     * @param hosInfo 预约信息
     * @return 结果
     */
    public int updateHosInfo(HosInfo hosInfo);

    /**
     * 批量删除预约信息
     * 
     * @param appointIds 需要删除的预约信息主键集合
     * @return 结果
     */
    public int deleteHosInfoByAppointIds(Long[] appointIds);

    /**
     * 删除预约信息信息
     * 
     * @param appointId 预约信息主键
     * @return 结果
     */
    public int deleteHosInfoByAppointId(Long appointId);
}
