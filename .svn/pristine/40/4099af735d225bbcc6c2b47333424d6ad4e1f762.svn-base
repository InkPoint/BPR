package com.ruoyi.bpr.service;


import com.ruoyi.bpr.domain.ContractManage;
import com.ruoyi.bpr.domain.SalesAccountData;


import java.util.List;

public interface ISalesDataService {
    /**
     * 查询销售台账信息
     * @param contractManage
     * @return
     */
    List<SalesAccountData> searchSalesDataList(ContractManage contractManage);

    /**
     *查找合同编号
     * @return
     */
    List<String> searchContractNumber();

    /**
     * 增加收款记录
     * @param salesAccountData
     * @return
     */
    Integer addAccount(SalesAccountData salesAccountData);

    /**
     * 根据合同编号查找收款明细
     * @param contractNumber
     * @return
     */
    List<SalesAccountData> selectSalesDataByContractNumber(String contractNumber);
}
