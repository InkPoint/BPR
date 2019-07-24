package com.ruoyi.web.controller.vehicle;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.vehicle.domain.SysVehicleDetails;
import com.ruoyi.vehicle.service.ISysVehicleDetailsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆详情
 * @date 2019/6/26 9:33
 */
@Controller
@RequestMapping("/vehicle/vehicledetails")
public class SysVehicleDetailsController extends BaseController {

    private String prefix = "vehicle/vehicledetails";

    @Autowired
    private ISysVehicleDetailsService vehicleDetailsService;

    @RequiresPermissions("vehicle:vehicledetails:view")
    @GetMapping()
    public String vehicledetails() {
        return prefix + "/vehicledetails";
    }

    @RequiresPermissions("vehicle:vehicledetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysVehicleDetails vehicleDetails) {
        startPage();
        List<SysVehicleDetails> list = vehicleDetailsService.selectVehicleDetailsList(vehicleDetails);
        return getDataTable(list);
    }

    @Log(title = "车辆详情", businessType = BusinessType.EXPORT)
    @RequiresPermissions("vehicle:vehicledetails:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysVehicleDetails vehicleDetails) {
        List<SysVehicleDetails> list = vehicleDetailsService.selectVehicleDetailsList(vehicleDetails);
        ExcelUtil<SysVehicleDetails> util = new ExcelUtil<SysVehicleDetails>(SysVehicleDetails.class);
        return util.exportExcel(list, "车辆详情");
    }

}
