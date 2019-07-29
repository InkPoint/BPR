package com.ruoyi.web.controller.salesManagement;

import com.ruoyi.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/salesManagement")
public class SysAnnualSalesController extends BaseController {
    private String prefix = "salesManagement";

    /**
     * 年度销售明细
     */
    @RequiresPermissions("salesManagement:yearSalesDetail:view")
    @GetMapping("/yearSalesDetail")
    public String yearSalesDetail() {
        return prefix + "/yearsalesdetail/yearSalesDetails";
    }
    /**
     * 月度业务明细
     * @return
     */
    @RequiresPermissions("salesManagement:monthBusinessDetail:view")
    @GetMapping("/monthBusinessDetail")
    public String monthDetails() {
        return prefix + "/monthbusinessdetail/businessDetails";
    }
    /**
     * 欠款详情
     * @return
     */
    @RequiresPermissions("salesManagement:debtsDetail:view")
    @GetMapping("/debtsDetail")
    public String debtsDetail() {
        return prefix + "/debtsdetail/debtsDetails";
    }
    /**
     * 销售台账
     * @return
     */
    @RequiresPermissions("salesManagement:salesAccount:view")
    @GetMapping("/salesAccount")

    public String salesAccount() {
        return prefix + "/salesAccount/salesAccount";
    }
}

