package com.ruoyi.bpr.service;

import com.ruoyi.bpr.domain.ClientManage;

import java.util.List;

/**
 * 客户信息接口
 */
public interface IClientManageService {

    /**
     * 查询客户一览表信息
     * @param clientManage 操作客户对象
     * @return 结果
     */
    public List<ClientManage> selectClientList(ClientManage clientManage);

    /**
     * 新增客户
     * @param clientManage 客户信息
     * @return 结果
     */
    public int insertClient(ClientManage clientManage);

    /**
     * 通过你id查询客户信息
     * @param id
     * @return
     */
    public ClientManage selectClientById(Integer id);

    /**
     * 修改客户信息
     * @param clientManage
     * @return
     */
    public int updateClient(ClientManage clientManage);

    /**
     * 删除客户数据
     * @param id
     * @return
     */
    public int deleteClientById(Integer id);


    /**
     * 修改客户状态
     * @param clientManage
     * @return
     */
    public int changeStatus(ClientManage clientManage);

}
