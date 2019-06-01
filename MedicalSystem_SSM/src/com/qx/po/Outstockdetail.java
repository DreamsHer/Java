package com.qx.po;

import java.io.Serializable;

/**
 * @author 
 */
public class Outstockdetail implements Serializable {
    private Integer outstockdetailId;

    private Integer outstockId;

    private Integer enterstockdetailId;

    private String currentbalance;

    private Double balancemoney;

    private String outstocknum;

    private static final long serialVersionUID = 1L;

    public Integer getOutstockdetailId() {
        return outstockdetailId;
    }

    public void setOutstockdetailId(Integer outstockdetailId) {
        this.outstockdetailId = outstockdetailId;
    }

    public Integer getOutstockId() {
        return outstockId;
    }

    public void setOutstockId(Integer outstockId) {
        this.outstockId = outstockId;
    }

    public Integer getEnterstockdetailId() {
        return enterstockdetailId;
    }

    public void setEnterstockdetailId(Integer enterstockdetailId) {
        this.enterstockdetailId = enterstockdetailId;
    }

    public String getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(String currentbalance) {
        this.currentbalance = currentbalance;
    }

    public Double getBalancemoney() {
        return balancemoney;
    }

    public void setBalancemoney(Double balancemoney) {
        this.balancemoney = balancemoney;
    }

    public String getOutstocknum() {
        return outstocknum;
    }

    public void setOutstocknum(String outstocknum) {
        this.outstocknum = outstocknum;
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
        Outstockdetail other = (Outstockdetail) that;
        return (this.getOutstockdetailId() == null ? other.getOutstockdetailId() == null : this.getOutstockdetailId().equals(other.getOutstockdetailId()))
            && (this.getOutstockId() == null ? other.getOutstockId() == null : this.getOutstockId().equals(other.getOutstockId()))
            && (this.getEnterstockdetailId() == null ? other.getEnterstockdetailId() == null : this.getEnterstockdetailId().equals(other.getEnterstockdetailId()))
            && (this.getCurrentbalance() == null ? other.getCurrentbalance() == null : this.getCurrentbalance().equals(other.getCurrentbalance()))
            && (this.getBalancemoney() == null ? other.getBalancemoney() == null : this.getBalancemoney().equals(other.getBalancemoney()))
            && (this.getOutstocknum() == null ? other.getOutstocknum() == null : this.getOutstocknum().equals(other.getOutstocknum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOutstockdetailId() == null) ? 0 : getOutstockdetailId().hashCode());
        result = prime * result + ((getOutstockId() == null) ? 0 : getOutstockId().hashCode());
        result = prime * result + ((getEnterstockdetailId() == null) ? 0 : getEnterstockdetailId().hashCode());
        result = prime * result + ((getCurrentbalance() == null) ? 0 : getCurrentbalance().hashCode());
        result = prime * result + ((getBalancemoney() == null) ? 0 : getBalancemoney().hashCode());
        result = prime * result + ((getOutstocknum() == null) ? 0 : getOutstocknum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", outstockdetailId=").append(outstockdetailId);
        sb.append(", outstockId=").append(outstockId);
        sb.append(", enterstockdetailId=").append(enterstockdetailId);
        sb.append(", currentbalance=").append(currentbalance);
        sb.append(", balancemoney=").append(balancemoney);
        sb.append(", outstocknum=").append(outstocknum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}