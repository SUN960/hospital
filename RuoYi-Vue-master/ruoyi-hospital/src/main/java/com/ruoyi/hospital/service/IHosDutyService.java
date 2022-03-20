package com.ruoyi.hospital.service;

import java.util.List;
import com.ruoyi.hospital.domain.HosDuty;

/**
 * 值班Service接口
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public interface IHosDutyService 
{
    /**
     * 查询值班
     * 
     * @param dutyId 值班主键
     * @return 值班
     */
    public HosDuty selectHosDutyByDutyId(Long dutyId);

    /**
     * 查询值班列表
     * 
     * @param hosDuty 值班
     * @return 值班集合
     */
    public List<HosDuty> selectHosDutyList(HosDuty hosDuty);

    /**
     * 新增值班
     * 
     * @param hosDuty 值班
     * @return 结果
     */
    public int insertHosDuty(HosDuty hosDuty);

    /**
     * 修改值班
     * 
     * @param hosDuty 值班
     * @return 结果
     */
    public int updateHosDuty(HosDuty hosDuty);

    /**
     * 批量删除值班
     * 
     * @param dutyIds 需要删除的值班主键集合
     * @return 结果
     */
    public int deleteHosDutyByDutyIds(Long[] dutyIds);

    /**
     * 删除值班信息
     * 
     * @param dutyId 值班主键
     * @return 结果
     */
    public int deleteHosDutyByDutyId(Long dutyId);
}
