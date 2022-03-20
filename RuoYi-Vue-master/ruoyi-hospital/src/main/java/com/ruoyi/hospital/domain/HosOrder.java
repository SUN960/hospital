package com.ruoyi.hospital.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预约订单对象 hos_order
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public class HosOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号 */
    private Long orderId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userId;

    /** 日期 */
    @Excel(name = "日期")
    private String date;

    /** 挂号费用 */
    @Excel(name = "挂号费用")
    private BigDecimal cost;

    /** 政策减免 */
    @Excel(name = "政策减免")
    private BigDecimal policy;

    /** 其它费用 */
    @Excel(name = "其它费用")
    private BigDecimal otherCost;

    /** 总费用 */
    @Excel(name = "总费用")
    private BigDecimal totalCost;

    /** 支付状态（0正常 1停用） */
    @Excel(name = "支付状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 值班号 */
    private String dutyId;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }
    public void setCost(BigDecimal cost) 
    {
        this.cost = cost;
    }

    public BigDecimal getCost() 
    {
        return cost;
    }
    public void setPolicy(BigDecimal policy) 
    {
        this.policy = policy;
    }

    public BigDecimal getPolicy() 
    {
        return policy;
    }
    public void setOtherCost(BigDecimal otherCost) 
    {
        this.otherCost = otherCost;
    }

    public BigDecimal getOtherCost() 
    {
        return otherCost;
    }
    public void setTotalCost(BigDecimal totalCost) 
    {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalCost() 
    {
        return totalCost;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDutyId(String dutyId) 
    {
        this.dutyId = dutyId;
    }

    public String getDutyId() 
    {
        return dutyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("userId", getUserId())
            .append("date", getDate())
            .append("cost", getCost())
            .append("policy", getPolicy())
            .append("otherCost", getOtherCost())
            .append("totalCost", getTotalCost())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dutyId", getDutyId())
            .toString();
    }
}
