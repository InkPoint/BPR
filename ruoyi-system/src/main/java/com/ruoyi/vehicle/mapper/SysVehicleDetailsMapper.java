package com.ruoyi.vehicle.mapper;

import com.ruoyi.vehicle.domain.SysVehicleDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆详情 数据层
 * @date 2019/6/26 11:20
 */
@Repository
public interface SysVehicleDetailsMapper {
    /**
     * 查询系统车辆详情集合
     *
     * @param VehicleDetails 操作车辆详情
     * @return 操作车辆详情集合
     */
    public List<SysVehicleDetails> selectVehicleDetailsList(SysVehicleDetails VehicleDetails);

}
