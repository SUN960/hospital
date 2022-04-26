package com.ruoyi.mess.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mess.mapper.MessageMapper;
import com.ruoyi.mess.domain.Message;
import com.ruoyi.mess.service.IMessageService;

/**
 * 消息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-18
 */
@Service
public class MessageServiceImpl implements IMessageService
{
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询消息
     * 
     * @param messId 消息主键
     * @return 消息
     */
    @Override
    public Message selectMessageByMessId(Long messId)
    {
        return messageMapper.selectMessageByMessId(messId);
    }

    /**
     * 查询消息列表
     * 
     * @param message 消息
     * @return 消息
     */
    @Override
    public List<Message> selectMessageList(Message message)
    {
        return messageMapper.selectMessageList(message);
    }

    @Override
    public List<Message> selectAllUser() {
        return messageMapper.selectAllUser();
    }

    /**
     * 新增消息
     * 
     * @param message 消息
     * @return 结果
     */
    @Override
    public int insertMessage(Message message)
    {
        message.setCreateTime(DateUtils.getNowDate());
        return messageMapper.insertMessage(message);
    }

    /**
     * 修改消息
     * 
     * @param message 消息
     * @return 结果
     */
    @Override
    public int updateMessage(Message message)
    {
        message.setUpdateTime(DateUtils.getNowDate());
        return messageMapper.updateMessage(message);
    }

    /**
     * 批量删除消息
     * 
     * @param messIds 需要删除的消息主键
     * @return 结果
     */
    @Override
    public int deleteMessageByMessIds(Long[] messIds)
    {
        return messageMapper.deleteMessageByMessIds(messIds);
    }

    /**
     * 删除消息信息
     * 
     * @param messId 消息主键
     * @return 结果
     */
    @Override
    public int deleteMessageByMessId(Long messId)
    {
        return messageMapper.deleteMessageByMessId(messId);
    }
}
