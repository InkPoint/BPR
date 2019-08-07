package com.ruoyi.web.controller.vehicle;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.vehicle.domain.SysCarDespatch;
import com.ruoyi.vehicle.service.ISysCarDespatchService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆发运
 * @date 2019/08/02 14:33
 */
@Controller
@RequestMapping("/vehicle/cardespatch")
public class SysCarDespatchController extends BaseController {

    private String prefix = "vehicle/cardespatch";

    @Autowired
    private ISysCarDespatchService carDespatchService;

    @RequiresPermissions("vehicle:cardespatch:view")
    @GetMapping()
    public String carDespatch() {
        return prefix + "/cardespatch";
    }

    @RequiresPermissions("vehicle:cardespatch:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCarDespatch carDespatch) {
        startPage();
        List<SysCarDespatch> list = carDespatchService.selectCarDespatchList(carDespatch);
        return getDataTable(list);
    }

    /**
     * 新增页(含合同编号_下拉菜单)
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("pactList", carDespatchService.selectPactMenu());
        return prefix + "/add";
    }

    @RequiresPermissions("vehicle:cardespatch:add")
    @Log(title = "车辆发运", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysCarDespatch carDespatch) {
        carDespatch.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(carDespatchService.insertCarDespatch(carDespatch));
    }

    /**
     * 编辑页
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String despatchCode, ModelMap mmap) {
        mmap.put("pactList", carDespatchService.selectPactMenu());
        mmap.put("despatchList", carDespatchService.selectCarDespatchById(despatchCode));
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆发运信息
     */
    @Log(title = "车辆发运", businessType = BusinessType.UPDATE)
    @RequiresPermissions("vehicle:cardespatch:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysCarDespatch carDespatch) {
        carDespatch.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(carDespatchService.updateCarDespatch(carDespatch));
    }

    /**
     * 根据车辆发运编号进行删除操作
     *
     * @param ids
     * @return
     */
    @Log(title = "车辆发运", businessType = BusinessType.DELETE)
    @RequiresPermissions("vehicle:cardespatch:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(carDespatchService.deleteCarDespatchByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

}
