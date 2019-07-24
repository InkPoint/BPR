package com.ruoyi.web.controller.vehicle;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.sql.DBUtil;
import com.ruoyi.vehicle.domain.SysRepertory;
import com.ruoyi.vehicle.service.ISysRepertoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆库存信息
 * @date 2019/07/12 8:37
 */
@Controller
@RequestMapping("/vehicle/repertory")
public class SysRepertoryController extends BaseController {

    private String prefix = "vehicle/repertory";

    @Autowired
    private ISysRepertoryService repertoryService;

    @RequiresPermissions("vehicle:repertory:view")
    @GetMapping()
    public String repertory() {
        return prefix + "/repertory";
    }

    /**
     * 免配从库获取SQL server数据
     *
     * @param repertory
     * @return
     * @throws Exception
     */
    @RequiresPermissions("vehicle:repertory:lists")
    @PostMapping("/lists")
    @ResponseBody
    public TableDataInfo lists(SysRepertory repertory) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String sql = "select * from(\n" +
                "select a.[ArchivesID],a.[ContractNo],a.[TechNo],a.[BS1],a.[CategoryCode],f.CategoryName,a.[SeriesCode],\n" +
                "   d.SeriesName,a.[LevelCode],  e.LevelName, a.[BS18],v.ModelName, a.[AreaCode],g.AreaName,\n" +
                "   a.[VahicleModel],a.[VahicleNo],a.[FrameNo],convert(varchar(100),a.[OfflineDate],23) OfflineDate,a.[PublishPerson],\n" +
                "   a.[ArchivesStatus],a.[CreateTime],a.[UpdateDate],a.[Remark]\n" +
                "from TLZG_VAM.dbo.Pt_VehicleArchives a\n" +
                "left join (select distinct SeriesCode,SeriesName from TLZG_VAM.dbo.Pc_VahicleSeries)  d on a.SeriesCode=d.SeriesCode\n" +
                "left join (select distinct LevelCode,LevelName from TLZG_VAM.dbo.Pc_VahicleLevel) e on a.LevelCode=e.LevelCode\n" +
                "left join (select distinct CategoryCode,CategoryName from TLZG_VAM.dbo.Pc_VahicleCategory) f on a.CategoryCode=f.CategoryCode\n" +
                "left join (select distinct AgencyCode,AgencyName from TLZG_VAM.dbo.Pc_Agency) i on a.AgencyCode=i.AgencyCode\n" +
                "left join (select distinct ServiceDateCode,ServiceDateName from TLZG_VAM.dbo.Pc_ServiceDate) j on a.ServiceDateCode=j.ServiceDateCode\n" +
                "left join (select distinct AreaCode,AreaName from TLZG_VAM.dbo.Pc_Area) g on a.AreaCode=g.AreaCode\n" +
                "left join (select distinct ModelCode,ModelName from TLZG_VAM.dbo.Pc_VehicleModel) v on a.BS18=v.ModelCode\n" +
                "where   1 = 1  and a.ArchivesStatus like '%Offline%') T1 where 1 = 1 ";
        // 条件查询(车辆类别、协议编号、入库日期)
        if (StringUtils.isNotEmpty(repertory.getCategoryName())) {
            sql += "and T1.CategoryName like '%" + StringUtils.trim(repertory.getCategoryName()) + "%'";
        }
        if (StringUtils.isNotEmpty(repertory.getTechNo())) {
            sql += "AND T1.TechNo like '%" + StringUtils.trim(repertory.getTechNo()) + "%'";
        }
        if (StringUtils.isNotEmpty(repertory.getStartTime())) {
            sql += "and T1.offlinedate >= convert(varchar(100),'" + repertory.getStartTime() + "',23)";
        }
        if (StringUtils.isNotEmpty(repertory.getEndTime())) {
            sql += "and T1.offlinedate <= convert(varchar(100),'" + repertory.getEndTime() + "',23)";
        }
        // 通过数据库的连接操作数据库，实现增删改查
        Statement statement = DBUtil.getConnection().createStatement();
        // 执行查询语句，返回结果集(ResultSet)
        ResultSet resultSet = statement.executeQuery(sql);
        // 获取结果集结构信息，源数据
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        // 获取列数
        int columnCount = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> rowData = new HashMap<String, Object>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            list.add(rowData);
        }
        resultSet.close();
        return getDataTable(list);
    }

    @RequiresPermissions("vehicle:repertory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysRepertory repertory) {
        List<SysRepertory> list = repertoryService.selectRepertoryList(repertory);
        return getDataTable(list);
    }

    @Log(title = "车辆库存", businessType = BusinessType.EXPORT)
    @RequiresPermissions("vehicle:repertory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRepertory repertory) {
        List<SysRepertory> list = repertoryService.selectRepertoryList(repertory);
        ExcelUtil<SysRepertory> util = new ExcelUtil<SysRepertory>(SysRepertory.class);
        return util.exportExcel(list, "车辆库存");
    }

}
