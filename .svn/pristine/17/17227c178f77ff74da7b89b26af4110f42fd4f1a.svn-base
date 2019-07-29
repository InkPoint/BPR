package com.ruoyi.bpr.service;

import com.ruoyi.bpr.domain.SysDealer;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.SysRole;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 经销商管理 服务层
 * @date 2019/7/4 9:47
 */
public interface ISysDealerService {

    /**
     * 查询经销商管理数据
     *
     * @param dealer 经销商信息
     * @return 经销商信息集合
     */
    public List<SysDealer> selectDealerList(SysDealer dealer);

    /**
     * 查询经销商管理树
     *
     * @param dealer 经销商信息
     * @return 所有经销商信息
     */
    public List<Ztree> selectDealerTree(SysDealer dealer);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleDealerTreeData(SysRole role);

    /**
     * 查询经销商人数
     *
     * @param parentId 父经销商ID
     * @return 结果
     */
    public int selectDealerCount(Long parentId);

    /**
     * 查询经销商是否存在用户
     *
     * @param dealerId 经销商ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkdealerExistUser(Long dealerId);

    /**
     * 删除经销商管理信息
     *
     * @param dealerId 部门ID
     * @return 结果
     */
    public int deleteDealerById(Long dealerId);

    /**
     * 新增保存经销商信息
     *
     * @param Dealer 部门信息
     * @return 结果
     */
    public int insertDealer(SysDealer Dealer);

    /**
     * 修改保存经销商给你信息
     *
     * @param Dealer 经销商信息
     * @return 结果
     */
    public int updateDealer(SysDealer Dealer);

    /**
     * 根据经销商ID查询信息
     *
     * @param dealerId 经销商ID
     * @return 惊喜哦啊上信息
     */
    public SysDealer selectDealerById(Long dealerId);

    /**
     * 校验经销商名称是否唯一
     *
     * @param Dealer 经销商信息
     * @return 结果
     */
    public String checkDealerNameUnique(SysDealer Dealer);
}
