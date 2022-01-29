package com.ruoyi.project.hospital.service;

import java.util.List;
import com.ruoyi.project.hospital.domain.HosAdo;

/**
 * 科室Service接口
 * 
 * @author sss
 * @date 2022-01-28
 */
public interface IHosAdoService 
{
    /**
     * 查询科室
     * 
     * @param adoId 科室ID
     * @return 科室
     */
    public HosAdo selectHosAdoById(Long adoId);

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
     * 批量删除科室
     * 
     * @param adoIds 需要删除的科室ID
     * @return 结果
     */
    public int deleteHosAdoByIds(Long[] adoIds);

    /**
     * 删除科室信息
     * 
     * @param adoId 科室ID
     * @return 结果
     */
    public int deleteHosAdoById(Long adoId);
}
