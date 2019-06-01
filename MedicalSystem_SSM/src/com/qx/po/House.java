package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class House implements Serializable {
    /**
     * 药库ID
     */
    private Integer houseId;

    /**
     * 药库名称
     */
    private String housename;

    /**
     * 是否物质库
     */
    private Boolean bithouse;

    /**
     * 药库单号
     */
    private String drughousecode;

    /**
     * 进库或出库否
     */
    private Boolean enterouthousebit;

    /**
     * 进库日期
     */
    private Date enterdate;

    /**
     * 出库日期
     */
    private Date outdate;

    /**
     * 登记人
     */
    private Integer djuserId;

    /**
     * 审核否
     */
    private Boolean enteroutauditorbit;

    /**
     * 审核人
     */
    private Integer shuserId;

    /**
     * 审核日期
     */
    private Date auditordate;

    private static final long serialVersionUID = 1L;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public Boolean getBithouse() {
        return bithouse;
    }

    public void setBithouse(Boolean bithouse) {
        this.bithouse = bithouse;
    }

    public String getDrughousecode() {
        return drughousecode;
    }

    public void setDrughousecode(String drughousecode) {
        this.drughousecode = drughousecode;
    }

    public Boolean getEnterouthousebit() {
        return enterouthousebit;
    }

    public void setEnterouthousebit(Boolean enterouthousebit) {
        this.enterouthousebit = enterouthousebit;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public Integer getDjuserId() {
        return djuserId;
    }

    public void setDjuserId(Integer djuserId) {
        this.djuserId = djuserId;
    }

    public Boolean getEnteroutauditorbit() {
        return enteroutauditorbit;
    }

    public void setEnteroutauditorbit(Boolean enteroutauditorbit) {
        this.enteroutauditorbit = enteroutauditorbit;
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
        House other = (House) that;
        return (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getHousename() == null ? other.getHousename() == null : this.getHousename().equals(other.getHousename()))
            && (this.getBithouse() == null ? other.getBithouse() == null : this.getBithouse().equals(other.getBithouse()))
            && (this.getDrughousecode() == null ? other.getDrughousecode() == null : this.getDrughousecode().equals(other.getDrughousecode()))
            && (this.getEnterouthousebit() == null ? other.getEnterouthousebit() == null : this.getEnterouthousebit().equals(other.getEnterouthousebit()))
            && (this.getEnterdate() == null ? other.getEnterdate() == null : this.getEnterdate().equals(other.getEnterdate()))
            && (this.getOutdate() == null ? other.getOutdate() == null : this.getOutdate().equals(other.getOutdate()))
            && (this.getDjuserId() == null ? other.getDjuserId() == null : this.getDjuserId().equals(other.getDjuserId()))
            && (this.getEnteroutauditorbit() == null ? other.getEnteroutauditorbit() == null : this.getEnteroutauditorbit().equals(other.getEnteroutauditorbit()))
            && (this.getShuserId() == null ? other.getShuserId() == null : this.getShuserId().equals(other.getShuserId()))
            && (this.getAuditordate() == null ? other.getAuditordate() == null : this.getAuditordate().equals(other.getAuditordate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getHousename() == null) ? 0 : getHousename().hashCode());
        result = prime * result + ((getBithouse() == null) ? 0 : getBithouse().hashCode());
        result = prime * result + ((getDrughousecode() == null) ? 0 : getDrughousecode().hashCode());
        result = prime * result + ((getEnterouthousebit() == null) ? 0 : getEnterouthousebit().hashCode());
        result = prime * result + ((getEnterdate() == null) ? 0 : getEnterdate().hashCode());
        result = prime * result + ((getOutdate() == null) ? 0 : getOutdate().hashCode());
        result = prime * result + ((getDjuserId() == null) ? 0 : getDjuserId().hashCode());
        result = prime * result + ((getEnteroutauditorbit() == null) ? 0 : getEnteroutauditorbit().hashCode());
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
        sb.append(", houseId=").append(houseId);
        sb.append(", housename=").append(housename);
        sb.append(", bithouse=").append(bithouse);
        sb.append(", drughousecode=").append(drughousecode);
        sb.append(", enterouthousebit=").append(enterouthousebit);
        sb.append(", enterdate=").append(enterdate);
        sb.append(", outdate=").append(outdate);
        sb.append(", djuserId=").append(djuserId);
        sb.append(", enteroutauditorbit=").append(enteroutauditorbit);
        sb.append(", shuserId=").append(shuserId);
        sb.append(", auditordate=").append(auditordate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}