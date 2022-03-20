package com.ruoyi.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 值班对象 hos_duty
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public class HosDuty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 值班编号 */
    private Long dutyId;

    /** 医生ID */
    @Excel(name = "医生ID")
    private Long docId;

    /** 显示顺序 */
    private Long orderNum;

    /** 值班日期 */
    @Excel(name = "值班日期")
    private Long dutyTime;

    private HosDoc hosDoc;

    public HosDoc getHosDoc() {
        return hosDoc;
    }

    public void setHosDoc(HosDoc hosDoc) {
        this.hosDoc = hosDoc;
    }

    /** 值班时间（0 上午 1下午） */
    @Excel(name = "值班时间", readConverterExp = "0=,上=午,1=下午")
    private String duringTime;

    /** 值班状态（0正常 1停用） */
    @Excel(name = "值班状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setDutyId(Long dutyId) 
    {
        this.dutyId = dutyId;
    }

    public Long getDutyId() 
    {
        return dutyId;
    }
    public void setDocId(Long docId) 
    {
        this.docId = docId;
    }

    public Long getDocId() 
    {
        return docId;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }
    public void setDutyTime(Long dutyTime) 
    {
        this.dutyTime = dutyTime;
    }

    public Long getDutyTime() 
    {
        return dutyTime;
    }
    public void setDuringTime(String duringTime) 
    {
        this.duringTime = duringTime;
    }

    public String getDuringTime() 
    {
        return duringTime;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dutyId", getDutyId())
            .append("docId", getDocId())
            .append("orderNum", getOrderNum())
            .append("dutyTime", getDutyTime())
            .append("duringTime", getDuringTime())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
                .append("hosDoc",getHosDoc())
            .toString();
    }
}
