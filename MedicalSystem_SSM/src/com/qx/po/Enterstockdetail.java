package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Enterstockdetail implements Serializable {
    /**
     * 进库明细ID
     */
    private Integer enterstockdetailId;

    /**
     * 进库ID
     */
    private Integer enterstockId;

    /**
     * 进货明细ID
     */
    private Integer stockdetailId;

    /**
     * 进库数量
     */
    private String enterstocknum;

    /**
     * 进库金额
     */
    private Double enterstockmoney;
       
    /* 外键表字段*/
    /**
     * 进库单号
     */
    private String enterstockcode;

    /**
     * 进库时间
     */
    private Date enterdate;
    
    private String enterdates;

    /**
     * 登记人ID
     */
    private Integer djuserId;

    /**
     * 审核否
     */
    private Boolean enterauditorbit;
    
    /**
     * 供应商名
     */
    private String companyname;
    
    /**
     * 药品名称
     */
    private String drugname;
    
    /**
     * 进货数量
     */
    private String stocknum;
    
    /**
     * 用户名
     */
    private String username;
    

    private static final long serialVersionUID = 1L;

    public Integer getEnterstockdetailId() {
        return enterstockdetailId;
    }

    public void setEnterstockdetailId(Integer enterstockdetailId) {
        this.enterstockdetailId = enterstockdetailId;
    }

    public Integer getEnterstockId() {
        return enterstockId;
    }

    public void setEnterstockId(Integer enterstockId) {
        this.enterstockId = enterstockId;
    }

    public Integer getStockdetailId() {
        return stockdetailId;
    }

    public void setStockdetailId(Integer stockdetailId) {
        this.stockdetailId = stockdetailId;
    }

    public String getEnterstocknum() {
        return enterstocknum;
    }

    public void setEnterstocknum(String enterstocknum) {
        this.enterstocknum = enterstocknum;
    }

    public Double getEnterstockmoney() {
        return enterstockmoney;
    }

    public void setEnterstockmoney(Double enterstockmoney) {
        this.enterstockmoney = enterstockmoney;
    }
    
    
    public String getEnterstockcode() {
        return enterstockcode;
    }

    public void setEnterstockcode(String enterstockcode) {
        this.enterstockcode = enterstockcode;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public Integer getDjuserId() {
        return djuserId;
    }

    public void setDjuserId(Integer djuserId) {
        this.djuserId = djuserId;
    }

    public Boolean getEnterauditorbit() {
        return enterauditorbit;
    }

    public void setEnterauditorbit(Boolean enterauditorbit) {
        this.enterauditorbit = enterauditorbit;
    }
    
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
    
    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }
    
    public String getEnterdates() {
        return enterdates;
    }

    public void setEnterdates(String enterdates) {
        this.enterdates = enterdates;
    }
    
    public String getStocknum() {
        return stocknum;
    }

    public void setStocknum(String stocknum) {
        this.stocknum = stocknum;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        Enterstockdetail other = (Enterstockdetail) that;
        return (this.getEnterstockdetailId() == null ? other.getEnterstockdetailId() == null : this.getEnterstockdetailId().equals(other.getEnterstockdetailId()))
            && (this.getEnterstockId() == null ? other.getEnterstockId() == null : this.getEnterstockId().equals(other.getEnterstockId()))
            && (this.getStockdetailId() == null ? other.getStockdetailId() == null : this.getStockdetailId().equals(other.getStockdetailId()))
            && (this.getEnterstocknum() == null ? other.getEnterstocknum() == null : this.getEnterstocknum().equals(other.getEnterstocknum()))
            && (this.getEnterstockmoney() == null ? other.getEnterstockmoney() == null : this.getEnterstockmoney().equals(other.getEnterstockmoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEnterstockdetailId() == null) ? 0 : getEnterstockdetailId().hashCode());
        result = prime * result + ((getEnterstockId() == null) ? 0 : getEnterstockId().hashCode());
        result = prime * result + ((getStockdetailId() == null) ? 0 : getStockdetailId().hashCode());
        result = prime * result + ((getEnterstocknum() == null) ? 0 : getEnterstocknum().hashCode());
        result = prime * result + ((getEnterstockmoney() == null) ? 0 : getEnterstockmoney().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", enterstockdetailId=").append(enterstockdetailId);
        sb.append(", enterstockId=").append(enterstockId);
        sb.append(", stockdetailId=").append(stockdetailId);
        sb.append(", enterstocknum=").append(enterstocknum);
        sb.append(", enterstockmoney=").append(enterstockmoney);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}