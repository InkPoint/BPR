package com.ruoyi.vehicle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆详情 dj_htly
 * @date 2019/6/26 10:43
 */
public class SysVehicleDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String htbh;

    /** 经销商 */
    @Excel(name = "经销商")
    private String jxs;

    /** 业务归口(销售经理) */
    @Excel(name = "业务归口(销售经理)")
    private String ywgk;

    /** 数量 */
    @Excel(name="数量")
    private int sl;

    /** 已发台数 */
    @Excel(name = "已发台数")
    private int yfts;

    /** 出门日期(或计划发车时间) */
    @Excel(name = "出门日期(或计划发车时间)", width = 20, dateFormat = "yyyy-MM-dd")
    private Date cmrq;

    /** 签订日期 */
    @Excel(name = "签订日期", width = 20, dateFormat = "yyyy-MM-dd")
    private Date qdrq;

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public String getJxs() {
        return jxs;
    }

    public void setJxs(String jxs) {
        this.jxs = jxs;
    }

    public String getYwgk() {
        return ywgk;
    }

    public void setYwgk(String ywgk) {
        this.ywgk = ywgk;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getYfts() {
        return yfts;
    }

    public void setYfts(int yfts) {
        this.yfts = yfts;
    }

    public Date getCmrq() {
        return cmrq;
    }

    public void setCmrq(Date cmrq) {
        this.cmrq = cmrq;
    }

    public Date getQdrq() {
        return qdrq;
    }

    public void setQdrq(Date qdrq) {
        this.qdrq = qdrq;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("htbh", getHtbh())
            .append("jxs", getJxs())
            .append("ywgk", getYwgk())
            .append("sl", getSl())
            .append("yfts", getYfts())
            .append("cmrq", getCmrq())
            .append("qdrq", getQdrq())
            .toString();
    }
}
