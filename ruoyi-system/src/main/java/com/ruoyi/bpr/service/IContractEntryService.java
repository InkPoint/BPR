package com.ruoyi.bpr.service;

import com.ruoyi.bpr.domain.ContractManage;

import java.util.List;


public interface IContractEntryService {

    /**
     *  新增合同
     * @param contractManage 合同信息
     * @return 结果
     */
    public int insertContract(ContractManage contractManage);

    /**
     * 查询合同一览表集合
     * @param contractManage 操作合同对象
     * @return 操作合同一览表集合
     */
    public List<ContractManage> selectContractList(ContractManage contractManage);

    /**
     * 删除合同
     * @param id 合同信息
     * @return 结果
     */
    public int delContract(Integer id);

    /**
     * 校验合同编号是否唯一
     * @param htbh
     * @return
     */
    public String checkHtbhUnique(String htbh);
}
