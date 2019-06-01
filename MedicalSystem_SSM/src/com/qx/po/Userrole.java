package com.qx.po;

import java.io.Serializable;

/**
 * @author 
 */
public class Userrole implements Serializable {
    /**
     * 角色类型ID
     */
    private Integer userroleId;

    /**
     * 角色名称
     */
    private String userrolename;

    /**
     * 科室类型ID
     */
    private Integer basedetailId;

    private static final long serialVersionUID = 1L;

    public Integer getUserroleId() {
        return userroleId;
    }

    public void setUserroleId(Integer userroleId) {
        this.userroleId = userroleId;
    }

    public String getUserrolename() {
        return userrolename;
    }

    public void setUserrolename(String userrolename) {
        this.userrolename = userrolename;
    }

    public Integer getBasedetailId() {
        return basedetailId;
    }

    public void setBasedetailId(Integer basedetailId) {
        this.basedetailId = basedetailId;
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
        Userrole other = (Userrole) that;
        return (this.getUserroleId() == null ? other.getUserroleId() == null : this.getUserroleId().equals(other.getUserroleId()))
            && (this.getUserrolename() == null ? other.getUserrolename() == null : this.getUserrolename().equals(other.getUserrolename()))
            && (this.getBasedetailId() == null ? other.getBasedetailId() == null : this.getBasedetailId().equals(other.getBasedetailId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserroleId() == null) ? 0 : getUserroleId().hashCode());
        result = prime * result + ((getUserrolename() == null) ? 0 : getUserrolename().hashCode());
        result = prime * result + ((getBasedetailId() == null) ? 0 : getBasedetailId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userroleId=").append(userroleId);
        sb.append(", userrolename=").append(userrolename);
        sb.append(", basedetailId=").append(basedetailId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}