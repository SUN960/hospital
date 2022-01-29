package com.ruoyi.project.hospital.mapper;

import java.util.List;
import com.ruoyi.project.hospital.domain.HosOrder;

/**
 * 预约订单Mapper接口
 * 
 * @author hospital
 * @date 2022-01-28
 */
public interface HosOrderMapper 
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
     * 删除预约订单
     * 
     * @param orderId 预约订单ID
     * @return 结果
     */
    public int deleteHosOrderById(Long orderId);

    /**
     * 批量删除预约订单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHosOrderByIds(Long[] orderIds);
}
