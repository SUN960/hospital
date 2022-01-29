package com.ruoyi.project.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 科室对象 hos_ado
 * 
 * @author sss
 * @date 2022-01-28
 */
public class HosAdo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 科室id */
    private Long adoId;

    /** 科室名称 */
    @Excel(name = "科室名称")
    private String adoName;

    /** 显示顺序 */
    private Long orderNum;

    /** 负责人 */
    @Excel(name = "负责人")
    private String leader;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 地址 */
    @Excel(name = "地址")
    private String adress;

    /** 科室状态（0正常 1停用） */
    @Excel(name = "科室状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setAdoId(Long adoId) 
    {
        this.adoId = adoId;
    }

    public Long getAdoId() 
    {
        return adoId;
    }
    public void setAdoName(String adoName) 
    {
        this.adoName = adoName;
    }

    public String getAdoName() 
    {
        return adoName;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }
    public void setLeader(String leader) 
    {
        this.leader = leader;
    }

    public String getLeader() 
    {
        return leader;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setAdress(String adress) 
    {
        this.adress = adress;
    }

    public String getAdress() 
    {
        return adress;
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
            .append("adoId", getAdoId())
            .append("adoName", getAdoName())
            .append("orderNum", getOrderNum())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("adress", getAdress())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
