package com.ruoyi.vehicle.mapper;

import com.ruoyi.vehicle.domain.SysCarDespatch;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆发运 数据层
 * @date 2019/08/05 08:52
 */
@Repository
public interface SysCarDespatchMapper {

    /**
     * 查询车辆发运信息集合
     *
     * @param carDespatch 车辆发运信息
     * @return 车辆发运信息集合
     */
    public List<SysCarDespatch> selectCarDespatchList(SysCarDespatch carDespatch);

    /**
     * 通过车辆发运ID查询
     *
     * @param despatchCode 车辆发运ID
     * @return 车辆发运对象信息
     */
    public SysCarDespatch selectCarDespatchById(String despatchCode);

    /**
     * 批量删除发运信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteCarDespatchByIds(String[] ids);

    /**
     * 新增保存车辆发运信息
     *
     * @param carDespatch 发运信息
     * @return 结果
     */
    public int insertCarDespatch(SysCarDespatch carDespatch);

    /**
     * 修改保存车辆发运信息
     *
     * @param carDespatch 发运信息
     * @return 结果
     */
    public int updateCarDespatch(SysCarDespatch carDespatch);

    /**
     * 查询合同编号菜单
     * @return
     */
    public List<SysCarDespatch> selectPactMenu();

}
