package com.ruoyi.project.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.hospital.mapper.HosDocMapper;
import com.ruoyi.project.hospital.domain.HosDoc;
import com.ruoyi.project.hospital.service.IHosDocService;

/**
 * 医生Service业务层处理
 * 
 * @author hospital
 * @date 2022-01-28
 */
@Service
public class HosDocServiceImpl implements IHosDocService 
{
    @Autowired
    private HosDocMapper hosDocMapper;

    /**
     * 查询医生
     * 
     * @param docId 医生ID
     * @return 医生
     */
    @Override
    public HosDoc selectHosDocById(Long docId)
    {
        return hosDocMapper.selectHosDocById(docId);
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
     * @param docIds 需要删除的医生ID
     * @return 结果
     */
    @Override
    public int deleteHosDocByIds(Long[] docIds)
    {
        return hosDocMapper.deleteHosDocByIds(docIds);
    }

    /**
     * 删除医生信息
     * 
     * @param docId 医生ID
     * @return 结果
     */
    @Override
    public int deleteHosDocById(Long docId)
    {
        return hosDocMapper.deleteHosDocById(docId);
    }
}
