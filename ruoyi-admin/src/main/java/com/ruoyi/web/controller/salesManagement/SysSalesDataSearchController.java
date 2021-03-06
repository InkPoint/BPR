package com.ruoyi.web.controller.salesManagement;

import com.ruoyi.bpr.domain.ContractManage;
import com.ruoyi.bpr.domain.SalesAccountData;
import com.ruoyi.bpr.service.ISalesDataService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/salesManagement/salesAccount")
public class SysSalesDataSearchController extends BaseController {
    String prefix = "salesManagement/salesAccount";
    @Autowired
    ISalesDataService salesDataService;

    /**
     * 查找数据
     *
     * @param contractManage
     * @return
     */
    @RequiresPermissions("salesManagement:salesAccount:list")
    @ResponseBody
    @RequestMapping("/list")
    public TableDataInfo list(ContractManage contractManage) {
        startPage();  // 此方法配合前端完成自动分页
        List<SalesAccountData> list = salesDataService.searchSalesDataList(contractManage);
        return getDataTable(list);
    }

    /**
     * 导出
     *
     * @return
     */
    @Log(title = "合同金额", businessType = BusinessType.EXPORT)
    @RequiresPermissions("salesManagement:salesAccount:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export() {
        List<SalesAccountData> list = salesDataService.selectExportList();
        ExcelUtil<SalesAccountData> util = new ExcelUtil<>(SalesAccountData.class);
        return util.exportExcel(list, "合同已收金额明细");
    }

    /**
     * 进入增加页面
     *
     * @return
     */

    @GetMapping("/add")
    public String add(Model model) {
        List<SalesAccountData> salesData = salesDataService.selectCustomer();
        model.addAttribute("salesData", salesData);
        return prefix + "/add";
    }

    /**
     * 新增收款
     *
     * @param salesAccountData
     * @return
     */
    @Log(title = "新增收款", businessType = BusinessType.INSERT)
    @RequiresPermissions("salesManagement:salesAccount:add")
    @ResponseBody
    @RequestMapping("/add")
    public AjaxResult addSave(SalesAccountData salesAccountData) {
        Date date = new Date();
        salesAccountData.setIsDelete("N");
        salesAccountData.setCreatedUser(ShiroUtils.getLoginName());
        salesAccountData.setModifiedUser(ShiroUtils.getLoginName());
        salesAccountData.setCreatedTime(date);
        salesAccountData.setModifiedTime(date);
        return toAjax(salesDataService.addAccount(salesAccountData));
    }

    /**
     * 详细
     *
     * @param contractNumber
     * @param mmap
     * @return
     */

    @RequiresPermissions("salesManagement:salesAccount:detail")
    @GetMapping("/detail/{contractNumber}")
    public String detail(@PathVariable("contractNumber") String contractNumber, ModelMap mmap) {
        List list = salesDataService.selectSalesDataByContractNumber(contractNumber);
        if (list != null) {
            mmap.put("moneyInList", list);
        }
        return prefix + "/detail";
    }

    /**
     * 根据客户代号查找合同编号
     *
     * @param clientCode
     * @return
     */
    @RequestMapping("selectContractNumbersByCustomer")
    @ResponseBody
    public AjaxResult selectContractNumbersByCustomer(Integer clientCode) {
        List<String> contractNumbers = salesDataService.selectContractNumber(clientCode);
        return AjaxResult.success(contractNumbers);
    }

    /**
     * 根据客户代号查找可分配余额
     *
     * @param clientCode
     * @return
     */
    @RequestMapping("selectAllocatedMoneyByCustomer")
    @ResponseBody
    public AjaxResult selectAllocatedMoneyByCustomer(Integer clientCode) {
        Double allocatedMoney = salesDataService.selectAllocatedMoney(clientCode);
        return  AjaxResult.success(allocatedMoney);
        // return new ResponseResult<Double>(200,allocatedMoney);
    }

    /**
     * 删除
     *
     * @param contractNumber
     * @return
     */
    @Log(title = "删除台账", businessType = BusinessType.DELETE)
    @RequiresPermissions("salesManagement:salesAccount:remove")
    @PostMapping("/remove/{contractNumber}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("contractNumber") String contractNumber) {
        String modifiedUser = ShiroUtils.getLoginName();
        Date modifiedTime = new Date();
        return toAjax(salesDataService.deleteAccountInfo(contractNumber, modifiedUser, modifiedTime));
    }


}
