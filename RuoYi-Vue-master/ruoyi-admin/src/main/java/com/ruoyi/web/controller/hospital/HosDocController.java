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
import com.ruoyi.hospital.domain.HosDoc;
import com.ruoyi.hospital.service.IHosDocService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生Controller
 * 
 * @author ruoyi
 * @date 2022-03-19
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
    @PostMapping("/export")
    public void export(HttpServletResponse response, HosDoc hosDoc)
    {
        List<HosDoc> list = hosDocService.selectHosDocList(hosDoc);
        ExcelUtil<HosDoc> util = new ExcelUtil<HosDoc>(HosDoc.class);
        util.exportExcel(response, list, "医生数据");
    }

    /**
     * 获取医生详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:doc:query')")
    @GetMapping(value = "/{docId}")
    public AjaxResult getInfo(@PathVariable("docId") Long docId)
    {
        return AjaxResult.success(hosDocService.selectHosDocByDocId(docId));
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
        return toAjax(hosDocService.deleteHosDocByDocIds(docIds));
    }
}
