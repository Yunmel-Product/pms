package com.yunmel.biz.plan.mapper;

import java.util.List;
import java.util.Map;

import com.yunmel.biz.plan.model.Task;
import com.yunmel.core.base.BaseMapper;
/**
*TaskMapper接口
* @author yunmel
*/
public interface TaskMapper extends BaseMapper<Task>{	
  public List<Task> findPageInfo(Map<String, Object> params); 
  
  public List<Map<String,Object>> getGanttDataByProject(String projectId);

  public List<Map<String,Object>> getUserTasks(String userId);
}
