package com.ruoyi.project.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.hospital.mapper.HosAdoMapper;
import com.ruoyi.project.hospital.domain.HosAdo;
import com.ruoyi.project.hospital.service.IHosAdoService;

/**
 * 科室Service业务层处理
 * 
 * @author sss
 * @date 2022-01-28
 */
@Service
public class HosAdoServiceImpl implements IHosAdoService 
{
    @Autowired
    private HosAdoMapper hosAdoMapper;

    /**
     * 查询科室
     * 
     * @param adoId 科室ID
     * @return 科室
     */
    @Override
    public HosAdo selectHosAdoById(Long adoId)
    {
        return hosAdoMapper.selectHosAdoById(adoId);
    }

    /**
     * 查询科室列表
     * 
     * @param hosAdo 科室
     * @return 科室
     */
    @Override
    public List<HosAdo> selectHosAdoList(HosAdo hosAdo)
    {
        return hosAdoMapper.selectHosAdoList(hosAdo);
    }

    /**
     * 新增科室
     * 
     * @param hosAdo 科室
     * @return 结果
     */
    @Override
    public int insertHosAdo(HosAdo hosAdo)
    {
        hosAdo.setCreateTime(DateUtils.getNowDate());
        return hosAdoMapper.insertHosAdo(hosAdo);
    }

    /**
     * 修改科室
     * 
     * @param hosAdo 科室
     * @return 结果
     */
    @Override
    public int updateHosAdo(HosAdo hosAdo)
    {
        hosAdo.setUpdateTime(DateUtils.getNowDate());
        return hosAdoMapper.updateHosAdo(hosAdo);
    }

    /**
     * 批量删除科室
     * 
     * @param adoIds 需要删除的科室ID
     * @return 结果
     */
    @Override
    public int deleteHosAdoByIds(Long[] adoIds)
    {
        return hosAdoMapper.deleteHosAdoByIds(adoIds);
    }

    /**
     * 删除科室信息
     * 
     * @param adoId 科室ID
     * @return 结果
     */
    @Override
    public int deleteHosAdoById(Long adoId)
    {
        return hosAdoMapper.deleteHosAdoById(adoId);
    }
}
