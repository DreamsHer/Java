package com.qx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Patient implements Serializable {
    /**
     * 病人信息
     */
    private Integer patientId;

    /**
     * 病人编码
     */
    private String patientcode;

    /**
     * 医疗卡号
     */
    private String cardno;

    /**
     * 社保障号
     */
    private String socialsecurityno;

    /**
     * 病人姓名
     */
    private String patientname;

    /**
     * 性别
     */
    private Integer basedetailId1;

    /**
     * 婚姻状况
     */
    private Integer basedetailId2;

    /**
     * 血型
     */
    private Integer basedetailId3;

    /**
     * 病人类别
     */
    private Integer basedetailId4;

    /**
     * 年龄
     */
    private String age;

    /**
     * 身高
     */
    private String height;

    /**
     * 体重
     */
    private String weight;

    /**
     * 民族
     */
    private String nationid;

    /**
     * 身份证号
     */
    private String certificateid;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 工作单位
     */
    private String company;

    /**
     * 家庭地址
     */
    private String residence;

    /**
     * 家庭电话
     */
    private String phonehome;

    /**
     * 联系人
     */
    private String linkmanname;

    /**
     * 过敏药物
     */
    private String allergydrugs;

    /**
     * 饮食习惯
     */
    private String lsbithabit;

    /**
     * 非活动的原因
     */
    private String inactivereason;

    /**
     * 录入人
     */
    private Integer userId;

    /**
     * 录入时间
     */
    private Date opertime;

    private static final long serialVersionUID = 1L;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientcode() {
        return patientcode;
    }

    public void setPatientcode(String patientcode) {
        this.patientcode = patientcode;
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

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Integer getBasedetailId1() {
        return basedetailId1;
    }

    public void setBasedetailId1(Integer basedetailId1) {
        this.basedetailId1 = basedetailId1;
    }

    public Integer getBasedetailId2() {
        return basedetailId2;
    }

    public void setBasedetailId2(Integer basedetailId2) {
        this.basedetailId2 = basedetailId2;
    }

    public Integer getBasedetailId3() {
        return basedetailId3;
    }

    public void setBasedetailId3(Integer basedetailId3) {
        this.basedetailId3 = basedetailId3;
    }

    public Integer getBasedetailId4() {
        return basedetailId4;
    }

    public void setBasedetailId4(Integer basedetailId4) {
        this.basedetailId4 = basedetailId4;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNationid() {
        return nationid;
    }

    public void setNationid(String nationid) {
        this.nationid = nationid;
    }

    public String getCertificateid() {
        return certificateid;
    }

    public void setCertificateid(String certificateid) {
        this.certificateid = certificateid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPhonehome() {
        return phonehome;
    }

    public void setPhonehome(String phonehome) {
        this.phonehome = phonehome;
    }

    public String getLinkmanname() {
        return linkmanname;
    }

    public void setLinkmanname(String linkmanname) {
        this.linkmanname = linkmanname;
    }

    public String getAllergydrugs() {
        return allergydrugs;
    }

    public void setAllergydrugs(String allergydrugs) {
        this.allergydrugs = allergydrugs;
    }

    public String getLsbithabit() {
        return lsbithabit;
    }

    public void setLsbithabit(String lsbithabit) {
        this.lsbithabit = lsbithabit;
    }

    public String getInactivereason() {
        return inactivereason;
    }

    public void setInactivereason(String inactivereason) {
        this.inactivereason = inactivereason;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
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
        Patient other = (Patient) that;
        return (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getPatientcode() == null ? other.getPatientcode() == null : this.getPatientcode().equals(other.getPatientcode()))
            && (this.getCardno() == null ? other.getCardno() == null : this.getCardno().equals(other.getCardno()))
            && (this.getSocialsecurityno() == null ? other.getSocialsecurityno() == null : this.getSocialsecurityno().equals(other.getSocialsecurityno()))
            && (this.getPatientname() == null ? other.getPatientname() == null : this.getPatientname().equals(other.getPatientname()))
            && (this.getBasedetailId1() == null ? other.getBasedetailId1() == null : this.getBasedetailId1().equals(other.getBasedetailId1()))
            && (this.getBasedetailId2() == null ? other.getBasedetailId2() == null : this.getBasedetailId2().equals(other.getBasedetailId2()))
            && (this.getBasedetailId3() == null ? other.getBasedetailId3() == null : this.getBasedetailId3().equals(other.getBasedetailId3()))
            && (this.getBasedetailId4() == null ? other.getBasedetailId4() == null : this.getBasedetailId4().equals(other.getBasedetailId4()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getNationid() == null ? other.getNationid() == null : this.getNationid().equals(other.getNationid()))
            && (this.getCertificateid() == null ? other.getCertificateid() == null : this.getCertificateid().equals(other.getCertificateid()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getResidence() == null ? other.getResidence() == null : this.getResidence().equals(other.getResidence()))
            && (this.getPhonehome() == null ? other.getPhonehome() == null : this.getPhonehome().equals(other.getPhonehome()))
            && (this.getLinkmanname() == null ? other.getLinkmanname() == null : this.getLinkmanname().equals(other.getLinkmanname()))
            && (this.getAllergydrugs() == null ? other.getAllergydrugs() == null : this.getAllergydrugs().equals(other.getAllergydrugs()))
            && (this.getLsbithabit() == null ? other.getLsbithabit() == null : this.getLsbithabit().equals(other.getLsbithabit()))
            && (this.getInactivereason() == null ? other.getInactivereason() == null : this.getInactivereason().equals(other.getInactivereason()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOpertime() == null ? other.getOpertime() == null : this.getOpertime().equals(other.getOpertime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getPatientcode() == null) ? 0 : getPatientcode().hashCode());
        result = prime * result + ((getCardno() == null) ? 0 : getCardno().hashCode());
        result = prime * result + ((getSocialsecurityno() == null) ? 0 : getSocialsecurityno().hashCode());
        result = prime * result + ((getPatientname() == null) ? 0 : getPatientname().hashCode());
        result = prime * result + ((getBasedetailId1() == null) ? 0 : getBasedetailId1().hashCode());
        result = prime * result + ((getBasedetailId2() == null) ? 0 : getBasedetailId2().hashCode());
        result = prime * result + ((getBasedetailId3() == null) ? 0 : getBasedetailId3().hashCode());
        result = prime * result + ((getBasedetailId4() == null) ? 0 : getBasedetailId4().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getNationid() == null) ? 0 : getNationid().hashCode());
        result = prime * result + ((getCertificateid() == null) ? 0 : getCertificateid().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getResidence() == null) ? 0 : getResidence().hashCode());
        result = prime * result + ((getPhonehome() == null) ? 0 : getPhonehome().hashCode());
        result = prime * result + ((getLinkmanname() == null) ? 0 : getLinkmanname().hashCode());
        result = prime * result + ((getAllergydrugs() == null) ? 0 : getAllergydrugs().hashCode());
        result = prime * result + ((getLsbithabit() == null) ? 0 : getLsbithabit().hashCode());
        result = prime * result + ((getInactivereason() == null) ? 0 : getInactivereason().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOpertime() == null) ? 0 : getOpertime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patientId=").append(patientId);
        sb.append(", patientcode=").append(patientcode);
        sb.append(", cardno=").append(cardno);
        sb.append(", socialsecurityno=").append(socialsecurityno);
        sb.append(", patientname=").append(patientname);
        sb.append(", basedetailId1=").append(basedetailId1);
        sb.append(", basedetailId2=").append(basedetailId2);
        sb.append(", basedetailId3=").append(basedetailId3);
        sb.append(", basedetailId4=").append(basedetailId4);
        sb.append(", age=").append(age);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", nationid=").append(nationid);
        sb.append(", certificateid=").append(certificateid);
        sb.append(", phone=").append(phone);
        sb.append(", company=").append(company);
        sb.append(", residence=").append(residence);
        sb.append(", phonehome=").append(phonehome);
        sb.append(", linkmanname=").append(linkmanname);
        sb.append(", allergydrugs=").append(allergydrugs);
        sb.append(", lsbithabit=").append(lsbithabit);
        sb.append(", inactivereason=").append(inactivereason);
        sb.append(", userId=").append(userId);
        sb.append(", opertime=").append(opertime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}