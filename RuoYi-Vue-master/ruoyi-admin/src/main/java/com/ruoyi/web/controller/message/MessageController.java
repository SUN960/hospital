package com.ruoyi.web.controller.message;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.mess.domain.Message;
import com.ruoyi.mess.service.IMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息Controller
 *
 * @author ruoyi
 * @date 2022-04-18
 */
@RestController
@RequestMapping("/mess/mess")
public class MessageController extends BaseController
{
    @Autowired
    private IMessageService messageService;

    /**
     * 查询消息列表
     */
    @PreAuthorize("@ss.hasPermi('mess:mess:list')")
    @GetMapping("/list")
    public TableDataInfo list(Message message)
    {
        startPage();
        List<Message> list = messageService.selectMessageList(message);
        return getDataTable(list);
    }

    /**
     * 导出消息列表
     */
    @PreAuthorize("@ss.hasPermi('mess:mess:export')")
    @Log(title = "消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Message message)
    {
        List<Message> list = messageService.selectMessageList(message);
        ExcelUtil<Message> util = new ExcelUtil<Message>(Message.class);
        util.exportExcel(response, list, "消息数据");
    }

    /**
     * 获取消息详细信息
     */
    @PreAuthorize("@ss.hasPermi('mess:mess:query')")
    @GetMapping(value = "/{messId}")
    public AjaxResult getInfo(@PathVariable("messId") Long messId)
    {
        return AjaxResult.success(messageService.selectMessageByMessId(messId));
    }

    /**
     * 新增消息
     */
    @PreAuthorize("@ss.hasPermi('mess:mess:add')")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Message message)
    {
        return toAjax(messageService.insertMessage(message));
    }

    /**
     * 修改消息
     */
    @PreAuthorize("@ss.hasPermi('mess:mess:edit')")
    @Log(title = "消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Message message)
    {
        return toAjax(messageService.updateMessage(message));
    }

    @GetMapping("/allUser")
    public TableDataInfo userList(){
        List<Message> list = messageService.selectAllUser();
        return getDataTable(list);
    }


    /**
     * 删除消息
     */
    @PreAuthorize("@ss.hasPermi('mess:mess:remove')")
    @Log(title = "消息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{messIds}")
    public AjaxResult remove(@PathVariable Long[] messIds)
    {
        return toAjax(messageService.deleteMessageByMessIds(messIds));
    }
}
