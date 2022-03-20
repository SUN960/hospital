package com.ruoyi.web.controller.hospital;

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
import com.ruoyi.hospital.domain.HosUser;
import com.ruoyi.hospital.service.IHosUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户信息Controller
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@RestController
@RequestMapping("/hospital/user")
public class HosUserController extends BaseController
{
    @Autowired
    private IHosUserService hosUserService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(HosUser hosUser)
    {
        startPage();
        List<HosUser> list = hosUserService.selectHosUserList(hosUser);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:user:export')")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HosUser hosUser)
    {
        List<HosUser> list = hosUserService.selectHosUserList(hosUser);
        ExcelUtil<HosUser> util = new ExcelUtil<HosUser>(HosUser.class);
        util.exportExcel(response, list, "用户信息数据");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(hosUserService.selectHosUserByUserId(userId));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:user:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HosUser hosUser)
    {
        return toAjax(hosUserService.insertHosUser(hosUser));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:user:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HosUser hosUser)
    {
        return toAjax(hosUserService.updateHosUser(hosUser));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:user:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(hosUserService.deleteHosUserByUserIds(userIds));
    }
}
