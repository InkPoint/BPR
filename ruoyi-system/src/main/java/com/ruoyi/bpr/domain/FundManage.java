package com.ruoyi.bpr.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FundManage extends BaseEntity {

    private static final long serialVersionUID = 9167074825078717374L;

    private Integer id;

    @Excel(name="客户代码")
    private Integer clientCode;

    @Excel(name="客户")
    private String clientName;

    @Excel(name="付款人")
    private String payer;

    @Excel(name="付款账户")
    private String paymentAccount;

    @Excel(name="时间")
    private String paymentTime;

    @Excel(name="付款方式代码")
    private String paymentType;

    private String paymentAmount;

    @Excel(name="收款人")
    private String payee;

    @Excel(name="收款方账户")
    private String accountPayee;

    @Excel(name="备注")
    private String remark;

    private String ack;

    private String count;
    private String totalPay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientCode() {
        return clientCode;
    }

    public void setClientCode(Integer clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
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

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getAccountPayee() {
        return accountPayee;
    }

    public void setAccountPayee(String accountPayee) {
        this.accountPayee = accountPayee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(String totalPay) {
        this.totalPay = totalPay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("clientCode",getClientCode())
                .append("clientName",getClientName())
                .append("payer", getPayer())
                .append("paymentAccount", getPaymentAccount())
                .append("paymentTime", getPaymentTime())
                .append("paymentType",getPaymentType())
                .append("paymentAmount", getPaymentAmount())
                .append("payee", getPayee())
                .append("accountPayee", getAccountPayee())
                .append("remark", getRemark())
                .append("ack", getAck())
                .append("count", getCount())
                .append("totalpay", getTotalPay())
                .toString();
    }
}
