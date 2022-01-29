package com.ruoyi.project.hospital.mapper;

import java.util.List;
import com.ruoyi.project.hospital.domain.HosDuty;

/**
 * 值班Mapper接口
 * 
 * @author hospital
 * @date 2022-01-28
 */
public interface HosDutyMapper 
{
    /**
     * 查询值班
     * 
     * @param dutyId 值班ID
     * @return 值班
     */
    public HosDuty selectHosDutyById(Long dutyId);

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
     * 删除值班
     * 
     * @param dutyId 值班ID
     * @return 结果
     */
    public int deleteHosDutyById(Long dutyId);

    /**
     * 批量删除值班
     * 
     * @param dutyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHosDutyByIds(Long[] dutyIds);
}
