package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Outstock implements Serializable {
    /**
     * 出库ID
     */
    private Integer outstockId;

    /**
     * 出库单号
     */
    private String outstockcode;

    /**
     * 领药药房
     */
    private Integer drugroomId;

    /**
     * 出库类型
     */
    private Integer ckbasedetailId;

    /**
     * 登记人ID
     */
    private Integer djuserId;

    /**
     * 出库日期
     */
    private Date outdate;

    /**
     * 审核否
     */
    private Boolean eoutauditorbit;

    /**
     * 审核人ID
     */
    private Integer shuserId;

    /**
     * 审核时间
     */
    private Date auditordate;

    private static final long serialVersionUID = 1L;

    public Integer getOutstockId() {
        return outstockId;
    }

    public void setOutstockId(Integer outstockId) {
        this.outstockId = outstockId;
    }

    public String getOutstockcode() {
        return outstockcode;
    }

    public void setOutstockcode(String outstockcode) {
        this.outstockcode = outstockcode;
    }

    public Integer getDrugroomId() {
        return drugroomId;
    }

    public void setDrugroomId(Integer drugroomId) {
        this.drugroomId = drugroomId;
    }

    public Integer getCkbasedetailId() {
        return ckbasedetailId;
    }

    public void setCkbasedetailId(Integer ckbasedetailId) {
        this.ckbasedetailId = ckbasedetailId;
    }

    public Integer getDjuserId() {
        return djuserId;
    }

    public void setDjuserId(Integer djuserId) {
        this.djuserId = djuserId;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public Boolean getEoutauditorbit() {
        return eoutauditorbit;
    }

    public void setEoutauditorbit(Boolean eoutauditorbit) {
        this.eoutauditorbit = eoutauditorbit;
    }

    public Integer getShuserId() {
        return shuserId;
    }

    public void setShuserId(Integer shuserId) {
        this.shuserId = shuserId;
    }

    public Date getAuditordate() {
        return auditordate;
    }

    public void setAuditordate(Date auditordate) {
        this.auditordate = auditordate;
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
        Outstock other = (Outstock) that;
        return (this.getOutstockId() == null ? other.getOutstockId() == null : this.getOutstockId().equals(other.getOutstockId()))
            && (this.getOutstockcode() == null ? other.getOutstockcode() == null : this.getOutstockcode().equals(other.getOutstockcode()))
            && (this.getDrugroomId() == null ? other.getDrugroomId() == null : this.getDrugroomId().equals(other.getDrugroomId()))
            && (this.getCkbasedetailId() == null ? other.getCkbasedetailId() == null : this.getCkbasedetailId().equals(other.getCkbasedetailId()))
            && (this.getDjuserId() == null ? other.getDjuserId() == null : this.getDjuserId().equals(other.getDjuserId()))
            && (this.getOutdate() == null ? other.getOutdate() == null : this.getOutdate().equals(other.getOutdate()))
            && (this.getEoutauditorbit() == null ? other.getEoutauditorbit() == null : this.getEoutauditorbit().equals(other.getEoutauditorbit()))
            && (this.getShuserId() == null ? other.getShuserId() == null : this.getShuserId().equals(other.getShuserId()))
            && (this.getAuditordate() == null ? other.getAuditordate() == null : this.getAuditordate().equals(other.getAuditordate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOutstockId() == null) ? 0 : getOutstockId().hashCode());
        result = prime * result + ((getOutstockcode() == null) ? 0 : getOutstockcode().hashCode());
        result = prime * result + ((getDrugroomId() == null) ? 0 : getDrugroomId().hashCode());
        result = prime * result + ((getCkbasedetailId() == null) ? 0 : getCkbasedetailId().hashCode());
        result = prime * result + ((getDjuserId() == null) ? 0 : getDjuserId().hashCode());
        result = prime * result + ((getOutdate() == null) ? 0 : getOutdate().hashCode());
        result = prime * result + ((getEoutauditorbit() == null) ? 0 : getEoutauditorbit().hashCode());
        result = prime * result + ((getShuserId() == null) ? 0 : getShuserId().hashCode());
        result = prime * result + ((getAuditordate() == null) ? 0 : getAuditordate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", outstockId=").append(outstockId);
        sb.append(", outstockcode=").append(outstockcode);
        sb.append(", drugroomId=").append(drugroomId);
        sb.append(", ckbasedetailId=").append(ckbasedetailId);
        sb.append(", djuserId=").append(djuserId);
        sb.append(", outdate=").append(outdate);
        sb.append(", eoutauditorbit=").append(eoutauditorbit);
        sb.append(", shuserId=").append(shuserId);
        sb.append(", auditordate=").append(auditordate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}