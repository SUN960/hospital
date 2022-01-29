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

    @Excel(name="日期")
    private String dateTime;

    /** 开始时间  */

    @Excel(name = "开始时间 ")
    private String startTime;

    /** 结束时间 */

    @Excel(name = "结束时间")
    private String endTime;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    private HosDoc hosDoc;

    public void setHosDoc(HosDoc hosDoc) {
        this.hosDoc = hosDoc;
    }

    public HosDoc getHosDoc() {
        return hosDoc;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
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
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getStartTime()
    {
        return startTime;
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
            .append("appointId", getAppointId())
            .append("userId", getUserId())
            .append("docId", getDocId())
            .append("illSituation", getIllSituation())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
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
