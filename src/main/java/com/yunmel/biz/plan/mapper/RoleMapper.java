package com.yunmel.biz.plan.mapper;

import java.util.List;
import java.util.Map;

import com.yunmel.biz.plan.model.Role;
import com.yunmel.core.base.BaseMapper;
/**
*RoleMapper接口
* @author yunmel
*/
public interface RoleMapper extends BaseMapper<Role>{	
  public List<Role> findPageInfo(Map<String, Object> params); 
}
