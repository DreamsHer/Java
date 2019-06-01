package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Chargingitems implements Serializable {
    /**
     * 收费项目ID
     */
    private Integer chargingitemId;

    /**
     * 门诊挂号ID
     */
    private Integer ouhosinfoId;

    /**
     * 住院病人ID
     */
    private Integer inhosinfoId;

    /**
     * 处方单号
     */
    private String prescriptioncode;

    /**
     * 应收金额
     */
    private Double receivablemoney;

    /**
     * 支付金额
     */
    private Double paymentmoney;

    /**
     * 收费人ID
     */
    private Integer userId;

    /**
     * 收费时间
     */
    private Date chargingtime;

    private static final long serialVersionUID = 1L;

    public Integer getChargingitemId() {
        return chargingitemId;
    }

    public void setChargingitemId(Integer chargingitemId) {
        this.chargingitemId = chargingitemId;
    }

    public Integer getOuhosinfoId() {
        return ouhosinfoId;
    }

    public void setOuhosinfoId(Integer ouhosinfoId) {
        this.ouhosinfoId = ouhosinfoId;
    }

    public Integer getInhosinfoId() {
        return inhosinfoId;
    }

    public void setInhosinfoId(Integer inhosinfoId) {
        this.inhosinfoId = inhosinfoId;
    }

    public String getPrescriptioncode() {
        return prescriptioncode;
    }

    public void setPrescriptioncode(String prescriptioncode) {
        this.prescriptioncode = prescriptioncode;
    }

    public Double getReceivablemoney() {
        return receivablemoney;
    }

    public void setReceivablemoney(Double receivablemoney) {
        this.receivablemoney = receivablemoney;
    }

    public Double getPaymentmoney() {
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
        Chargingitems other = (Chargingitems) that;
        return (this.getChargingitemId() == null ? other.getChargingitemId() == null : this.getChargingitemId().equals(other.getChargingitemId()))
            && (this.getOuhosinfoId() == null ? other.getOuhosinfoId() == null : this.getOuhosinfoId().equals(other.getOuhosinfoId()))
            && (this.getInhosinfoId() == null ? other.getInhosinfoId() == null : this.getInhosinfoId().equals(other.getInhosinfoId()))
            && (this.getPrescriptioncode() == null ? other.getPrescriptioncode() == null : this.getPrescriptioncode().equals(other.getPrescriptioncode()))
            && (this.getReceivablemoney() == null ? other.getReceivablemoney() == null : this.getReceivablemoney().equals(other.getReceivablemoney()))
            && (this.getPaymentmoney() == null ? other.getPaymentmoney() == null : this.getPaymentmoney().equals(other.getPaymentmoney()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getChargingtime() == null ? other.getChargingtime() == null : this.getChargingtime().equals(other.getChargingtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChargingitemId() == null) ? 0 : getChargingitemId().hashCode());
        result = prime * result + ((getOuhosinfoId() == null) ? 0 : getOuhosinfoId().hashCode());
        result = prime * result + ((getInhosinfoId() == null) ? 0 : getInhosinfoId().hashCode());
        result = prime * result + ((getPrescriptioncode() == null) ? 0 : getPrescriptioncode().hashCode());
        result = prime * result + ((getReceivablemoney() == null) ? 0 : getReceivablemoney().hashCode());
        result = prime * result + ((getPaymentmoney() == null) ? 0 : getPaymentmoney().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getChargingtime() == null) ? 0 : getChargingtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chargingitemId=").append(chargingitemId);
        sb.append(", ouhosinfoId=").append(ouhosinfoId);
        sb.append(", inhosinfoId=").append(inhosinfoId);
        sb.append(", prescriptioncode=").append(prescriptioncode);
        sb.append(", receivablemoney=").append(receivablemoney);
        sb.append(", paymentmoney=").append(paymentmoney);
        sb.append(", userId=").append(userId);
        sb.append(", chargingtime=").append(chargingtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}