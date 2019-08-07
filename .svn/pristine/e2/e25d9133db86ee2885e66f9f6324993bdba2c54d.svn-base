package com.ruoyi.vehicle.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * @author ChungWe
 * @Version 1.1
 * @Title 车辆发运
 * @date 2019/08/05 8:45
 */
public class SysCarDespatch extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 发运编号
     */
    @Excel(name = "发运编号")
    private String despatchCode;

    /**
     * 客户名称
     */
    @Excel(name = "客户")
    private String clientName;

    /**
     * 合同一栏表_合同ID
     */
    private String pactID;

    /**
     * 合同一栏表_合同编号
     */
    @Excel(name = "合同编号")
    private String pactCode;

    /**
     * 合同一览表_合同总数量(台)
     */
    @Excel(name = "合同总量(台)")
    private String pactTotalAmount;

    /**
     * 统计此次发运量(台)
     */
    @Excel(name = "发运量(台)")
    private String despatchAmount;

    /**
     * 车辆发运备注信息
     */
    @Excel(name = "备注")
    private String remark;

    /**
     * 车辆发运日期
     */
    @Excel(name = "发运日期")
    private Date createTime;

    /**
     * 有效标志(Y有效，N无效)
     */
    private String ack;

    public String getDespatchCode() {
        return despatchCode;
    }

    public void setDespatchCode(String despatchCode) {
        this.despatchCode = despatchCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPactID() {
        return pactID;
    }

    public void setPactID(String pactID) {
        this.pactID = pactID;
    }

    public String getPactCode() {
        return pactCode;
    }

    public void setPactCode(String pactCode) {
        this.pactCode = pactCode;
    }

    public String getPactTotalAmount() {
        return pactTotalAmount;
    }

    public void setPactTotalAmount(String pactTotalAmount) {
        this.pactTotalAmount = pactTotalAmount;
    }

    public String getDespatchAmount() {
        return despatchAmount;
    }

    public void setDespatchAmount(String despatchAmount) {
        this.despatchAmount = despatchAmount;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("despatchCode", getDespatchCode())
                .append("pactID", getPactID())
                .append("pactCode", getPactCode())
                .append("pactTotalAmount", getPactTotalAmount())
                .append("despatchAmount", getDespatchAmount())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("ack", getAck())
                .toString();
    }

}
