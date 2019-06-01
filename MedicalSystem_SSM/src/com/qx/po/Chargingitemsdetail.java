package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Chargingitemsdetail implements Serializable {
    /**
     * 收费明细ID
     */
    private Integer chargingitemdetailId;

    /**
     * 收费项目ID
     */
    private Integer chargingitemId;

    /**
     * 进货明细ID
     */
    private Integer stockdetailId;

    /**
     * 数量
     */
    private String amount;

    /**
     * 优惠
     */
    private Double discount;

    /**
     * 发生次数
     */
    private String frequency;

    /**
     * 项目金额
     */
    private Double itemmoney;

    /**
     * 责任系数
     */
    private String coefficient;
    
    
    /**
     * 外键表字段
     */
    private String prescriptioncode;
    
    private Double receivablemoney;
    
    private Double paymentmoney;
    
    private Integer userId;

    private Date chargingtime;
    
    private String basedetailname;
    
	private String username;
    
	 /**
     * 药品名称
     */
    private String drugname;
    
    
    /**
     * 药品单价
     */
    private Double price;
	
    

    private static final long serialVersionUID = 1L;

    public Integer getChargingitemdetailId() {
        return chargingitemdetailId;
    }

    public void setChargingitemdetailId(Integer chargingitemdetailId) {
        this.chargingitemdetailId = chargingitemdetailId;
    }

    public Integer getChargingitemId() {
        return chargingitemId;
    }

    public void setChargingitemId(Integer chargingitemId) {
        this.chargingitemId = chargingitemId;
    }

    public Integer getStockdetailId() {
        return stockdetailId;
    }

    public void setStockdetailId(Integer stockdetailId) {
        this.stockdetailId = stockdetailId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Double getItemmoney() {
        return itemmoney;
    }

    public void setItemmoney(Double itemmoney) {
        this.itemmoney = itemmoney;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }
    

    /**
     * 外键get set 方法
     */
    public void setPrescriptioncode(String prescriptioncode) {
        this.prescriptioncode = prescriptioncode;
    }
    
    public String getPrescriptioncode() {
        return prescriptioncode;
    }
    
    public Double getReceivablemoney() {
        return receivablemoney;
    }

    public void setReceivablemoney(Double receivablemoney) {
        this.receivablemoney = receivablemoney;
    }
    
    public Double getPaymentmoney(){
    	return paymentmoney;
    }
    
    public void setPaymentmoney(Double paymentmoney) {
        this.paymentmoney = paymentmoney;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getChargingtime() {
        return chargingtime;
    }

    public void setChargingtime(Date chargingtime) {
        this.chargingtime = chargingtime;
    }
    
    public String getBasedetailname() {
        return basedetailname;
    }
    
    public void setBasedetailname(String basedetailname) {
        this.basedetailname = basedetailname;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }
    
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Chargingitemsdetail other = (Chargingitemsdetail) that;
        return (this.getChargingitemdetailId() == null ? other.getChargingitemdetailId() == null : this.getChargingitemdetailId().equals(other.getChargingitemdetailId()))
            && (this.getChargingitemId() == null ? other.getChargingitemId() == null : this.getChargingitemId().equals(other.getChargingitemId()))
            && (this.getStockdetailId() == null ? other.getStockdetailId() == null : this.getStockdetailId().equals(other.getStockdetailId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getFrequency() == null ? other.getFrequency() == null : this.getFrequency().equals(other.getFrequency()))
            && (this.getItemmoney() == null ? other.getItemmoney() == null : this.getItemmoney().equals(other.getItemmoney()))
            && (this.getCoefficient() == null ? other.getCoefficient() == null : this.getCoefficient().equals(other.getCoefficient()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChargingitemdetailId() == null) ? 0 : getChargingitemdetailId().hashCode());
        result = prime * result + ((getChargingitemId() == null) ? 0 : getChargingitemId().hashCode());
        result = prime * result + ((getStockdetailId() == null) ? 0 : getStockdetailId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getFrequency() == null) ? 0 : getFrequency().hashCode());
        result = prime * result + ((getItemmoney() == null) ? 0 : getItemmoney().hashCode());
        result = prime * result + ((getCoefficient() == null) ? 0 : getCoefficient().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chargingitemdetailId=").append(chargingitemdetailId);
        sb.append(", chargingitemId=").append(chargingitemId);
        sb.append(", stockdetailId=").append(stockdetailId);
        sb.append(", amount=").append(amount);
        sb.append(", discount=").append(discount);
        sb.append(", frequency=").append(frequency);
        sb.append(", itemmoney=").append(itemmoney);
        sb.append(", coefficient=").append(coefficient);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}