package com.qx.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qx.mapper.BasedetailMapper;
import com.qx.mapper.UserroleMapper;
import com.qx.mapper.UsersMapper;
import com.qx.po.Basedetail;
import com.qx.po.Userrole;
import com.qx.po.Users;
import com.qx.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersMapper userMapper; 
	
	@Autowired
	private BasedetailMapper basedetailMapper;
	
	@Autowired
	private UserroleMapper userroleMapper;	
	
	/**
	 * 获取用户名和密码
	 */
	@Override
	public Users selectByMC(@Param("username") String username, @Param("password") String password) {		
		return userMapper.selectByMC(username ,password);
	}
				
    /**
     * 注册用户
     */
	@Override
	public boolean register(Users user) {		
		return userMapper.register(user);
	}

	/**
     * 根据身份证查询
     */
	@Override
	public List<Users> findBycertificateidcs(String certificateidcs) {
		return userMapper.findBycertificateidcs(certificateidcs);
	}

	/**
     * 自动生成用户编码
     */
	@Override
	public List<Users> findByUsercode(String Usercode) {
		return userMapper.findByUsercode(Usercode);
	}

	/**
	 * 查询性别
	 */
	@Override
	public List<Basedetail> findByBaseId(Integer basetypeId) {
		return basedetailMapper.findByBaseId(basetypeId);
	}
	
	/**
	 * 查询挂号类型
	 */
	@Override
	public List<Basedetail> findByBaseId1(Integer basetypeId) {
		return basedetailMapper.findByBaseId(basetypeId);
	}

	/**
	 * 查询挂号医生
	 */
	@Override
	public List<Users> findByDoctor(Integer userroleId, Integer userroleId1,
			Integer userroleId2) {
		return userMapper.findByDoctor(userroleId, userroleId1, userroleId2);
	}
	
	/**
	 * 查询挂号科室
	 */
	@Override
	public List<Basedetail> findByBaseId2(Integer basetypeId) {
		return basedetailMapper.findByBaseId2(basetypeId);
	}
	
	/**
	 * 查询角色类型 
	 */
	@Override
	public List<Userrole> findByUserrole() {
		return userroleMapper.findByUserrole();
	}
	

}
