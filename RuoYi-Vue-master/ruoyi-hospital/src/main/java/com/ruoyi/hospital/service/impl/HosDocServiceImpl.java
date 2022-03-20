package com.ruoyi.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.HosDocMapper;
import com.ruoyi.hospital.domain.HosDoc;
import com.ruoyi.hospital.service.IHosDocService;

/**
 * 医生Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@Service
public class HosDocServiceImpl implements IHosDocService 
{
    @Autowired
    private HosDocMapper hosDocMapper;

    /**
     * 查询医生
     * 
     * @param docId 医生主键
     * @return 医生
     */
    @Override
    public HosDoc selectHosDocByDocId(Long docId)
    {
        return hosDocMapper.selectHosDocByDocId(docId);
    }

    /**
     * 查询医生列表
     * 
     * @param hosDoc 医生
     * @return 医生
     */
    @Override
    public List<HosDoc> selectHosDocList(HosDoc hosDoc)
    {
        return hosDocMapper.selectHosDocList(hosDoc);
    }

    /**
     * 新增医生
     * 
     * @param hosDoc 医生
     * @return 结果
     */
    @Override
    public int insertHosDoc(HosDoc hosDoc)
    {
        hosDoc.setCreateTime(DateUtils.getNowDate());
        return hosDocMapper.insertHosDoc(hosDoc);
    }

    /**
     * 修改医生
     * 
     * @param hosDoc 医生
     * @return 结果
     */
    @Override
    public int updateHosDoc(HosDoc hosDoc)
    {
        hosDoc.setUpdateTime(DateUtils.getNowDate());
        return hosDocMapper.updateHosDoc(hosDoc);
    }

    /**
     * 批量删除医生
     * 
     * @param docIds 需要删除的医生主键
     * @return 结果
     */
    @Override
    public int deleteHosDocByDocIds(Long[] docIds)
    {
        return hosDocMapper.deleteHosDocByDocIds(docIds);
    }

    /**
     * 删除医生信息
     * 
     * @param docId 医生主键
     * @return 结果
     */
    @Override
    public int deleteHosDocByDocId(Long docId)
    {
        return hosDocMapper.deleteHosDocByDocId(docId);
    }
}
