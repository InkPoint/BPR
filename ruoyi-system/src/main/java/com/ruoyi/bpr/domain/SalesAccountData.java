package com.ruoyi.bpr.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class SalesAccountData extends BaseEntity {
    private static final long serialVersionUID = -8088208022149862935L;
    private Integer id;
    //签订日期
    @Excel(name = "签订日期")
    private Date signedDate;
    //客户
    @Excel(name = "客户")
    private String customer;
    //经销商
    @Excel(name = "经销商")
    private String dealer;
    //合同编号
    @Excel(name = "合同号")
    private String contractNumber;
    //数量
    @Excel(name = "数量")
    private Integer amount;
    //合同单价
    @Excel(name = "单价")
    private Double price;
    //合同总金额
    @Excel(name = "合同总金额")
    private Double totalMoney;
    //GPS
    @Excel(name = "GPS费用")
    private String GPS;
    //运费单价
    @Excel(name = "运费单价")
    private Double freight;
    //利息
    @Excel(name = "利息")
    private Double interest;
    //管理费
    @Excel(name = "管理费")
    private Double managementFee;
    //融资费用

    private Double financeFee;
    //付款日期
    @Excel(name = "付款日期",dateFormat = "yyyy-MM-dd")
    private Date payDate;
    //付款方式
    @Excel(name = "付款方式",readConverterExp = "E=电汇,H=承兑")
    private String paymentType;
    //付款金额
    @Excel(name = "付款金额")
    private String paymentAmount;

    //是否已删除
    private String isDelete;
    //创建人
    @Excel(name = "收款录入人")
    private String createdUser;
    //修改人
    private String modifiedUser;
    //创建时间
    @Excel(name = "收款录入时间",dateFormat = "yyyy-MM-dd HH-mm-ss")
    private Date createdTime;
    //修改时间
    private Date modifiedTime;
    // 付款总额
    @Excel(name = "付款总额")
    private Double totalPay;
    //客户代码
    private Integer clientCode;

    public Integer getClientCode() {
        return clientCode;
    }

    public void setClientCode(Integer clientCode) {
        this.clientCode = clientCode;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(Double managementFee) {
        this.managementFee = managementFee;
    }

    public Double getFinanceFee() {
        return financeFee;
    }

    public void setFinanceFee(Double financeFee) {
        this.financeFee = financeFee;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "SalesAccountData{" +
                "id=" + id +
                ", signedDate=" + signedDate +
                ", customer='" + customer + '\'' +
                ", dealer='" + dealer + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", totalMoney=" + totalMoney +
                ", GPS='" + GPS + '\'' +
                ", freight=" + freight +
                ", interest=" + interest +
                ", managementFee=" + managementFee +
                ", financeFee=" + financeFee +
                ", payDate=" + payDate +
                ", paymentType='" + paymentType + '\'' +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", totalPay=" + totalPay +
                ", clientCode=" + clientCode +
                '}';
    }
}
