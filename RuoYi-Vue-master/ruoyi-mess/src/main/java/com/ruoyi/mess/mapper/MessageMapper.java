package com.ruoyi.mess.mapper;

import java.util.List;
import com.ruoyi.mess.domain.Message;
import org.springframework.stereotype.Repository;

/**
 * 消息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-18
 */
@Repository
public interface MessageMapper 
{
    /**
     * 查询消息
     * 
     * @param messId 消息主键
     * @return 消息
     */
    public Message selectMessageByMessId(Long messId);

    /**
     * 查询消息列表
     * 
     * @param message 消息
     * @return 消息集合
     */
    public List<Message> selectMessageList(Message message);

    List<Message> selectAllUser();
    /**
     * 新增消息
     * 
     * @param message 消息
     * @return 结果
     */
    public int insertMessage(Message message);

    /**
     * 修改消息
     * 
     * @param message 消息
     * @return 结果
     */
    public int updateMessage(Message message);

    /**
     * 删除消息
     * 
     * @param messId 消息主键
     * @return 结果
     */
    public int deleteMessageByMessId(Long messId);

    /**
     * 批量删除消息
     * 
     * @param messIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageByMessIds(Long[] messIds);
}
