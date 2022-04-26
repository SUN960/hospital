package com.ruoyi.mess.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息对象 hos_mess
 * 
 * @author ruoyi
 * @date 2022-04-18
 */
public class Message extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息id */
    private Long messId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 消息 */
    @Excel(name = "消息")
    private String message;

    /** 消息状态（0正常 1停用） */
    @Excel(name = "消息状态", readConverterExp = "0=正常,1=停用")
    private String status;

    private String userName;

    private String unreadMess;

    public String getUnreadMess() {
        return unreadMess;
    }

    public void setUnreadMess(String unreadMess) {
        this.unreadMess = unreadMess;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setMessId(Long messId)
    {
        this.messId = messId;
    }

    public Long getMessId() 
    {
        return messId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
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
            .append("messId", getMessId())
            .append("userId", getUserId())
            .append("message", getMessage())
            .append("status", getStatus())
                .append("userName",getUserName())
                .append("unreadMess",getUnreadMess())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
