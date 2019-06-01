package com.qx.po;

import java.io.Serializable;

/**
 * @author 
 */
public class Basedetail implements Serializable {
    /**
     * 基础明细ID
     */
    private Integer basedetailId;

    /**
     * 基础类型ID
     */
    private Integer basetypeId; 
    /**
     * 基础明细名称
     */
    private String basedetailname;

    private static final long serialVersionUID = 1L;

    public Integer getBasedetailId() {
        return basedetailId;
    }

    public void setBasedetailId(Integer basedetailId) {
        this.basedetailId = basedetailId;
    }

    public Integer getBasetypeId() {
        return basetypeId;
    }

    public void setBasetypeId(Integer basetypeId) {
        this.basetypeId = basetypeId;
    }

    public String getBasedetailname() {
        return basedetailname;
    }

    public void setBasedetailname(String basedetailname) {
        this.basedetailname = basedetailname;
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
        Basedetail other = (Basedetail) that;
        return (this.getBasedetailId() == null ? other.getBasedetailId() == null : this.getBasedetailId().equals(other.getBasedetailId()))
            && (this.getBasetypeId() == null ? other.getBasetypeId() == null : this.getBasetypeId().equals(other.getBasetypeId()))
            && (this.getBasedetailname() == null ? other.getBasedetailname() == null : this.getBasedetailname().equals(other.getBasedetailname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBasedetailId() == null) ? 0 : getBasedetailId().hashCode());
        result = prime * result + ((getBasetypeId() == null) ? 0 : getBasetypeId().hashCode());
        result = prime * result + ((getBasedetailname() == null) ? 0 : getBasedetailname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", basedetailId=").append(basedetailId);
        sb.append(", basetypeId=").append(basetypeId);
        sb.append(", basedetailname=").append(basedetailname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}