package com.ruoyi.bpr.mapper;



import com.ruoyi.bpr.domain.ContractManage;
import com.ruoyi.bpr.domain.SalesAccountData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesDataMapper {
    /**
     * 查找销售台账信息
     * @param contractManage
     * @return
     */
    List<SalesAccountData> selectSalesDataList(ContractManage contractManage);

    /**
     * 查找合同编号
     * @return
     */
    List<String> selectContractNumber();

    /**
     * 添加收款信息
     * @param salesAccountData
     * @return
     */
    Integer insertAccount(SalesAccountData salesAccountData);

    /**
     * 根据合同编号查找收款明细
     * @param contractNumber
     * @return
     */
    List<SalesAccountData> selectByContractNumber(String contractNumber);
}
