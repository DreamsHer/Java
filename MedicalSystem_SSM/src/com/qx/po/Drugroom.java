package com.qx.po;

import java.io.Serializable;

/**
 * @author 
 */
public class Drugroom implements Serializable {
    /**
     * 药房ID
     */
    private Integer drugroomId;

    /**
     * 药房名称
     */
    private String drugroomname;

    /**
     * 药房分类、科室代码
     */
    private Integer flbasedetailId;

    private Integer ksbasedetailId;

    /**
     * 显示顺序
     */
    private String displayorder;

    /**
     * 是否药房
     */
    private Boolean bitroom;

    /**
     * 药品ID
     */
    private Integer drugId;

    private static final long serialVersionUID = 1L;

    public Integer getDrugroomId() {
        return drugroomId;
    }

    public void setDrugroomId(Integer drugroomId) {
        this.drugroomId = drugroomId;
    }

    public String getDrugroomname() {
        return drugroomname;
    }

    public void setDrugroomname(String drugroomname) {
        this.drugroomname = drugroomname;
    }

    public Integer getFlbasedetailId() {
        return flbasedetailId;
    }

    public void setFlbasedetailId(Integer flbasedetailId) {
        this.flbasedetailId = flbasedetailId;
    }

    public Integer getKsbasedetailId() {
        return ksbasedetailId;
    }

    public void setKsbasedetailId(Integer ksbasedetailId) {
        this.ksbasedetailId = ksbasedetailId;
    }

    public String getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(String displayorder) {
        this.displayorder = displayorder;
    }

    public Boolean getBitroom() {
        return bitroom;
    }

    public void setBitroom(Boolean bitroom) {
        this.bitroom = bitroom;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
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
        Drugroom other = (Drugroom) that;
        return (this.getDrugroomId() == null ? other.getDrugroomId() == null : this.getDrugroomId().equals(other.getDrugroomId()))
            && (this.getDrugroomname() == null ? other.getDrugroomname() == null : this.getDrugroomname().equals(other.getDrugroomname()))
            && (this.getFlbasedetailId() == null ? other.getFlbasedetailId() == null : this.getFlbasedetailId().equals(other.getFlbasedetailId()))
            && (this.getKsbasedetailId() == null ? other.getKsbasedetailId() == null : this.getKsbasedetailId().equals(other.getKsbasedetailId()))
            && (this.getDisplayorder() == null ? other.getDisplayorder() == null : this.getDisplayorder().equals(other.getDisplayorder()))
            && (this.getBitroom() == null ? other.getBitroom() == null : this.getBitroom().equals(other.getBitroom()))
            && (this.getDrugId() == null ? other.getDrugId() == null : this.getDrugId().equals(other.getDrugId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugroomId() == null) ? 0 : getDrugroomId().hashCode());
        result = prime * result + ((getDrugroomname() == null) ? 0 : getDrugroomname().hashCode());
        result = prime * result + ((getFlbasedetailId() == null) ? 0 : getFlbasedetailId().hashCode());
        result = prime * result + ((getKsbasedetailId() == null) ? 0 : getKsbasedetailId().hashCode());
        result = prime * result + ((getDisplayorder() == null) ? 0 : getDisplayorder().hashCode());
        result = prime * result + ((getBitroom() == null) ? 0 : getBitroom().hashCode());
        result = prime * result + ((getDrugId() == null) ? 0 : getDrugId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugroomId=").append(drugroomId);
        sb.append(", drugroomname=").append(drugroomname);
        sb.append(", flbasedetailId=").append(flbasedetailId);
        sb.append(", ksbasedetailId=").append(ksbasedetailId);
        sb.append(", displayorder=").append(displayorder);
        sb.append(", bitroom=").append(bitroom);
        sb.append(", drugId=").append(drugId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}