package com.ruoyi.project.hospital.service;

import java.util.List;
import com.ruoyi.project.hospital.domain.HosInfo;

/**
 * 预约信息Service接口
 * 
 * @author hospital
 * @date 2022-01-28
 */
public interface IHosInfoService 
{
    /**
     * 查询预约信息
     * 
     * @param appointId 预约信息ID
     * @return 预约信息
     */
    public HosInfo selectHosInfoById(Long appointId);

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
     * @param appointIds 需要删除的预约信息ID
     * @return 结果
     */
    public int deleteHosInfoByIds(Long[] appointIds);

    /**
     * 删除预约信息信息
     * 
     * @param appointId 预约信息ID
     * @return 结果
     */
    public int deleteHosInfoById(Long appointId);
}
