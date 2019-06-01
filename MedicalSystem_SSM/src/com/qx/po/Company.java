package com.qx.po;

import java.io.Serializable;

/**
 * @author 
 */
public class Company implements Serializable {
    /**
     * 供应商ID
     */
    private Integer companyId;

    /**
     * 供应商号
     */
    private String companycode;

    /**
     * 供应商名
     */
    private String companyname;

    /**
     * 联系电话
     */
    private String compphone;

    /**
     * 地址
     */
    private String compaddre;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 银行账号
     */
    private String bankaccount;

    /**
     * 法人代表
     */
    private String compcorpo;

    /**
     * 供货商单位许可证书
     */
    private String licencecode;

    private static final long serialVersionUID = 1L;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompphone() {
        return compphone;
    }

    public void setCompphone(String compphone) {
        this.compphone = compphone;
    }

    public String getCompaddre() {
        return compaddre;
    }

    public void setCompaddre(String compaddre) {
        this.compaddre = compaddre;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getCompcorpo() {
        return compcorpo;
    }

    public void setCompcorpo(String compcorpo) {
        this.compcorpo = compcorpo;
    }

    public String getLicencecode() {
        return licencecode;
    }

    public void setLicencecode(String licencecode) {
        this.licencecode = licencecode;
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
        Company other = (Company) that;
        return (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanycode() == null ? other.getCompanycode() == null : this.getCompanycode().equals(other.getCompanycode()))
            && (this.getCompanyname() == null ? other.getCompanyname() == null : this.getCompanyname().equals(other.getCompanyname()))
            && (this.getCompphone() == null ? other.getCompphone() == null : this.getCompphone().equals(other.getCompphone()))
            && (this.getCompaddre() == null ? other.getCompaddre() == null : this.getCompaddre().equals(other.getCompaddre()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getBankaccount() == null ? other.getBankaccount() == null : this.getBankaccount().equals(other.getBankaccount()))
            && (this.getCompcorpo() == null ? other.getCompcorpo() == null : this.getCompcorpo().equals(other.getCompcorpo()))
            && (this.getLicencecode() == null ? other.getLicencecode() == null : this.getLicencecode().equals(other.getLicencecode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanycode() == null) ? 0 : getCompanycode().hashCode());
        result = prime * result + ((getCompanyname() == null) ? 0 : getCompanyname().hashCode());
        result = prime * result + ((getCompphone() == null) ? 0 : getCompphone().hashCode());
        result = prime * result + ((getCompaddre() == null) ? 0 : getCompaddre().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getBankaccount() == null) ? 0 : getBankaccount().hashCode());
        result = prime * result + ((getCompcorpo() == null) ? 0 : getCompcorpo().hashCode());
        result = prime * result + ((getLicencecode() == null) ? 0 : getLicencecode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", companyId=").append(companyId);
        sb.append(", companycode=").append(companycode);
        sb.append(", companyname=").append(companyname);
        sb.append(", compphone=").append(compphone);
        sb.append(", compaddre=").append(compaddre);
        sb.append(", bank=").append(bank);
        sb.append(", bankaccount=").append(bankaccount);
        sb.append(", compcorpo=").append(compcorpo);
        sb.append(", licencecode=").append(licencecode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}