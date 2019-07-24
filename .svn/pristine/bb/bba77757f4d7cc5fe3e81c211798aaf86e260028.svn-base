package com.ruoyi.bpr.service.impl;

import com.ruoyi.bpr.domain.ClientManage;
import com.ruoyi.bpr.mapper.ClientManageMapper;
import com.ruoyi.bpr.service.IClientManageService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户信息
 */
@Service
public class ClientManageServiceImpl implements IClientManageService {

    @Autowired
    private ClientManageMapper clientManageMapper;

    /**
     * 查询客户一览表集合
     * @param clientManage 操作客户对象
     * @return 结果
     */
    @Override
    public List<ClientManage> selectClientList(ClientManage clientManage) {
        return clientManageMapper.selectClientList(clientManage);
    }

    /**
     * 新增客户信息
     * @param clientManage 客户信息
     * @return 结果
     */
    @Override
    public int insertClient(ClientManage clientManage) {
        return clientManageMapper.insertClient(clientManage);
    }

    /**
     * 通过id查询客户信息
     * @param id
     * @return
     */
    @Override
    public ClientManage selectClientById(Integer id) {
        return clientManageMapper.selectClientById(id);
    }

    /**
     * 修改客户信息
     * @param clientManage
     * @return
     */
    @Override
    public int updateClient(ClientManage clientManage) {
        return clientManageMapper.updateClient(clientManage);
    }

    /**
     * 通过id删除客户信息
     * @param id
     * @return
     */
    @Override
    public int deleteClientById(Integer id) {
        return clientManageMapper.deleteClientById(id);
    }

    /**
     * 修改客户状态
     * @param clientManage
     * @return
     */
    @Override
    public int changeStatus(ClientManage clientManage) {
        return clientManageMapper.updateClient(clientManage);
    }
}
