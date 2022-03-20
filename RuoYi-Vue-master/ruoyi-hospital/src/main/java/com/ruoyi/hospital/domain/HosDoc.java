package com.ruoyi.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医生对象 hos_doc
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public class HosDoc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工作证号 */
    private Long docId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String docName;

    /** 图像地址 */
    private String avatar;

    /** 职称 */
    @Excel(name = "职称")
    private String prot;

    /** 用户性别（0男 1女 2未知） */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birthTime;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long adoId;

    /** 显示顺序 */
    private Long orderNum;

    private HosAdo hosAdo;

    public HosAdo getHosAdo() {
        return hosAdo;
    }

    public void setHosAdo(HosAdo hosAdo) {
        this.hosAdo = hosAdo;
    }

    /** 医生状态（0正常 1停用） */
    @Excel(name = "医生状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setDocId(Long docId) 
    {
        this.docId = docId;
    }

    public Long getDocId() 
    {
        return docId;
    }
    public void setDocName(String docName) 
    {
        this.docName = docName;
    }

    public String getDocName() 
    {
        return docName;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setProt(String prot) 
    {
        this.prot = prot;
    }

    public String getProt() 
    {
        return prot;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setBirthTime(String birthTime) 
    {
        this.birthTime = birthTime;
    }

    public String getBirthTime() 
    {
        return birthTime;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setAdoId(Long adoId) 
    {
        this.adoId = adoId;
    }

    public Long getAdoId() 
    {
        return adoId;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
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
            .append("docId", getDocId())
            .append("docName", getDocName())
            .append("avatar", getAvatar())
            .append("prot", getProt())
            .append("sex", getSex())
            .append("birthTime", getBirthTime())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("adoId", getAdoId())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
                .append("hosAdo",getHosAdo())
            .toString();
    }
}
