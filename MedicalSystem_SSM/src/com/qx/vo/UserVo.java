package com.qx.vo;

import java.io.Serializable;

public class UserVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户编码
     */
    private String usercode;

    /**
     * 性别、科室类型
     */
    private Integer basedetailId;

    /**
     * 年龄
     */
    private String age;

    /**
     * 身份证号
     */
    private String certificateid;

    /**
     * 地址
     */
    private String location;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String memo;

    /**
     * 角色类型ID
     */
    private Integer userroleId;
    
    /**
     * 角色名称
     */
    private String userrolename;
    
    /**
     * 基础明细名称
     */
    private String basedetailname;
  
    /**
     * 用户审核否
     */
    private Boolean userreviewno;
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public Integer getBasedetailId() {
        return basedetailId;
    }

    public void setBasedetailId(Integer basedetailId) {
        this.basedetailId = basedetailId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCertificateid() {
        return certificateid;
    }

    public void setCertificateid(String certificateid) {
        this.certificateid = certificateid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getUserroleId() {
        return userroleId;
    }

    public void setUserroleId(Integer userroleId) {
        this.userroleId = userroleId;
    }

    public Boolean getUserreviewno() {
        return userreviewno;
    }

    public void setUserreviewno(Boolean userreviewno) {
        this.userreviewno = userreviewno;
    }

	public String getUserrolename() {
		return userrolename;
	}

	public void setUserrolename(String userrolename) {
		this.userrolename = userrolename;
	}

	public String getBasedetailname() {
		return basedetailname;
	}

	public void setBasedetailname(String basedetailname) {
		this.basedetailname = basedetailname;
	}
    

}
