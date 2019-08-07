package com.ruoyi.vehicle.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.vehicle.domain.SysCarDespatch;
import com.ruoyi.vehicle.mapper.SysCarDespatchMapper;
import com.ruoyi.vehicle.service.ISysCarDespatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆发运 服务层处理
 * @date 2019/08/05 08:54
 */
@Service
public class SysCarDespatchServiceImpl implements ISysCarDespatchService {

    @Autowired
    private SysCarDespatchMapper carDespatchMapper;

    /**
     * 车辆发运信息集合
     *
     * @param carDespatch 车辆发运信息
     * @return
     */
    @Override
    public List<SysCarDespatch> selectCarDespatchList(SysCarDespatch carDespatch) {
        return carDespatchMapper.selectCarDespatchList(carDespatch);
    }

    /**
     * 通过车辆发运ID查询
     *
     * @param despatchCode 车辆发运ID
     * @return
     */
    @Override
    public SysCarDespatch selectCarDespatchById(String despatchCode) {
        return carDespatchMapper.selectCarDespatchById(despatchCode);
    }

    /**
     * 批量删除发运信息
     *
     * @param ids 需要删除的数据ID
     * @return
     * @throws Exception
     */
    @Override
    public int deleteCarDespatchByIds(String ids){
        return carDespatchMapper.deleteCarDespatchByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增车辆发运信息
     *
     * @param carDespatch 发运信息
     * @return
     */
    @Override
    public int insertCarDespatch(SysCarDespatch carDespatch) {
        return carDespatchMapper.insertCarDespatch(carDespatch);
    }

    /**
     * 修改车辆发运信息
     *
     * @param carDespatch 发运信息
     * @return
     */
    @Override
    public int updateCarDespatch(SysCarDespatch carDespatch) {
        return carDespatchMapper.updateCarDespatch(carDespatch);
    }

    /**
     * 查询合同编号菜单
     *
     * @return
     */
    @Override
    public List<SysCarDespatch> selectPactMenu() {
        return carDespatchMapper.selectPactMenu();
    }
}
