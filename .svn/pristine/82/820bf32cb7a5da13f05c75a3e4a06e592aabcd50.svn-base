package com.ruoyi.web.controller.basics;

import com.ruoyi.bpr.domain.SysDealer;
import com.ruoyi.bpr.service.ISysDealerService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysRole;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 经销商信息
 * @date 2019/07/04 9:37
 */
@Controller
@RequestMapping("/basics/dealer")
public class SysDealerController extends BaseController {
    private String prefix = "basics/dealer";

    @Autowired
    private ISysDealerService dealerService;

    @RequiresPermissions("basics:dealer:view")
    @GetMapping()
    public String dealer() {
        return prefix + "/dealer";
    }

    @RequiresPermissions("basics:dealer:list")
    @GetMapping("/list")
    @ResponseBody
    public List<SysDealer> list(SysDealer dealer) {
        List<SysDealer> dealerList = dealerService.selectDealerList(dealer);
        return dealerList;
    }

    /**
     * 新增经销商
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap) {
        mmap.put("dealer", dealerService.selectDealerById(parentId));
        return prefix + "/add";
    }

    /**
     * 新增保存经销商
     */
    @Log(title = "经销商管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("basics:dealer:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysDealer dealer) {
        dealer.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(dealerService.insertDealer(dealer));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{dealerId}")
    public String edit(@PathVariable("dealerId") Long dealerId, ModelMap mmap) {
        SysDealer dealer = dealerService.selectDealerById(dealerId);
        if (StringUtils.isNotNull(dealer) && 100L == dealerId) {
            dealer.setParentName("无");
        }
        mmap.put("dealer", dealer);
        return prefix + "/edit";
    }

    /**
     * 保存
     */
    @Log(title = "经销商管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("basics:dealer:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysDealer dealer) {
        dealer.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(dealerService.updateDealer(dealer));
    }

    /**
     * 删除
     */
    @Log(title = "经销商管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("basics:dealer:remove")
    @GetMapping("/remove/{dealerId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("dealerId") Long dealerId) {
        if (dealerService.selectDealerCount(dealerId) > 0) {
            return AjaxResult.warn("存在下级菜单,不允许删除");
        }
        if (dealerService.checkdealerExistUser(dealerId)) {
            return AjaxResult.warn("经销商存在用户,不允许删除");
        }
        return toAjax(dealerService.deleteDealerById(dealerId));
    }

    /**
     * 校验经销商名称
     */
    @PostMapping("/checkDealerNameUnique")
    @ResponseBody
    public String checkDealerNameUnique(SysDealer dealer) {
        return dealerService.checkDealerNameUnique(dealer);
    }

    /**
     * 选择经销商树
     */
    @GetMapping("/selectDealerTree/{dealerId}")
    public String selectDealerTree(@PathVariable("dealerId") Long dealerId, ModelMap mmap) {
        mmap.put("dealer", dealerService.selectDealerById(dealerId));
        return prefix + "/tree";
    }

    /**
     * 加载经销商列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = dealerService.selectDealerTree(new SysDealer());
        return ztrees;
    }

    /**
     * 加载角色经销商（数据权限）列表树
     */
    @GetMapping("/roleDealerTreeData")
    @ResponseBody
    public List<Ztree> dealerTreeData(SysRole role) {
        List<Ztree> ztrees = dealerService.roleDealerTreeData(role);
        return ztrees;
    }
}
