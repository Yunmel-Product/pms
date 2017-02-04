package com.yunmel.biz.plan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunmel.biz.plan.mapper.AssignmentMapper;
import com.yunmel.biz.plan.model.Assignment;
import com.yunmel.core.base.BaseService;
import com.yunmel.utils.Globle;
import com.yunmel.utils.ParamUtils;

/**
 * Assignment 业务管理
 * @author yunmel
 */
@Service("assignmentService")
public class AssignmentService extends BaseService<Assignment>{
	private Logger LOG = LoggerFactory.getLogger(AssignmentService.class);
	@Resource
	private AssignmentMapper assignmentMapper;
	
	/**
	 * Assignment 保存
	 * @param assignment
	 * @return 保存成功数
	 */
	public Integer saveAssignment(Assignment assignment) {
	    return assignment.getId() == null ? this.insertSelective(assignment)
	        : this.updateByPrimaryKeySelective(assignment);
  	}
	
	/**
	 * 查询所有的Assignment
	 * @return List<Assignment>
	 */
	public List<Assignment> findAll() {
	    Assignment record = new Assignment();
	    record.setDelFlag(Globle.DEL_FLAG_NORMAL);
	    return this.select(record);
  	}
  	
  	/**
	 * 不分页-根据参数查询相关的Assignment
	 * @param params键值对的查询参数
	 * @return List<Assignment>
	 */
  	public List<Assignment> findByParams(Map<String, Object> params) {
	    return assignmentMapper.findPageInfo(params);
	}
	
	/**
	 * 分页-根据参数查询相关的Assignment
	 * @param params键值对的查询参数
	 * @return List<Assignment>
	 */
  	public PageInfo<Assignment> findPageInfo(Map<String, Object> params) {
	    ParamUtils.dealParam(params);
	    PageHelper.startPage(params);
	    List<Assignment> list = this.findByParams(params);
	    return new PageInfo<>(list);
  	}
  	
  	/**
	 * 根据id单个删除Assignment
	 * @param id 需要删除的id
	 * @return 删除成功数量
	 */
  	public Integer delById(String id) {
	    Assignment record = new Assignment();
	    record.setId(id);
	    record.setDelFlag(Globle.DEL_FLAG_DELETE);
	    return this.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 根据id批量删除Assignment
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
	
	public List<Map<String,Object>> getTaskUser(String taskId){
		return assignmentMapper.getTaskUser(taskId);
	}
}
