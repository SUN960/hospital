package com.ruoyi.project.hospital.service;

import java.util.List;
import com.ruoyi.project.hospital.domain.HosOrder;

/**
 * 预约订单Service接口
 * 
 * @author hospital
 * @date 2022-01-28
 */
public interface IHosOrderService 
{
    /**
     * 查询预约订单
     * 
     * @param orderId 预约订单ID
     * @return 预约订单
     */
    public HosOrder selectHosOrderById(Long orderId);

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
     * @param orderIds 需要删除的预约订单ID
     * @return 结果
     */
    public int deleteHosOrderByIds(Long[] orderIds);

    /**
     * 删除预约订单信息
     * 
     * @param orderId 预约订单ID
     * @return 结果
     */
    public int deleteHosOrderById(Long orderId);
}
