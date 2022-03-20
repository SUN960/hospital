package com.ruoyi.hospital.mapper;

import java.util.List;
import com.ruoyi.hospital.domain.HosAdo;

/**
 * 科室Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public interface HosAdoMapper 
{
    /**
     * 查询科室
     * 
     * @param adoId 科室主键
     * @return 科室
     */
    public HosAdo selectHosAdoByAdoId(Long adoId);

    /**
     * 查询科室列表
     * 
     * @param hosAdo 科室
     * @return 科室集合
     */
    public List<HosAdo> selectHosAdoList(HosAdo hosAdo);

    /**
     * 新增科室
     * 
     * @param hosAdo 科室
     * @return 结果
     */
    public int insertHosAdo(HosAdo hosAdo);

    /**
     * 修改科室
     * 
     * @param hosAdo 科室
     * @return 结果
     */
    public int updateHosAdo(HosAdo hosAdo);

    /**
     * 删除科室
     * 
     * @param adoId 科室主键
     * @return 结果
     */
    public int deleteHosAdoByAdoId(Long adoId);

    /**
     * 批量删除科室
     * 
     * @param adoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHosAdoByAdoIds(Long[] adoIds);
}
