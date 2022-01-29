package com.ruoyi.project.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 值班对象 hos_duty
 * 
 * @author hospital
 * @date 2022-01-28
 */
public class HosDuty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 值班编号 */
    private Long dutyId;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long adoId;

    /** 医生ID */
    @Excel(name = "医生ID")
    private Long docId;

    /** 显示顺序 */
    private Long orderNum;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 值班日期 */
    @Excel(name = "值班日期")
    private Long dutyTime;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String beginTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

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
    public void setAdoId(Long adoId) 
    {
        this.adoId = adoId;
    }

    public Long getAdoId() 
    {
        return adoId;
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
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setDutyTime(Long dutyTime) 
    {
        this.dutyTime = dutyTime;
    }

    public Long getDutyTime() 
    {
        return dutyTime;
    }
    public void setBeginTime(String beginTime) 
    {
        this.beginTime = beginTime;
    }

    public String getBeginTime() 
    {
        return beginTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
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
            .append("adoId", getAdoId())
            .append("docId", getDocId())
            .append("orderNum", getOrderNum())
            .append("phone", getPhone())
            .append("dutyTime", getDutyTime())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
