package com.ruoyi.hospital.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hospital.mapper.HosOrderMapper;
import com.ruoyi.hospital.domain.HosOrder;
import com.ruoyi.hospital.service.IHosOrderService;

/**
 * 预约订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@Service
public class HosOrderServiceImpl implements IHosOrderService 
{
    @Autowired
    private HosOrderMapper hosOrderMapper;

    /**
     * 查询预约订单
     * 
     * @param orderId 预约订单主键
     * @return 预约订单
     */
    @Override
    public HosOrder selectHosOrderByOrderId(Long orderId)
    {
        return hosOrderMapper.selectHosOrderByOrderId(orderId);
    }

    /**
     * 查询预约订单列表
     * 
     * @param hosOrder 预约订单
     * @return 预约订单
     */
    @Override
    public List<HosOrder> selectHosOrderList(HosOrder hosOrder)
    {
        return hosOrderMapper.selectHosOrderList(hosOrder);
    }

    /**
     * 新增预约订单
     * 
     * @param hosOrder 预约订单
     * @return 结果
     */
    @Override
    public int insertHosOrder(HosOrder hosOrder)
    {
        hosOrder.setCreateTime(DateUtils.getNowDate());
        return hosOrderMapper.insertHosOrder(hosOrder);
    }

    /**
     * 修改预约订单
     * 
     * @param hosOrder 预约订单
     * @return 结果
     */
    @Override
    public int updateHosOrder(HosOrder hosOrder)
    {
        hosOrder.setUpdateTime(DateUtils.getNowDate());
        return hosOrderMapper.updateHosOrder(hosOrder);
    }

    /**
     * 批量删除预约订单
     * 
     * @param orderIds 需要删除的预约订单主键
     * @return 结果
     */
    @Override
    public int deleteHosOrderByOrderIds(Long[] orderIds)
    {
        return hosOrderMapper.deleteHosOrderByOrderIds(orderIds);
    }

    /**
     * 删除预约订单信息
     * 
     * @param orderId 预约订单主键
     * @return 结果
     */
    @Override
    public int deleteHosOrderByOrderId(Long orderId)
    {
        return hosOrderMapper.deleteHosOrderByOrderId(orderId);
    }
}
