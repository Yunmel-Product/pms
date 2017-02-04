package com.yunmel.biz.plan.mapper;

import java.util.List;
import java.util.Map;

import com.yunmel.biz.plan.model.User;
import com.yunmel.core.base.BaseMapper;
/**
*UserMapper接口
* @author yunmel
*/
public interface UserMapper extends BaseMapper<User>{	
  public List<User> findPageInfo(Map<String, Object> params); 
}
