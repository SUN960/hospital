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
import com.ruoyi.hospital.domain.HosAdo;
import com.ruoyi.hospital.service.IHosAdoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科室Controller
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@RestController
@RequestMapping("/hospital/ado")
public class HosAdoController extends BaseController
{
    @Autowired
    private IHosAdoService hosAdoService;

    /**
     * 查询科室列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:ado:list')")
    @GetMapping("/list")
    public TableDataInfo list(HosAdo hosAdo)
    {
        startPage();
        List<HosAdo> list = hosAdoService.selectHosAdoList(hosAdo);
        return getDataTable(list);
    }

    /**
     * 导出科室列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:ado:export')")
    @Log(title = "科室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HosAdo hosAdo)
    {
        List<HosAdo> list = hosAdoService.selectHosAdoList(hosAdo);
        ExcelUtil<HosAdo> util = new ExcelUtil<HosAdo>(HosAdo.class);
        util.exportExcel(response, list, "科室数据");
    }

    /**
     * 获取科室详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:ado:query')")
    @GetMapping(value = "/{adoId}")
    public AjaxResult getInfo(@PathVariable("adoId") Long adoId)
    {
        return AjaxResult.success(hosAdoService.selectHosAdoByAdoId(adoId));
    }

    /**
     * 新增科室
     */
    @PreAuthorize("@ss.hasPermi('hospital:ado:add')")
    @Log(title = "科室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HosAdo hosAdo)
    {
        return toAjax(hosAdoService.insertHosAdo(hosAdo));
    }

    /**
     * 修改科室
     */
    @PreAuthorize("@ss.hasPermi('hospital:ado:edit')")
    @Log(title = "科室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HosAdo hosAdo)
    {
        return toAjax(hosAdoService.updateHosAdo(hosAdo));
    }

    /**
     * 删除科室
     */
    @PreAuthorize("@ss.hasPermi('hospital:ado:remove')")
    @Log(title = "科室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{adoIds}")
    public AjaxResult remove(@PathVariable Long[] adoIds)
    {
        return toAjax(hosAdoService.deleteHosAdoByAdoIds(adoIds));
    }
}
