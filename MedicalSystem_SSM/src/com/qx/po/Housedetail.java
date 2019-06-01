package com.qx.po;

import java.io.Serializable;

/**
 * @author 
 */
public class Housedetail implements Serializable {
    /**
     * 药库单明细ID
     */
    private Integer housedetailId;

    /**
     * 药库ID
     */
    private Integer houseId;

    /**
     * 存储位置
     */
    private String storagelocation;

    /**
     * 有效标志
     */
    private String effectivesign;

    /**
     * 进货明细ID
     */
    private Integer stockdetailId;

    /**
     * 领药药房
     */
    private Integer lybasedetailId;

    /**
     * 出库类型
     */
    private Integer ckbasedetailId;

    /**
     * 当前库存
     */
    private String currentbalance;

    /**
     * 结存零售价
     */
    private Float balanceretail;

    private static final long serialVersionUID = 1L;

    public Integer getHousedetailId() {
        return housedetailId;
    }

    public void setHousedetailId(Integer housedetailId) {
        this.housedetailId = housedetailId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getStoragelocation() {
        return storagelocation;
    }

    public void setStoragelocation(String storagelocation) {
        this.storagelocation = storagelocation;
    }

    public String getEffectivesign() {
        return effectivesign;
    }

    public void setEffectivesign(String effectivesign) {
        this.effectivesign = effectivesign;
    }

    public Integer getStockdetailId() {
        return stockdetailId;
    }

    public void setStockdetailId(Integer stockdetailId) {
        this.stockdetailId = stockdetailId;
    }

    public Integer getLybasedetailId() {
        return lybasedetailId;
    }

    public void setLybasedetailId(Integer lybasedetailId) {
        this.lybasedetailId = lybasedetailId;
    }

    public Integer getCkbasedetailId() {
        return ckbasedetailId;
    }

    public void setCkbasedetailId(Integer ckbasedetailId) {
        this.ckbasedetailId = ckbasedetailId;
    }

    public String getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(String currentbalance) {
        this.currentbalance = currentbalance;
    }

    public Float getBalanceretail() {
        return balanceretail;
    }

    public void setBalanceretail(Float balanceretail) {
        this.balanceretail = balanceretail;
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
        Housedetail other = (Housedetail) that;
        return (this.getHousedetailId() == null ? other.getHousedetailId() == null : this.getHousedetailId().equals(other.getHousedetailId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getStoragelocation() == null ? other.getStoragelocation() == null : this.getStoragelocation().equals(other.getStoragelocation()))
            && (this.getEffectivesign() == null ? other.getEffectivesign() == null : this.getEffectivesign().equals(other.getEffectivesign()))
            && (this.getStockdetailId() == null ? other.getStockdetailId() == null : this.getStockdetailId().equals(other.getStockdetailId()))
            && (this.getLybasedetailId() == null ? other.getLybasedetailId() == null : this.getLybasedetailId().equals(other.getLybasedetailId()))
            && (this.getCkbasedetailId() == null ? other.getCkbasedetailId() == null : this.getCkbasedetailId().equals(other.getCkbasedetailId()))
            && (this.getCurrentbalance() == null ? other.getCurrentbalance() == null : this.getCurrentbalance().equals(other.getCurrentbalance()))
            && (this.getBalanceretail() == null ? other.getBalanceretail() == null : this.getBalanceretail().equals(other.getBalanceretail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHousedetailId() == null) ? 0 : getHousedetailId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getStoragelocation() == null) ? 0 : getStoragelocation().hashCode());
        result = prime * result + ((getEffectivesign() == null) ? 0 : getEffectivesign().hashCode());
        result = prime * result + ((getStockdetailId() == null) ? 0 : getStockdetailId().hashCode());
        result = prime * result + ((getLybasedetailId() == null) ? 0 : getLybasedetailId().hashCode());
        result = prime * result + ((getCkbasedetailId() == null) ? 0 : getCkbasedetailId().hashCode());
        result = prime * result + ((getCurrentbalance() == null) ? 0 : getCurrentbalance().hashCode());
        result = prime * result + ((getBalanceretail() == null) ? 0 : getBalanceretail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", housedetailId=").append(housedetailId);
        sb.append(", houseId=").append(houseId);
        sb.append(", storagelocation=").append(storagelocation);
        sb.append(", effectivesign=").append(effectivesign);
        sb.append(", stockdetailId=").append(stockdetailId);
        sb.append(", lybasedetailId=").append(lybasedetailId);
        sb.append(", ckbasedetailId=").append(ckbasedetailId);
        sb.append(", currentbalance=").append(currentbalance);
        sb.append(", balanceretail=").append(balanceretail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}