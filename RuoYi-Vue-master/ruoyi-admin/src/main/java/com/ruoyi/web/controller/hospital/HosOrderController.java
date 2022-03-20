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
import com.ruoyi.hospital.domain.HosOrder;
import com.ruoyi.hospital.service.IHosOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约订单Controller
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@RestController
@RequestMapping("/hospital/order")
public class HosOrderController extends BaseController
{
    @Autowired
    private IHosOrderService hosOrderService;

    /**
     * 查询预约订单列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(HosOrder hosOrder)
    {
        startPage();
        List<HosOrder> list = hosOrderService.selectHosOrderList(hosOrder);
        return getDataTable(list);
    }

    /**
     * 导出预约订单列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:order:export')")
    @Log(title = "预约订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HosOrder hosOrder)
    {
        List<HosOrder> list = hosOrderService.selectHosOrderList(hosOrder);
        ExcelUtil<HosOrder> util = new ExcelUtil<HosOrder>(HosOrder.class);
        util.exportExcel(response, list, "预约订单数据");
    }

    /**
     * 获取预约订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(hosOrderService.selectHosOrderByOrderId(orderId));
    }

    /**
     * 新增预约订单
     */
    @PreAuthorize("@ss.hasPermi('hospital:order:add')")
    @Log(title = "预约订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HosOrder hosOrder)
    {
        return toAjax(hosOrderService.insertHosOrder(hosOrder));
    }

    /**
     * 修改预约订单
     */
    @PreAuthorize("@ss.hasPermi('hospital:order:edit')")
    @Log(title = "预约订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HosOrder hosOrder)
    {
        return toAjax(hosOrderService.updateHosOrder(hosOrder));
    }

    /**
     * 删除预约订单
     */
    @PreAuthorize("@ss.hasPermi('hospital:order:remove')")
    @Log(title = "预约订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(hosOrderService.deleteHosOrderByOrderIds(orderIds));
    }
}
