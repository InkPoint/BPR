package com.ruoyi.bpr.mapper;

import com.ruoyi.bpr.domain.ClientManage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientManageMapper {

    /**
     * 查询客户一览表集合
     * @param clientManage
     * @return 结果
     */
    public List<ClientManage> selectClientList(ClientManage clientManage);


    /**
     * 增加客户信息
     * @param clientManage
     * @return 结果
     */
    public int insertClient(ClientManage clientManage);

    /**
     * 修改客户信息
     * @param clientManage
     * @return 结果
     */
    public int updateClient(ClientManage clientManage);

    /**
     * 通过id查询客户信息
     * @param id
     * @return
     */
    public ClientManage selectClientById(Integer id);

    /**
     * 通过id删除客户
     * @param id
     * @return
     */
    public int deleteClientById(Integer id);




}
