package com.ruoyi.web.controller.fundmanage;

import com.ruoyi.bpr.domain.FundManage;
import com.ruoyi.bpr.service.IFundManageService;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fundmanage/recievefund")
public class RecieveFundController extends BaseController {

    @Autowired
    private IFundManageService fundManageService;

    private String prefix = "fundmanage/recievefund";

    /**
     * 已收账款页
     *
     * @return
     */
    @RequiresPermissions("fundmanage:recievefund:view")
    @GetMapping()
    public String recieveFund() {
        return prefix + "/recievefund";
    }


    /**
     * 已收账款汇总查询
     *
     * @param fundManage
     * @return
     */
    @RequiresPermissions("fundmanage:recievefund:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FundManage fundManage) {
        startPage();
        List list = fundManageService.selectFundManage(fundManage);
        return getDataTable(list);
    }

    /**
     * 已收账款子级查询
     *
     * @param fundManage
     * @return
     */
    @GetMapping("/detaillist")
    @ResponseBody
    public TableDataInfo detaillist(FundManage fundManage) {
        startPage();
        List<FundManage> list = fundManageService.selectFundManageList(fundManage);
        return getDataTable(list);
    }

    /**
     * 新增页
     *
     * @return
     */
    @GetMapping("/add")
    public String addRecievedFund(ModelMap mmap) {
        mmap.put("clientList", fundManageService.selectClientMenu());
        return prefix + "/add";
    }

    /**
     * 修改页 根据已收账款回填账款信息
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("clientList", fundManageService.selectClientMenu());
        mmap.put("fund", fundManageService.selectFundById(id));
        return prefix + "/edit";
    }

    /**
     * 保存修改后的已收账款
     *
     * @param fundManage
     * @return
     */
    @Log(title = "已收账款", businessType = BusinessType.UPDATE)
    @RequiresPermissions("fundmanage:recievefund:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FundManage fundManage) {
        fundManage.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(fundManageService.updateFundInfo(fundManage));
    }

    /**
     * 新增已收账款
     *
     * @param fundManage
     * @return
     */
    @RequiresPermissions("fundmanage:recievefund:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addsave(FundManage fundManage) {
        fundManage.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(fundManageService.insertFund(fundManage));
    }

    /**
     * 导出已收账款
     *
     * @param fundManage
     * @return
     */
    @Log(title = "已收账款", businessType = BusinessType.EXPORT)
    @RequiresPermissions("fundmanage:recievefund:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FundManage fundManage) {
        List<FundManage> list = fundManageService.selectFundManageList(fundManage);
        ExcelUtil<FundManage> util = new ExcelUtil<>(FundManage.class);
        return util.exportExcel(list, "已收账款");
    }

    /**
     * 根据已收账款ID进行删除操作
     *
     * @param fundManage
     * @return
     */
    @Log(title = "已收账款", businessType = BusinessType.EXPORT)
    @RequiresPermissions("fundmanage:recievefund:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(FundManage fundManage) {
        fundManage.setUpdateBy(ShiroUtils.getLoginName());
        try {
            return toAjax(fundManageService.deleteFundByIds(fundManage));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

}
