package com.ruoyi.project.hospital.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 预约信息对象 hos_info
 * 
 * @author hospital
 * @date 2022-01-28
 */
public class HosInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预约编号 */
    private Long appointId;

    /** 账号 */
    @Excel(name = "账号")
    private Long userId;

    /** 医生id */
    @Excel(name = "医生id")
    private Long docId;

    /** 病情 */
    @Excel(name = "病情")
    private String illSituation;

    /** 开始时间  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

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
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime1()
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
            .append("appointId", getAppointId())
            .append("userId", getUserId())
            .append("docId", getDocId())
            .append("illSituation", getIllSituation())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime1())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
