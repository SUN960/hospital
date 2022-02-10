package com.ruoyi.project.hospital.controller;

import java.util.List;
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
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.hospital.domain.HosUser;
import com.ruoyi.project.hospital.service.IHosUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户信息Controller
 *
 * @author ss
 * @date 2022-02-09
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
    @GetMapping("/export")
    public AjaxResult export(HosUser hosUser)
    {
        List<HosUser> list = hosUserService.selectHosUserList(hosUser);
        ExcelUtil<HosUser> util = new ExcelUtil<HosUser>(HosUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(hosUserService.selectHosUserById(userId));
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
        return toAjax(hosUserService.deleteHosUserByIds(userIds));
    }
}
