package com.yunmel.biz.plan.mapper;

import java.util.List;
import java.util.Map;

import com.yunmel.biz.plan.model.Type;
import com.yunmel.core.base.BaseMapper;
/**
*TypeMapper接口
* @author yunmel
*/
public interface TypeMapper extends BaseMapper<Type>{	
  public List<Type> findPageInfo(Map<String, Object> params); 
}
