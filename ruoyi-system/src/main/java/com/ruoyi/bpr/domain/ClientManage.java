package com.ruoyi.bpr.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class ClientManage extends BaseEntity {

    private static final long serialVersionUID = 6258867869085022974L;

    private Integer id;

    /**
     * 客户名称
     */
    @Excel(name = "客户名称")
    private String clientName;

    /**
     * 联系方式
     */
    @Excel(name = "联系方式")
    private String phonenumber;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 经销商
     */
    @Excel(name = "经销商编号")
    private Integer dealerCode;

    /**
     * 地址
     */
    @Excel(name = "地址")
    private String address;

    /**
     * 客户状态
     */
    private String status;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

    /**
     * 有效标志
     */
    private String ack;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(Integer dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    @Override
    public String toString() {
        return "ClientManage{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", dealerCode=" + dealerCode +
                ", address='" + address + '\'' +
                ", clientState='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", ack='" + ack + '\'' +
                '}';
    }
}
