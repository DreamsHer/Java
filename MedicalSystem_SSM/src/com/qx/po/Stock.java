package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Stock implements Serializable {
    /**
     * 进货ID
     */
    private Integer stockId;

    /**
     * 进货编号
     */
    private String stockcode;

    /**
     * 供应商ID
     */
    private Integer companyId;

    /**
     * 申请时间
     */
    private Date applytime;

    /**
     * 到货时间
     */
    private Date arrivaltime;

    /**
     * 品种数
     */
    private String drugspecies;

    /**
     * 采购员
     */
    private Integer userId;

    /**
     * 进货时间
     */
    private Date stocktime;

    private static final long serialVersionUID = 1L;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Date getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Date arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getDrugspecies() {
        return drugspecies;
    }

    public void setDrugspecies(String drugspecies) {
        this.drugspecies = drugspecies;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStocktime() {
        return stocktime;
    }

    public void setStocktime(Date stocktime) {
        this.stocktime = stocktime;
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
        Stock other = (Stock) that;
        return (this.getStockId() == null ? other.getStockId() == null : this.getStockId().equals(other.getStockId()))
            && (this.getStockcode() == null ? other.getStockcode() == null : this.getStockcode().equals(other.getStockcode()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getApplytime() == null ? other.getApplytime() == null : this.getApplytime().equals(other.getApplytime()))
            && (this.getArrivaltime() == null ? other.getArrivaltime() == null : this.getArrivaltime().equals(other.getArrivaltime()))
            && (this.getDrugspecies() == null ? other.getDrugspecies() == null : this.getDrugspecies().equals(other.getDrugspecies()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStocktime() == null ? other.getStocktime() == null : this.getStocktime().equals(other.getStocktime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStockId() == null) ? 0 : getStockId().hashCode());
        result = prime * result + ((getStockcode() == null) ? 0 : getStockcode().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getApplytime() == null) ? 0 : getApplytime().hashCode());
        result = prime * result + ((getArrivaltime() == null) ? 0 : getArrivaltime().hashCode());
        result = prime * result + ((getDrugspecies() == null) ? 0 : getDrugspecies().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStocktime() == null) ? 0 : getStocktime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stockId=").append(stockId);
        sb.append(", stockcode=").append(stockcode);
        sb.append(", companyId=").append(companyId);
        sb.append(", applytime=").append(applytime);
        sb.append(", arrivaltime=").append(arrivaltime);
        sb.append(", drugspecies=").append(drugspecies);
        sb.append(", userId=").append(userId);
        sb.append(", stocktime=").append(stocktime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}