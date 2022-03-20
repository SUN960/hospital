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
import com.ruoyi.hospital.domain.HosInfo;
import com.ruoyi.hospital.service.IHosInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约信息Controller
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@RestController
@RequestMapping("/hospital/info")
public class HosInfoController extends BaseController
{
    @Autowired
    private IHosInfoService hosInfoService;

    /**
     * 查询预约信息列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(HosInfo hosInfo)
    {
        startPage();
        List<HosInfo> list = hosInfoService.selectHosInfoList(hosInfo);
        return getDataTable(list);
    }

    /**
     * 导出预约信息列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:info:export')")
    @Log(title = "预约信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HosInfo hosInfo)
    {
        List<HosInfo> list = hosInfoService.selectHosInfoList(hosInfo);
        ExcelUtil<HosInfo> util = new ExcelUtil<HosInfo>(HosInfo.class);
        util.exportExcel(response, list, "预约信息数据");
    }

    /**
     * 获取预约信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:info:query')")
    @GetMapping(value = "/{appointId}")
    public AjaxResult getInfo(@PathVariable("appointId") Long appointId)
    {
        return AjaxResult.success(hosInfoService.selectHosInfoByAppointId(appointId));
    }

    /**
     * 新增预约信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:info:add')")
    @Log(title = "预约信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HosInfo hosInfo)
    {
        return toAjax(hosInfoService.insertHosInfo(hosInfo));
    }

    /**
     * 修改预约信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:info:edit')")
    @Log(title = "预约信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HosInfo hosInfo)
    {
        return toAjax(hosInfoService.updateHosInfo(hosInfo));
    }

    /**
     * 删除预约信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:info:remove')")
    @Log(title = "预约信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{appointIds}")
    public AjaxResult remove(@PathVariable Long[] appointIds)
    {
        return toAjax(hosInfoService.deleteHosInfoByAppointIds(appointIds));
    }
}
