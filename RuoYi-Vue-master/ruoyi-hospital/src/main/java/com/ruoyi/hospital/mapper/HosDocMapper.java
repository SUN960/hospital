package com.ruoyi.hospital.mapper;

import java.util.List;
import com.ruoyi.hospital.domain.HosDoc;

/**
 * 医生Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public interface HosDocMapper 
{
    /**
     * 查询医生
     * 
     * @param docId 医生主键
     * @return 医生
     */
    public HosDoc selectHosDocByDocId(Long docId);

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
     * 删除医生
     * 
     * @param docId 医生主键
     * @return 结果
     */
    public int deleteHosDocByDocId(Long docId);

    /**
     * 批量删除医生
     * 
     * @param docIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHosDocByDocIds(Long[] docIds);
}
