package com.ruoyi.web.controller.contractmanage;

import com.ruoyi.bpr.domain.ContractManage;
import com.ruoyi.bpr.service.IContractEntryService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contractmanage/contractentry")
public class ContractEntryController extends BaseController {

    private String prefix = "contractmanage/contractentry";

    @Autowired
    private IContractEntryService contractEntryService;

    @RequiresPermissions("contractmanage:contractentry:view")
    @GetMapping()
    public String contractEntry() {
        return prefix + "/contractentry";
    }

    @RequiresPermissions("contractmanage:contractentry:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ContractManage contractManage) {
        startPage();
        List<ContractManage> list = contractEntryService.selectContractList(contractManage);
        return getDataTable(list);
    }

    @Log(title = "操作合同一览表", businessType = BusinessType.EXPORT)
    @RequiresPermissions("contractmanage:contractentry:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ContractManage contractManage) {
        List<ContractManage> list = contractEntryService.selectContractList(contractManage);
        ExcelUtil<ContractManage> util = new ExcelUtil<ContractManage>(ContractManage.class);
        return util.exportExcel(list, "合同一览表");
    }

    /**
     * 新增合同
     * @return
     */
    @GetMapping("/add")
    public String addContract() {
        return prefix + "/add";
    }

    /**
     * 新增保存合同
     */
    @RequiresPermissions("contractmanage:contractentry:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ContractManage contractManage){
         contractManage.setCjr(ShiroUtils.getLoginName());
         return toAjax(contractEntryService.insertContract(contractManage));
    }

    /**
     * 删除
     */
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("basics:client:remove")
    @PostMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Integer id){
        return toAjax(contractEntryService.delContract(id));
    }

    /**
     * 校验合同编号是否唯一
     */
    @PostMapping("/checkHtbhUnique")
    @ResponseBody
    public String checkHtbhUnique(ContractManage contractManage)
    {
        return contractEntryService.checkHtbhUnique(contractManage.getHtbh());
    }




}

