package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Enterstock implements Serializable {
    /**
     * 进库ID
     */
    private Integer enterstockId;

    /**
     * 进库单号
     */
    private String enterstockcode;

    /**
     * 进库时间
     */
    private Date enterdate;

    /**
     * 登记人ID
     */
    private Integer djuserId;

    /**
     * 审核否
     */
    private Boolean enterauditorbit;
    
   /* private Byte enterauditorbit;*/

    /**
     * 审核人ID
     */
    private Integer shuserId;

    /**
     * 审核时间
     */
    private Date auditordate;

    private static final long serialVersionUID = 1L;

    public Integer getEnterstockId() {
        return enterstockId;
    }

    public void setEnterstockId(Integer enterstockId) {
        this.enterstockId = enterstockId;
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
    
   /* public Byte getEnterauditorbit() {
        return enterauditorbit;
    }

    public void setEnterauditorbit(Byte enterauditorbit) {
        this.enterauditorbit = enterauditorbit;
    }
*/
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
        Enterstock other = (Enterstock) that;
        return (this.getEnterstockId() == null ? other.getEnterstockId() == null : this.getEnterstockId().equals(other.getEnterstockId()))
            && (this.getEnterstockcode() == null ? other.getEnterstockcode() == null : this.getEnterstockcode().equals(other.getEnterstockcode()))
            && (this.getEnterdate() == null ? other.getEnterdate() == null : this.getEnterdate().equals(other.getEnterdate()))
            && (this.getDjuserId() == null ? other.getDjuserId() == null : this.getDjuserId().equals(other.getDjuserId()))
            && (this.getEnterauditorbit() == null ? other.getEnterauditorbit() == null : this.getEnterauditorbit().equals(other.getEnterauditorbit()))
            && (this.getShuserId() == null ? other.getShuserId() == null : this.getShuserId().equals(other.getShuserId()))
            && (this.getAuditordate() == null ? other.getAuditordate() == null : this.getAuditordate().equals(other.getAuditordate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEnterstockId() == null) ? 0 : getEnterstockId().hashCode());
        result = prime * result + ((getEnterstockcode() == null) ? 0 : getEnterstockcode().hashCode());
        result = prime * result + ((getEnterdate() == null) ? 0 : getEnterdate().hashCode());
        result = prime * result + ((getDjuserId() == null) ? 0 : getDjuserId().hashCode());
        result = prime * result + ((getEnterauditorbit() == null) ? 0 : getEnterauditorbit().hashCode());
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
        sb.append(", enterstockId=").append(enterstockId);
        sb.append(", enterstockcode=").append(enterstockcode);
        sb.append(", enterdate=").append(enterdate);
        sb.append(", djuserId=").append(djuserId);
        sb.append(", enterauditorbit=").append(enterauditorbit);
        sb.append(", shuserId=").append(shuserId);
        sb.append(", auditordate=").append(auditordate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}