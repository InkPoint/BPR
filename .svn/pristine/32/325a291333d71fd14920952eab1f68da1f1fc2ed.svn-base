package com.ruoyi.web.controller.salesManagement;

import com.ruoyi.bpr.domain.ContractManage;
import com.ruoyi.bpr.domain.SalesAccountData;
import com.ruoyi.bpr.service.ISalesDataService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
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
     * 进入增加页面
     *
     * @return
     */

    @GetMapping("/add")
    public String add() {

       // model.addAttribute("contractNumber", contractNumber);
        return prefix + "/add";
    }

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

    @RequiresPermissions("salesManagement:salesAccount:detail")
    @GetMapping("/detail/{contractNumber}")
    public String detail(@PathVariable("contractNumber") String contractNumber, ModelMap mmap)
    {
        mmap.put("moneyInList",salesDataService.selectSalesDataByContractNumber(contractNumber) );
        return prefix + "/detail";
    }
}
