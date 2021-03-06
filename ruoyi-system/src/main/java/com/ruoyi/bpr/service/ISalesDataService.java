package com.ruoyi.bpr.service;


import com.ruoyi.bpr.domain.ContractManage;
import com.ruoyi.bpr.domain.SalesAccountData;


import java.util.Date;
import java.util.List;

public interface ISalesDataService {
    /**
     * 查询销售台账信息
     *
     * @param contractManage
     * @return
     */
    List<SalesAccountData> searchSalesDataList(ContractManage contractManage);

    /**
     * 查找合同编号
     *
     * @return
     */
    List<String> searchContractNumber();

    /**
     * 增加收款记录
     *
     * @param salesAccountData
     * @return
     */
    Integer addAccount(SalesAccountData salesAccountData);

    /**
     * 根据合同编号查找收款明细
     *
     * @param contractNumber
     * @return
     */
    List<SalesAccountData> selectSalesDataByContractNumber(String contractNumber);

    /**
     * 导出明细查询
     *
     * @return
     */
    List<SalesAccountData> selectExportList();

    /**
     * 查找客户
     *
     * @return
     */
    List<SalesAccountData> selectCustomer();

    /**
     * 根据客户代码查找合同编号
     *
     * @param clientCode
     * @return
     */
    List<String> selectContractNumber(Integer clientCode);

    /**
     * 查找可分配余额
     *
     * @param clientCode
     * @return
     */
    Double selectAllocatedMoney(Integer clientCode);

    /**
     * 根据合同号删除台账信息
     * @param contractNumber
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer deleteAccountInfo(String contractNumber, String modifiedUser, Date modifiedTime);
}
