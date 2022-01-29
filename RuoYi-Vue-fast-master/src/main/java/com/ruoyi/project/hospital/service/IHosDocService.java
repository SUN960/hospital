package com.ruoyi.project.hospital.service;

import java.util.List;
import com.ruoyi.project.hospital.domain.HosDoc;

/**
 * 医生Service接口
 * 
 * @author hospital
 * @date 2022-01-28
 */
public interface IHosDocService 
{
    /**
     * 查询医生
     * 
     * @param docId 医生ID
     * @return 医生
     */
    public HosDoc selectHosDocById(Long docId);

    /**
     * 查询医生列表
     * 
     * @param hosDoc 医生
     * @return 医生集合
     */
    public List<HosDoc> selectHosDocList(HosDoc hosDoc);

    /**
     * 新增医生
     * 
     * @param hosDoc 医生
     * @return 结果
     */
    public int insertHosDoc(HosDoc hosDoc);

    /**
     * 修改医生
     * 
     * @param hosDoc 医生
     * @return 结果
     */
    public int updateHosDoc(HosDoc hosDoc);

    /**
     * 批量删除医生
     * 
     * @param docIds 需要删除的医生ID
     * @return 结果
     */
    public int deleteHosDocByIds(Long[] docIds);

    /**
     * 删除医生信息
     * 
     * @param docId 医生ID
     * @return 结果
     */
    public int deleteHosDocById(Long docId);
}
