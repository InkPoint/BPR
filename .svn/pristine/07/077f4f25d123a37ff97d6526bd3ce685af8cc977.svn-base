package com.ruoyi.vehicle.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.vehicle.domain.SysRepertory;
import com.ruoyi.vehicle.mapper.SysRepertoryMapper;
import com.ruoyi.vehicle.service.ISysRepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 库存车辆信息 服务层处理
 * @date 2019/6/26 11:20
 */
@Service
public class SysRepertoryServiceImpl implements ISysRepertoryService {

    @Autowired
    private SysRepertoryMapper repertoryMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<SysRepertory> selectRepertoryList(SysRepertory repertory) {
        return repertoryMapper.selectRepertoryList(repertory);
    }

}
