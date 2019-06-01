package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Stockdetail implements Serializable {
    /**
     * 进货明细Id
     */
    private Integer stockdetailId;

    /**
     * 进货Id
     */
    private Integer stockId;

    /**
     * 药品Id
     */
    private Integer drugId;

    /**
     * 进货数量
     */
    private String stocknum;
    
    
    /**
     * 药品名称
     */
    private String drugname;
    
    
    /**
     * 药品单价
     */
    private Double price;
    
    /**
     * 换算系数
     */
    private String coefficient;
    
    /**
     * 规格型号
     */
    private String spec;
    
    /**
     * 基础明细名称
     */
    private String basedetailname;
    
    private String basedetailname1;
    
    private String basedetailname2;
    
    /**
     * 进货编号
     */
    private String stockcode;
    
    /**
     * 供应商名
     */
    private String companyname;
    
    /**
     * 有效日期
     */
    private Date effectivedate;
    
    private String effectivedates;
    
    
    

    private static final long serialVersionUID = 1L;

    public Integer getStockdetailId() {
        return stockdetailId;
    }

    public void setStockdetailId(Integer stockdetailId) {
        this.stockdetailId = stockdetailId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getStocknum() {
        return stocknum;
    }

    public void setStocknum(String stocknum) {
        this.stocknum = stocknum;
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
    
    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }
    
    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
    
    public String getBasedetailname() {
        return basedetailname;
    }

    public void setBasedetailname(String basedetailname) {
        this.basedetailname = basedetailname;
    }
    
    public String getBasedetailname1() {
        return basedetailname1;
    }

    public void setBasedetailname1(String basedetailname1) {
        this.basedetailname1 = basedetailname1;
    }
    
    public String getBasedetailname2() {
        return basedetailname2;
    }

    public void setBasedetailname2(String basedetailname2) {
        this.basedetailname2 = basedetailname2;
    }
    
    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }
    
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
    
    public Date getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(Date effectivedate) {
        this.effectivedate = effectivedate;
    }
    
    public String getEffectivedates() {
        return effectivedates;
    }

    public void setEffectivedates(String effectivedates) {
        this.effectivedates = effectivedates;
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
        Stockdetail other = (Stockdetail) that;
        return (this.getStockdetailId() == null ? other.getStockdetailId() == null : this.getStockdetailId().equals(other.getStockdetailId()))
            && (this.getStockId() == null ? other.getStockId() == null : this.getStockId().equals(other.getStockId()))
            && (this.getDrugId() == null ? other.getDrugId() == null : this.getDrugId().equals(other.getDrugId()))
            && (this.getStocknum() == null ? other.getStocknum() == null : this.getStocknum().equals(other.getStocknum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStockdetailId() == null) ? 0 : getStockdetailId().hashCode());
        result = prime * result + ((getStockId() == null) ? 0 : getStockId().hashCode());
        result = prime * result + ((getDrugId() == null) ? 0 : getDrugId().hashCode());
        result = prime * result + ((getStocknum() == null) ? 0 : getStocknum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stockdetailId=").append(stockdetailId);
        sb.append(", stockId=").append(stockId);
        sb.append(", drugId=").append(drugId);
        sb.append(", stocknum=").append(stocknum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}