package com.yunmel.biz.plan.mapper;

import java.util.List;
import java.util.Map;

import com.yunmel.biz.plan.model.Schedule;
import com.yunmel.core.base.BaseMapper;
/**
*ScheduleMapper接口
* @author yunmel
*/
public interface ScheduleMapper extends BaseMapper<Schedule>{	
  public List<Schedule> findPageInfo(Map<String, Object> params); 
}
