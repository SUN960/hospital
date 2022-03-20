package com.ruoyi.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.HosDutyMapper;
import com.ruoyi.hospital.domain.HosDuty;
import com.ruoyi.hospital.service.IHosDutyService;

/**
 * 值班Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@Service
public class HosDutyServiceImpl implements IHosDutyService 
{
    @Autowired
    private HosDutyMapper hosDutyMapper;

    /**
     * 查询值班
     * 
     * @param dutyId 值班主键
     * @return 值班
     */
    @Override
    public HosDuty selectHosDutyByDutyId(Long dutyId)
    {
        return hosDutyMapper.selectHosDutyByDutyId(dutyId);
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
     * @param dutyIds 需要删除的值班主键
     * @return 结果
     */
    @Override
    public int deleteHosDutyByDutyIds(Long[] dutyIds)
    {
        return hosDutyMapper.deleteHosDutyByDutyIds(dutyIds);
    }

    /**
     * 删除值班信息
     * 
     * @param dutyId 值班主键
     * @return 结果
     */
    @Override
    public int deleteHosDutyByDutyId(Long dutyId)
    {
        return hosDutyMapper.deleteHosDutyByDutyId(dutyId);
    }
}
