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
import com.ruoyi.project.hospital.domain.HosDuty;
import com.ruoyi.project.hospital.service.IHosDutyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 值班Controller
 * 
 * @author hospital
 * @date 2022-01-28
 */
@RestController
@RequestMapping("/hospital/duty")
public class HosDutyController extends BaseController
{
    @Autowired
    private IHosDutyService hosDutyService;

    /**
     * 查询值班列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:list')")
    @GetMapping("/list")
    public TableDataInfo list(HosDuty hosDuty)
    {
        startPage();
        List<HosDuty> list = hosDutyService.selectHosDutyList(hosDuty);
        return getDataTable(list);
    }

    /**
     * 导出值班列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:export')")
    @Log(title = "值班", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HosDuty hosDuty)
    {
        List<HosDuty> list = hosDutyService.selectHosDutyList(hosDuty);
        ExcelUtil<HosDuty> util = new ExcelUtil<HosDuty>(HosDuty.class);
        return util.exportExcel(list, "duty");
    }

    /**
     * 获取值班详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:query')")
    @GetMapping(value = "/{dutyId}")
    public AjaxResult getInfo(@PathVariable("dutyId") Long dutyId)
    {
        return AjaxResult.success(hosDutyService.selectHosDutyById(dutyId));
    }

    /**
     * 新增值班
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:add')")
    @Log(title = "值班", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HosDuty hosDuty)
    {
        return toAjax(hosDutyService.insertHosDuty(hosDuty));
    }

    /**
     * 修改值班
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:edit')")
    @Log(title = "值班", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HosDuty hosDuty)
    {
        return toAjax(hosDutyService.updateHosDuty(hosDuty));
    }

    /**
     * 删除值班
     */
    @PreAuthorize("@ss.hasPermi('hospital:duty:remove')")
    @Log(title = "值班", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dutyIds}")
    public AjaxResult remove(@PathVariable Long[] dutyIds)
    {
        return toAjax(hosDutyService.deleteHosDutyByIds(dutyIds));
    }
}
