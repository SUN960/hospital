package com.ruoyi.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预约信息对象 hos_info
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public class HosInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预约编号 */
    private Long appointId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private Long userId;

    /** 医生id */
    @Excel(name = "医生id")
    private Long docId;

    /** 病情 */
    @Excel(name = "病情")
    private String illSituation;

    /** 日期 */
    @Excel(name = "日期")
    private String dateTime;

    /** 挂号号码 */
    @Excel(name = "挂号号码")
    private Long number;

    /** 状态（0未支付 1待就诊 2已完成） */
    @Excel(name = "状态", readConverterExp = "0=未支付,1=待就诊,2=已完成")
    private String status;

    /** 值班id */
    private String dutyId;

    /** 结束时间 */
    private String endTime;

    private HosDoc hosDoc;

    public HosDoc getHosDoc() {
        return hosDoc;
    }

    public void setHosDoc(HosDoc hosDoc) {
        this.hosDoc = hosDoc;
    }

    public void setAppointId(Long appointId)
    {
        this.appointId = appointId;
    }

    public Long getAppointId() 
    {
        return appointId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDocId(Long docId) 
    {
        this.docId = docId;
    }

    public Long getDocId() 
    {
        return docId;
    }
    public void setIllSituation(String illSituation) 
    {
        this.illSituation = illSituation;
    }

    public String getIllSituation() 
    {
        return illSituation;
    }
    public void setDateTime(String dateTime) 
    {
        this.dateTime = dateTime;
    }

    public String getDateTime() 
    {
        return dateTime;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
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
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("appointId", getAppointId())
            .append("userId", getUserId())
            .append("docId", getDocId())
            .append("illSituation", getIllSituation())
            .append("dateTime", getDateTime())
            .append("number", getNumber())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dutyId", getDutyId())
            .append("endTime", getEndTime())
                .append("hosDoc",getHosDoc())
            .toString();
    }
}
