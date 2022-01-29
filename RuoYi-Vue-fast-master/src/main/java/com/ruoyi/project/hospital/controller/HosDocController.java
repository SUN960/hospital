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
import com.ruoyi.project.hospital.domain.HosDoc;
import com.ruoyi.project.hospital.service.IHosDocService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 医生Controller
 * 
 * @author hospital
 * @date 2022-01-28
 */
@RestController
@RequestMapping("/hospital/doc")
public class HosDocController extends BaseController
{
    @Autowired
    private IHosDocService hosDocService;

    /**
     * 查询医生列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:doc:list')")
    @GetMapping("/list")
    public TableDataInfo list(HosDoc hosDoc)
    {
        startPage();
        List<HosDoc> list = hosDocService.selectHosDocList(hosDoc);
        return getDataTable(list);
    }

    /**
     * 导出医生列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:doc:export')")
    @Log(title = "医生", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HosDoc hosDoc)
    {
        List<HosDoc> list = hosDocService.selectHosDocList(hosDoc);
        ExcelUtil<HosDoc> util = new ExcelUtil<HosDoc>(HosDoc.class);
        return util.exportExcel(list, "doc");
    }

    /**
     * 获取医生详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:doc:query')")
    @GetMapping(value = "/{docId}")
    public AjaxResult getInfo(@PathVariable("docId") Long docId)
    {
        return AjaxResult.success(hosDocService.selectHosDocById(docId));
    }

    /**
     * 新增医生
     */
    @PreAuthorize("@ss.hasPermi('hospital:doc:add')")
    @Log(title = "医生", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HosDoc hosDoc)
    {
        return toAjax(hosDocService.insertHosDoc(hosDoc));
    }

    /**
     * 修改医生
     */
    @PreAuthorize("@ss.hasPermi('hospital:doc:edit')")
    @Log(title = "医生", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HosDoc hosDoc)
    {
        return toAjax(hosDocService.updateHosDoc(hosDoc));
    }

    /**
     * 删除医生
     */
    @PreAuthorize("@ss.hasPermi('hospital:doc:remove')")
    @Log(title = "医生", businessType = BusinessType.DELETE)
	@DeleteMapping("/{docIds}")
    public AjaxResult remove(@PathVariable Long[] docIds)
    {
        return toAjax(hosDocService.deleteHosDocByIds(docIds));
    }
}
