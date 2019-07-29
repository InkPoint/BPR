package com.ruoyi.bpr.service.impl;


import com.ruoyi.bpr.domain.ContractManage;
import com.ruoyi.bpr.domain.SalesAccountData;

import com.ruoyi.bpr.mapper.SalesDataMapper;
import com.ruoyi.bpr.service.ISalesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SalesDataService implements ISalesDataService {
    @Autowired
    SalesDataMapper salesDataMapper;

    @Override
    public List<SalesAccountData> selectSalesDataByContractNumber(String contractNumber) {
        return salesDataMapper.selectByContractNumber(contractNumber);
    }

    /**
     * 查找收款数据
     * @param contractManage
     * @return
     */
    @Override
    public List<SalesAccountData> searchSalesDataList(ContractManage contractManage) {

        return salesDataMapper.selectSalesDataList(contractManage);
    }

    /**
     * 查找合同编号
     * @return
     */
    @Override
    public List<String> searchContractNumber() {
        return salesDataMapper.selectContractNumber();
    }

    /**
     * 增加收款记录
     * @param salesAccountData
     * @return
     */
    @Override
    public Integer addAccount(SalesAccountData salesAccountData) {
        return salesDataMapper.insertAccount(salesAccountData);
    }
}
