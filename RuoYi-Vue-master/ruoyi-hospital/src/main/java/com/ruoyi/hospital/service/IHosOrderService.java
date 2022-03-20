package com.ruoyi.hospital.service;

import java.util.List;
import com.ruoyi.hospital.domain.HosOrder;

/**
 * 预约订单Service接口
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public interface IHosOrderService 
{
    /**
     * 查询预约订单
     * 
     * @param orderId 预约订单主键
     * @return 预约订单
     */
    public HosOrder selectHosOrderByOrderId(Long orderId);

    /**
     * 查询预约订单列表
     * 
     * @param hosOrder 预约订单
     * @return 预约订单集合
     */
    public List<HosOrder> selectHosOrderList(HosOrder hosOrder);

    /**
     * 新增预约订单
     * 
     * @param hosOrder 预约订单
     * @return 结果
     */
    public int insertHosOrder(HosOrder hosOrder);

    /**
     * 修改预约订单
     * 
     * @param hosOrder 预约订单
     * @return 结果
     */
    public int updateHosOrder(HosOrder hosOrder);

    /**
     * 批量删除预约订单
     * 
     * @param orderIds 需要删除的预约订单主键集合
     * @return 结果
     */
    public int deleteHosOrderByOrderIds(Long[] orderIds);

    /**
     * 删除预约订单信息
     * 
     * @param orderId 预约订单主键
     * @return 结果
     */
    public int deleteHosOrderByOrderId(Long orderId);
}
