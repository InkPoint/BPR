package com.ruoyi.bpr.service.impl;

import com.ruoyi.bpr.domain.ContractManage;
import com.ruoyi.bpr.mapper.ContractManageMapper;
import com.ruoyi.bpr.service.IContractEntryService;
import com.ruoyi.common.constant.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作合同一览表 服务层处理
 */
@Service
public class ContractEntryServiceImpl implements IContractEntryService {

    @Autowired
    private ContractManageMapper contractManageMapper;

    /**
     * 查询合同一览表集合
     *
     * @param contractManage 操作合同对象
     * @return
     */
    @Override
    public List<ContractManage> selectContractList(ContractManage contractManage) {
        return contractManageMapper.selectContractList(contractManage);
    }

    /**
     * 新增合同
     *
     * @param contractManage 操作合同对象
     * @return
     */
    @Override
    public int insertContract(ContractManage contractManage) {

        return contractManageMapper.insertContract(contractManage);
    }

    /**
     * 删除合同
     * @param id 合同信息
     * @return 结果
     */
    @Override
    public int delContract(Integer id) {
        return contractManageMapper.delContract(id);
    }

    /**
     *  校验合同编号是否唯一
     * @param htbh
     * @return
     */
    @Override
    public String checkHtbhUnique(String htbh) {
        int count = contractManageMapper.checkHtbhUnique(htbh);
        if(count>0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }
}
