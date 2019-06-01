package com.qx.mapper;

import java.util.List;

import com.qx.po.Userrole;

public interface UserroleMapper {
    
    //查询角色类型
    public List<Userrole> findByUserrole();
   
}