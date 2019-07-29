package com.ruoyi.web.controller.basics;

import com.ruoyi.bpr.domain.ClientManage;
import com.ruoyi.bpr.service.IClientManageService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basics/client")
public class ClientController extends BaseController {

    private String prefix = "basics/client";

    @Autowired
    private IClientManageService clientManageService;

    @RequiresPermissions("basics:client:view")
    @GetMapping()
    public String client() {
        return prefix + "/client";
    }

    @RequiresPermissions("basics:client:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClientManage clientManage){
        startPage();
        List<ClientManage> list = clientManageService.selectClientList(clientManage);
        return getDataTable(list);
    }

    @Log(title = "客户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("basics:client:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClientManage clientManage){
        List<ClientManage> list = clientManageService.selectClientList(clientManage);
        ExcelUtil<ClientManage> util = new ExcelUtil<ClientManage>(ClientManage.class);
        return util.exportExcel(list, "客户数据");
    }

    /**
     * 新增客户
     * @return
     */
    @GetMapping("/add")
    public String addClient() {
        return prefix + "/add";
    }

    /**
     * 新增保存客户
     * @param clientManage 客户数据
     * @return 结果
     */
    @RequiresPermissions("basics:client:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addsave(ClientManage clientManage){
        clientManage.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(clientManageService.insertClient(clientManage));
    }

    /**
     * 修改客户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        ClientManage client = clientManageService.selectClientById(id);
        mmap.put("client",client);
        return prefix + "/edit";
    }

    /**
     * 保存修改客户
     */
    @Log(title = "客户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("basics:client:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClientManage clientManage) {
        clientManage.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(clientManageService.updateClient(clientManage));
    }

    /**
     * 删除
     */
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("basics:client:remove")
    @PostMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Integer id){
        return toAjax(clientManageService.deleteClientById(id));
    }


    /**
     * 客户状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("basics:client:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(ClientManage clientManage)
    {
        return toAjax(clientManageService.changeStatus(clientManage));
    }

}
