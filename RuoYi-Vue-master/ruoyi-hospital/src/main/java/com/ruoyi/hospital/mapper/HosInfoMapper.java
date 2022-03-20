package com.ruoyi.hospital.mapper;

import java.util.List;
import com.ruoyi.hospital.domain.HosInfo;

/**
 * 预约信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public interface HosInfoMapper 
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
     * 删除预约信息
     * 
     * @param appointId 预约信息主键
     * @return 结果
     */
    public int deleteHosInfoByAppointId(Long appointId);

    /**
     * 批量删除预约信息
     * 
     * @param appointIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHosInfoByAppointIds(Long[] appointIds);
}
