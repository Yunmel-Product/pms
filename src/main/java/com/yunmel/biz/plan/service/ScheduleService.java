package com.yunmel.biz.plan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunmel.biz.plan.mapper.ScheduleMapper;
import com.yunmel.biz.plan.model.Schedule;
import com.yunmel.utils.ParamUtils;
import com.yunmel.utils.Globle;

/**
 * Schedule 业务管理
 * @author yunmel
 */
@Service("scheduleService")
public class ScheduleService extends PlanBaseService<Schedule>{
	private Logger LOG = LoggerFactory.getLogger(ScheduleService.class);
	@Resource
	private ScheduleMapper scheduleMapper;
	
	/**
	 * Schedule 保存
	 * @param schedule
	 * @return 保存成功数
	 */
	public Integer saveSchedule(Schedule schedule) {
	    return schedule.getId() == null ? this.insertSelective(schedule)
	        : this.updateByPrimaryKeySelective(schedule);
  	}
	
	/**
	 * 查询所有的Schedule
	 * @return List<Schedule>
	 */
	public List<Schedule> findAll() {
	    Schedule record = new Schedule();
	    record.setDelFlag(Globle.DEL_FLAG_NORMAL);
	    return this.select(record);
  	}
  	
  	/**
	 * 不分页-根据参数查询相关的Schedule
	 * @param params键值对的查询参数
	 * @return List<Schedule>
	 */
  	public List<Schedule> findByParams(Map<String, Object> params) {
	    return scheduleMapper.findPageInfo(params);
	}
	
	/**
	 * 分页-根据参数查询相关的Schedule
	 * @param params键值对的查询参数
	 * @return List<Schedule>
	 */
  	public PageInfo<Schedule> findPageInfo(Map<String, Object> params) {
	    ParamUtils.dealParam(params);
	    PageHelper.startPage(params);
	    List<Schedule> list = this.findByParams(params);
	    return new PageInfo<>(list);
  	}
  	
  	/**
	 * 根据id单个删除Schedule
	 * @param id 需要删除的id
	 * @return 删除成功数量
	 */
  	public Integer delById(String id) {
	    Schedule record = new Schedule();
	    record.setId(id);
	    record.setDelFlag(Globle.DEL_FLAG_DELETE);
	    return this.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 根据id批量删除Schedule
	 * @param ids 需要删除的id列表
	 * @return 删除成功数量
	 */
	public Integer delByIds(String[] ids) {
	    int c = 0;
	    for (String id : ids) {
	      c += this.deleteByPrimaryKey(id);
	    }
	    return c;
	}
}
