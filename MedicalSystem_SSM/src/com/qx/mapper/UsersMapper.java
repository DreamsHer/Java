package com.qx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qx.po.Users;

public interface UsersMapper {
	
	//注册用户
    public boolean register(Users user);	
	
    //根据身份证查询    
    public List<Users> findBycertificateidcs(String certificateidcs);
    
    //自动生成用户编码
    public List<Users> findByUsercode(String Usercode);
    
    //获取用户名和密码	
    Users selectByMC(@Param("username") String username, @Param("password") String password);		
    
    //查询挂号医生
  	public List<Users> findByDoctor(@Param("userroleId") Integer userroleId,
  			@Param("userroleId1") Integer userroleId1,@Param("userroleId2") Integer userroleId2);
    
    
   
}