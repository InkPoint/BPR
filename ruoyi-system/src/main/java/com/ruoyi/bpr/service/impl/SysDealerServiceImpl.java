package com.ruoyi.bpr.service.impl;

import com.ruoyi.bpr.domain.SysDealer;
import com.ruoyi.bpr.mapper.SysDealerMapper;
import com.ruoyi.bpr.service.ISysDealerService;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 经销商管理 服务实现
 * @date 2019/7/4 10:07
 */
@Service
public class SysDealerServiceImpl implements ISysDealerService {

    @Autowired
    private SysDealerMapper dealerMapper;

    /**
     * 查询经销商管理数据
     *
     * @param dealer 部门信息
     * @return 经销商信息集合
     */
    @Override
    @DataScope(tableAlias = "d")
    public List<SysDealer> selectDealerList(SysDealer dealer) {
        return dealerMapper.selectDealerList(dealer);
    }

    /**
     * 查询经销商管理树
     *
     * @param dealer 经销航信息
     * @return 所有经销商信息
     */
    @Override
    @DataScope(tableAlias = "d")
    public List<Ztree> selectDealerTree(SysDealer dealer) {
        List<SysDealer> dealerList = dealerMapper.selectDealerList(dealer);
        List<Ztree> ztrees = initZtree(dealerList);
        return ztrees;
    }

    /**
     * 根据角色ID查询经销商（数据权限）
     *
     * @param role 角色对象
     * @return 经销商列表（数据权限）
     */
    @Override
    public List<Ztree> roleDealerTreeData(SysRole role) {
        Long roleId = role.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<SysDealer> deptList = selectDealerList(new SysDealer());
        if (StringUtils.isNotNull(roleId)) {
            List<String> roleDealerList = dealerMapper.selectRoleDealerTree(roleId);
            ztrees = initZtree(deptList, roleDealerList);
        } else {
            ztrees = initZtree(deptList);
        }
        return ztrees;
    }

    /**
     * 对象转经销商树
     *
     * @param dealerList 经销商列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysDealer> dealerList) {
        return initZtree(dealerList, null);
    }

    /**
     * 对象转经销商树
     *
     * @param dealerList     经销商列表
     * @param roleDealerList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysDealer> dealerList, List<String> roleDealerList) {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDealerList);
        for (SysDealer dealer : dealerList) {
            if (UserConstants.DEPT_NORMAL.equals(dealer.getStatus())) {
                Ztree ztree = new Ztree();
                ztree.setId(dealer.getDealerId());
                ztree.setpId(dealer.getParentId());
                ztree.setName(dealer.getDealerName());
                ztree.setTitle(dealer.getDealerName());
                if (isCheck) {
                    ztree.setChecked(roleDealerList.contains(dealer.getDealerId() + dealer.getDealerName()));
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }


    /**
     * 查询经销商人数
     *
     * @param parentId 经销商ID
     * @return 结果
     */
    @Override
    public int selectDealerCount(Long parentId) {
        SysDealer dealer = new SysDealer();
        dealer.setParentId(parentId);
        return dealerMapper.selectDealerCount(dealer);
    }

    /**
     * 查询经销商是否存在用户
     *
     * @param dealerId 经销商ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkdealerExistUser(Long dealerId) {
        int result = dealerMapper.checkDealerExistUser(dealerId);
        return result > 0 ? true : false;
    }

    /**
     * 删除经销商管理信息
     *
     * @param dealerId 经销商ID
     * @return 结果
     */
    @Override
    public int deleteDealerById(Long dealerId) {
        return dealerMapper.deleteDealerById(dealerId);
    }

    /**
     * 新增保存经销商信息
     *
     * @param dealer 经销商信息
     * @return 结果
     */
    @Override
    public int insertDealer(SysDealer dealer) {
        SysDealer info = dealerMapper.selectDealerById(dealer.getParentId());
        // 如果父节点不为"正常"状态,则不允许新增子节点
        if (!UserConstants.DEPT_NORMAL.equals(info.getStatus())) {
            throw new BusinessException("已停用，不允许新增");
        }
        dealer.setAncestors(info.getAncestors() + "," + dealer.getParentId());
        return dealerMapper.insertDealer(dealer);
    }

    /**
     * 修改保存经销商信息
     *
     * @param dealer 经销商信息
     * @return 结果
     */
    @Override
    public int updateDealer(SysDealer dealer) {
        SysDealer newParentDealer = dealerMapper.selectDealerById(dealer.getParentId());
        SysDealer oldDealer = selectDealerById(dealer.getDealerId());
        if (StringUtils.isNotNull(newParentDealer) && StringUtils.isNotNull(oldDealer)) {
            String newAncestors = newParentDealer.getAncestors() + "," + newParentDealer.getDealerId();
            String oldAncestors = oldDealer.getAncestors();
            dealer.setAncestors(newAncestors);
            updateDealerChildren(dealer.getDealerId(), newAncestors, oldAncestors);
        }
        int result = dealerMapper.updateDealer(dealer);
        if (UserConstants.DEPT_NORMAL.equals(dealer.getStatus())) {
            // 如果该部门是启用状态，则启用该部门的所有上级部门
            updateParentDealerStatus(dealer);
        }
        return result;
    }

    /**
     * 修改该经销商的父级经销商状态
     *
     * @param dealer 当前经销商
     */
    private void updateParentDealerStatus(SysDealer dealer) {
        String updateBy = dealer.getUpdateBy();
        dealer = dealerMapper.selectDealerById(dealer.getDealerId());
        dealer.setUpdateBy(updateBy);
        dealerMapper.updateDealerStatus(dealer);
    }

    /**
     * 修改子元素关系
     *
     * @param dealerId     被修改的经销商ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateDealerChildren(Long dealerId, String newAncestors, String oldAncestors) {
        List<SysDealer> children = dealerMapper.selectChildrenDealerById(dealerId);
        for (SysDealer child : children) {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0) {
            dealerMapper.updateDealerChildren(children);
        }
    }

    /**
     * 根据经销商ID查询信息
     *
     * @param dealerId 经销商ID
     * @return 经销商信息
     */
    @Override
    public SysDealer selectDealerById(Long dealerId) {
        return dealerMapper.selectDealerById(dealerId);
    }

    /**
     * 校验经销商名称是否唯一
     *
     * @param dealer 经销商信息
     * @return 结果
     */
    @Override
    public String checkDealerNameUnique(SysDealer dealer) {
        Long deptId = StringUtils.isNull(dealer.getDealerId()) ? -1L : dealer.getDealerId();
        SysDealer info = dealerMapper.checkDealerNameUnique(dealer.getDealerName(), dealer.getParentId());
        if (StringUtils.isNotNull(info) && info.getDealerId().longValue() != deptId.longValue()) {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }
}
