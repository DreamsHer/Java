package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Drug implements Serializable {
    /**
     * 药品ID
     */
    private Integer drugId;

    /**
     * 药品名称
     */
    private String drugname;

    /**
     * 药品编号
     */
    private String drugcode;

    /**
     * 药房分类
     */
    private Integer flbasedetailId;

    /**
     * 药品单价
     */
    private Double price;

    /**
     * 药品单位
     */
    private Integer dwbasedetailId;

    /**
     * 规格型号
     */
    private String spec;

    /**
     * 换算系数
     */
    private String coefficient;

    /**
     * 生产日期
     */
    private Date producedate;

    /**
     * 有效日期
     */
    private Date effectivedate;

    /**
     * 供应商ID
     */
    private Integer companyId;

    /**
     * 存储数量
     */
    private String storagequantity;

    /**
     * 存储位置
     */
    private String storagelocation;
    
    /**
     * 基础明细名称
     */
    private String basedetailname;
    
    private String basedetailname1;
    
    private String basedetailname2;
    

    private static final long serialVersionUID = 1L;

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(String drugcode) {
        this.drugcode = drugcode;
    }

    public Integer getFlbasedetailId() {
        return flbasedetailId;
    }

    public void setFlbasedetailId(Integer flbasedetailId) {
        this.flbasedetailId = flbasedetailId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDwbasedetailId() {
        return dwbasedetailId;
    }

    public void setDwbasedetailId(Integer dwbasedetailId) {
        this.dwbasedetailId = dwbasedetailId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public Date getProducedate() {
        return producedate;
    }

    public void setProducedate(Date producedate) {
        this.producedate = producedate;
    }

    public Date getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(Date effectivedate) {
        this.effectivedate = effectivedate;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getStoragequantity() {
        return storagequantity;
    }

    public void setStoragequantity(String storagequantity) {
        this.storagequantity = storagequantity;
    }

    public String getStoragelocation() {
        return storagelocation;
    }

    public void setStoragelocation(String storagelocation) {
        this.storagelocation = storagelocation;
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
        Drug other = (Drug) that;
        return (this.getDrugId() == null ? other.getDrugId() == null : this.getDrugId().equals(other.getDrugId()))
            && (this.getDrugname() == null ? other.getDrugname() == null : this.getDrugname().equals(other.getDrugname()))
            && (this.getDrugcode() == null ? other.getDrugcode() == null : this.getDrugcode().equals(other.getDrugcode()))
            && (this.getFlbasedetailId() == null ? other.getFlbasedetailId() == null : this.getFlbasedetailId().equals(other.getFlbasedetailId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getDwbasedetailId() == null ? other.getDwbasedetailId() == null : this.getDwbasedetailId().equals(other.getDwbasedetailId()))
            && (this.getSpec() == null ? other.getSpec() == null : this.getSpec().equals(other.getSpec()))
            && (this.getCoefficient() == null ? other.getCoefficient() == null : this.getCoefficient().equals(other.getCoefficient()))
            && (this.getProducedate() == null ? other.getProducedate() == null : this.getProducedate().equals(other.getProducedate()))
            && (this.getEffectivedate() == null ? other.getEffectivedate() == null : this.getEffectivedate().equals(other.getEffectivedate()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getStoragequantity() == null ? other.getStoragequantity() == null : this.getStoragequantity().equals(other.getStoragequantity()))
            && (this.getStoragelocation() == null ? other.getStoragelocation() == null : this.getStoragelocation().equals(other.getStoragelocation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugId() == null) ? 0 : getDrugId().hashCode());
        result = prime * result + ((getDrugname() == null) ? 0 : getDrugname().hashCode());
        result = prime * result + ((getDrugcode() == null) ? 0 : getDrugcode().hashCode());
        result = prime * result + ((getFlbasedetailId() == null) ? 0 : getFlbasedetailId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getDwbasedetailId() == null) ? 0 : getDwbasedetailId().hashCode());
        result = prime * result + ((getSpec() == null) ? 0 : getSpec().hashCode());
        result = prime * result + ((getCoefficient() == null) ? 0 : getCoefficient().hashCode());
        result = prime * result + ((getProducedate() == null) ? 0 : getProducedate().hashCode());
        result = prime * result + ((getEffectivedate() == null) ? 0 : getEffectivedate().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getStoragequantity() == null) ? 0 : getStoragequantity().hashCode());
        result = prime * result + ((getStoragelocation() == null) ? 0 : getStoragelocation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugId=").append(drugId);
        sb.append(", drugname=").append(drugname);
        sb.append(", drugcode=").append(drugcode);
        sb.append(", flbasedetailId=").append(flbasedetailId);
        sb.append(", price=").append(price);
        sb.append(", dwbasedetailId=").append(dwbasedetailId);
        sb.append(", spec=").append(spec);
        sb.append(", coefficient=").append(coefficient);
        sb.append(", producedate=").append(producedate);
        sb.append(", effectivedate=").append(effectivedate);
        sb.append(", companyId=").append(companyId);
        sb.append(", storagequantity=").append(storagequantity);
        sb.append(", storagelocation=").append(storagelocation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}