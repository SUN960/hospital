package com.ruoyi.project.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.hospital.mapper.HosDutyMapper;
import com.ruoyi.project.hospital.domain.HosDuty;
import com.ruoyi.project.hospital.service.IHosDutyService;

/**
 * 值班Service业务层处理
 * 
 * @author hospital
 * @date 2022-01-28
 */
@Service
public class HosDutyServiceImpl implements IHosDutyService 
{
    @Autowired
    private HosDutyMapper hosDutyMapper;

    /**
     * 查询值班
     * 
     * @param dutyId 值班ID
     * @return 值班
     */
    @Override
    public HosDuty selectHosDutyById(Long dutyId)
    {
        return hosDutyMapper.selectHosDutyById(dutyId);
    }

    /**
     * 查询值班列表
     * 
     * @param hosDuty 值班
     * @return 值班
     */
    @Override
    public List<HosDuty> selectHosDutyList(HosDuty hosDuty)
    {
        return hosDutyMapper.selectHosDutyList(hosDuty);
    }

    /**
     * 新增值班
     * 
     * @param hosDuty 值班
     * @return 结果
     */
    @Override
    public int insertHosDuty(HosDuty hosDuty)
    {
        hosDuty.setCreateTime(DateUtils.getNowDate());
        return hosDutyMapper.insertHosDuty(hosDuty);
    }

    /**
     * 修改值班
     * 
     * @param hosDuty 值班
     * @return 结果
     */
    @Override
    public int updateHosDuty(HosDuty hosDuty)
    {
        hosDuty.setUpdateTime(DateUtils.getNowDate());
        return hosDutyMapper.updateHosDuty(hosDuty);
    }

    /**
     * 批量删除值班
     * 
     * @param dutyIds 需要删除的值班ID
     * @return 结果
     */
    @Override
    public int deleteHosDutyByIds(Long[] dutyIds)
    {
        return hosDutyMapper.deleteHosDutyByIds(dutyIds);
    }

    /**
     * 删除值班信息
     * 
     * @param dutyId 值班ID
     * @return 结果
     */
    @Override
    public int deleteHosDutyById(Long dutyId)
    {
        return hosDutyMapper.deleteHosDutyById(dutyId);
    }
}
