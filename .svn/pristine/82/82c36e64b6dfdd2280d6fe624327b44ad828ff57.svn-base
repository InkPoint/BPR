package com.ruoyi.vehicle.service.impl;

import com.ruoyi.vehicle.mapper.SysVehicleDetailsMapper;
import com.ruoyi.vehicle.domain.SysVehicleDetails;
import com.ruoyi.vehicle.service.ISysVehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆详情 服务层处理
 * @date 2019/6/26 11:18
 */
@Service
public class SysVehicleDetailsServiceImpl implements ISysVehicleDetailsService {

    @Autowired
    private SysVehicleDetailsMapper VehicleDetailsMapper;

    @Override
    public List<SysVehicleDetails> selectVehicleDetailsList(SysVehicleDetails VehicleDetails) {
        return VehicleDetailsMapper.selectVehicleDetailsList(VehicleDetails);
    }

}
