package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Ouhosinfo implements Serializable {
    /**
     * 门诊挂号ID
     */
    private Integer ouhosinfoId;

    /**
     * 挂号单号
     */
    private String mzregno;

    /**
     * 挂号时间
     */
    private Date regtime;

    /**
     * 病人ID
     */
    private Integer patientId;

    /**
     * 医生姓名
     */
    private Integer userId;

    /**
     * 挂号科室
     */
    private Integer ksbasedetailId;

    /**
     * 挂号类型
     */
    private Integer lxbasedetailId;

    /**
     * 挂号张数
     */
    private String registerno;

    /**
     * 挂号费
     */
    private Double regfee;

    /**
     * 支付金额
     */
    private Double pay;

    /**
     * 初诊日期
     */
    private Date firstdate;

    /**
     * 就诊科室
     */
    private Integer jzbasedetailId;

    
    
    /**
     * 病人信息表
     */
    private String patientname;
    
    private String cardno;
    
    private String socialsecurityno;
    
    /**
     * 医生姓名
     */
    private String username;
    
    
    
    
    private static final long serialVersionUID = 1L;

    public Integer getOuhosinfoId() {
        return ouhosinfoId;
    }

    public void setOuhosinfoId(Integer ouhosinfoId) {
        this.ouhosinfoId = ouhosinfoId;
    }

    public String getMzregno() {
        return mzregno;
    }

    public void setMzregno(String mzregno) {
        this.mzregno = mzregno;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getKsbasedetailId() {
        return ksbasedetailId;
    }

    public void setKsbasedetailId(Integer ksbasedetailId) {
        this.ksbasedetailId = ksbasedetailId;
    }

    public Integer getLxbasedetailId() {
        return lxbasedetailId;
    }

    public void setLxbasedetailId(Integer lxbasedetailId) {
        this.lxbasedetailId = lxbasedetailId;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    public Double getRegfee() {
        return regfee;
    }

    public void setRegfee(Double regfee) {
        this.regfee = regfee;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Date getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(Date firstdate) {
        this.firstdate = firstdate;
    }

    public Integer getJzbasedetailId() {
        return jzbasedetailId;
    }

    public void setJzbasedetailId(Integer jzbasedetailId) {
        this.jzbasedetailId = jzbasedetailId;
    }
    
    
    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }
    
    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }
    
    public String getSocialsecurityno() {
        return socialsecurityno;
    }

    public void setSocialsecurityno(String socialsecurityno) {
        this.socialsecurityno = socialsecurityno;
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
        Ouhosinfo other = (Ouhosinfo) that;
        return (this.getOuhosinfoId() == null ? other.getOuhosinfoId() == null : this.getOuhosinfoId().equals(other.getOuhosinfoId()))
            && (this.getMzregno() == null ? other.getMzregno() == null : this.getMzregno().equals(other.getMzregno()))
            && (this.getRegtime() == null ? other.getRegtime() == null : this.getRegtime().equals(other.getRegtime()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getKsbasedetailId() == null ? other.getKsbasedetailId() == null : this.getKsbasedetailId().equals(other.getKsbasedetailId()))
            && (this.getLxbasedetailId() == null ? other.getLxbasedetailId() == null : this.getLxbasedetailId().equals(other.getLxbasedetailId()))
            && (this.getRegisterno() == null ? other.getRegisterno() == null : this.getRegisterno().equals(other.getRegisterno()))
            && (this.getRegfee() == null ? other.getRegfee() == null : this.getRegfee().equals(other.getRegfee()))
            && (this.getPay() == null ? other.getPay() == null : this.getPay().equals(other.getPay()))
            && (this.getFirstdate() == null ? other.getFirstdate() == null : this.getFirstdate().equals(other.getFirstdate()))
            && (this.getJzbasedetailId() == null ? other.getJzbasedetailId() == null : this.getJzbasedetailId().equals(other.getJzbasedetailId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOuhosinfoId() == null) ? 0 : getOuhosinfoId().hashCode());
        result = prime * result + ((getMzregno() == null) ? 0 : getMzregno().hashCode());
        result = prime * result + ((getRegtime() == null) ? 0 : getRegtime().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getKsbasedetailId() == null) ? 0 : getKsbasedetailId().hashCode());
        result = prime * result + ((getLxbasedetailId() == null) ? 0 : getLxbasedetailId().hashCode());
        result = prime * result + ((getRegisterno() == null) ? 0 : getRegisterno().hashCode());
        result = prime * result + ((getRegfee() == null) ? 0 : getRegfee().hashCode());
        result = prime * result + ((getPay() == null) ? 0 : getPay().hashCode());
        result = prime * result + ((getFirstdate() == null) ? 0 : getFirstdate().hashCode());
        result = prime * result + ((getJzbasedetailId() == null) ? 0 : getJzbasedetailId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ouhosinfoId=").append(ouhosinfoId);
        sb.append(", mzregno=").append(mzregno);
        sb.append(", regtime=").append(regtime);
        sb.append(", patientId=").append(patientId);
        sb.append(", userId=").append(userId);
        sb.append(", ksbasedetailId=").append(ksbasedetailId);
        sb.append(", lxbasedetailId=").append(lxbasedetailId);
        sb.append(", registerno=").append(registerno);
        sb.append(", regfee=").append(regfee);
        sb.append(", pay=").append(pay);
        sb.append(", firstdate=").append(firstdate);
        sb.append(", jzbasedetailId=").append(jzbasedetailId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}