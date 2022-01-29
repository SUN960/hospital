package com.ruoyi.project.hospital.domain;

import java.util.Calendar;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 医生对象 hos_doc
 * 
 * @author hospital
 * @date 2022-01-28
 */
public class HosDoc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工作证号 */
    private Long docId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String docName;

    /** 用户性别（0男 1女 2未知） */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthTime;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long adoId;

    private HosAdo hosAdo;
    /** 显示顺序 */
    private Long orderNum;

    /** 部门状态（0正常 1停用） */
    @Excel(name = "部门状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setHosAdo(HosAdo hosAdo) {
        this.hosAdo = hosAdo;
    }

    public HosAdo getHosAdo() {
        return hosAdo;
    }

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
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setBirthTime(Date birthTime) 
    {
        this.birthTime = birthTime;
    }

    public Date getBirthTime() 
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

//    public  int setAge(Date birthDay) throws Exception {
//        Calendar cal = Calendar.getInstance();
//        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
//            throw new IllegalArgumentException(
//                    "The birthDay is before Now.It's unbelievable!");
//        }
//        int yearNow = cal.get(Calendar.YEAR);  //当前年份
//        int monthNow = cal.get(Calendar.MONTH);  //当前月份
//        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
//        cal.setTime(birthDay);
//        int yearBirth = cal.get(Calendar.YEAR);
//        int monthBirth = cal.get(Calendar.MONTH);
//        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
//        int age = yearNow - yearBirth;   //计算整岁数
//        if (monthNow <= monthBirth) {
//            if (monthNow == monthBirth) {
//                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
//            }else{
//                age--;//当前月份在生日之前，年龄减一
//            } } return age; }
//    private int  age = setAge(getBirthTime());
//    public  int getAge(){
//        return  age;
//    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("docId", getDocId())
            .append("docName", getDocName())
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
//                .append("age",getAge())
            .toString();
    }
}
