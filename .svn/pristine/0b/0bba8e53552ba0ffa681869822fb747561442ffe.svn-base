package com.ruoyi.bpr.service;

import com.ruoyi.bpr.domain.FundManage;

import java.util.List;

/**
 * 款项管理接口
 */
public interface IFundManageService {

    /**
     * 查询已收款项信息
     *
     * @param fundManage
     * @return
     */
    public List<FundManage> selectFundManageList(FundManage fundManage);

    /**
     * 新增已收款项信息
     *
     * @return
     */
    public int insertFund(FundManage fundManage);

    /**
     * 查询已收款项汇总
     *
     * @return
     */
    public List<FundManage> selectFundManage(FundManage fundManage);

    /**
     * 查询客户菜单
     *
     * @return
     */
    public List<FundManage> selectClientMenu();

    /**
     * 删除已收账款信息
     *
     * @param fundManage
     * @return
     */
    public int deleteFundByIds(FundManage fundManage);

    /**
     * 根据已收账款ID查询信息
     *
     * @param id 已收账款ID
     * @return 结果
     */
    public FundManage selectFundById(String id);

    /**
     * 修改已收账款信息
     *
     * @param fundManage
     * @return 结果
     */
    public int updateFundInfo(FundManage fundManage);

}