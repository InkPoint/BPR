package com.ruoyi.web.controller.vehicle;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.sql.DBUtil;
import com.ruoyi.vehicle.domain.SysRepertory;
import com.ruoyi.vehicle.service.ISysRepertoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 申请发车
 * @date 2019/07/30 8:50
 */
@Controller
@RequestMapping("/vehicle/applydepart")
public class SysApplyDepartController extends BaseController {

    private String prefix = "vehicle/applydepart";

    @Autowired
    private ISysRepertoryService repertoryService;

    @RequiresPermissions("vehicle:applydepart:view")
    @GetMapping()
    public String repertory() {
        return prefix + "/applydepart";
    }

    @RequiresPermissions("vehicle:repertory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysRepertory repertory) {
        List<SysRepertory> list = repertoryService.selectRepertoryList(repertory);
        return getDataTable(list);
    }

    @Log(title = "车辆库存", businessType = BusinessType.EXPORT)
    @RequiresPermissions("vehicle:repertory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRepertory repertory) {
        List<SysRepertory> list = repertoryService.selectRepertoryList(repertory);
        ExcelUtil<SysRepertory> util = new ExcelUtil<SysRepertory>(SysRepertory.class);
        return util.exportExcel(list, "车辆库存");
    }

}
