package com.yunmel.biz.plan.mapper;

import java.util.List;
import java.util.Map;

import com.yunmel.biz.plan.model.Assignment;
import com.yunmel.core.base.BaseMapper;
/**
*AssignmentMapper接口
* @author yunmel
*/
public interface AssignmentMapper extends BaseMapper<Assignment>{	
  public List<Assignment> findPageInfo(Map<String, Object> params); 
  
  public List<Map<String,Object>> getTaskUser(String taskId);
}
