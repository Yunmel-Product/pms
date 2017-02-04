package com.yunmel.biz.plan.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunmel.biz.plan.mapper.TaskMapper;
import com.yunmel.biz.plan.model.Project;
import com.yunmel.biz.plan.model.Task;
import com.yunmel.utils.DealParamUtil;
import com.yunmel.utils.Globle;

/**
 * Task 业务管理
 * @author yunmel
 */
@Service("taskService")
public class TaskService extends PlanBaseService<Task>{
	private Logger LOG = LoggerFactory.getLogger(TaskService.class);
	@Resource
	private TaskMapper taskMapper;
	@Resource
	private UserService userService;
	
	/**
	 * Task 保存
	 * @param task
	 * @return 保存成功数
	 */
	public Integer saveTask(Task task) {
	    return task.getId() == null ? this.insertSelective(task)
	        : this.updateByPrimaryKeySelective(task);
  	}
	
	/**
	 * 查询所有的Task
	 * @return List<Task>
	 */
	public List<Task> findAll() {
	    Task record = new Task();
	    record.setDelFlag(Globle.DEL_FLAG_NORMAL);
	    return this.select(record);
  	}
  	
  	/**
	 * 不分页-根据参数查询相关的Task
	 * @param params键值对的查询参数
	 * @return List<Task>
	 */
  	public List<Task> findByParams(Map<String, Object> params) {
	    return taskMapper.findPageInfo(params);
	}
	
	/**
	 * 分页-根据参数查询相关的Task
	 * @param params键值对的查询参数
	 * @return List<Task>
	 */
  	public PageInfo<Task> findPageInfo(Map<String, Object> params) {
	    DealParamUtil.dealParam(params);
	    PageHelper.startPage(params);
	    List<Task> list = this.findByParams(params);
	    return new PageInfo<>(list);
  	}
  	
  	/**
	 * 根据id单个删除Task
	 * @param id 需要删除的id
	 * @return 删除成功数量
	 */
  	public Integer delById(String id) {
	    Task record = new Task();
	    record.setId(id);
	    record.setDelFlag(Globle.DEL_FLAG_DELETE);
	    return this.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 根据id批量删除Task
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
	
	//////////////////////////////
	
	public void _cmdSave(String param) throws Exception{
		JSONObject json = JSONObject.parseObject(param);
		List<Long> dTasks = JSON.parseArray(json.getString("deletedTaskIds"), Long.class);
		if(dTasks.size()>0){
			//删除
		}
		
		JSONArray jTasks = json.getJSONArray("tasks");
		
		for(Iterator it = jTasks.iterator();it.hasNext();){
			JSONObject jTask = (JSONObject) it.next();
			Task task = transTask(jTask);
			this.saveTask(task);
		}
		
	}
	
	
	public Task transTask(JSONObject json){
		Task task = new Task();
		if(json.containsKey("id") && !json.getString("id").trim().contains("tmp_")){
			//更新
			task.setId(json.getString("id"));
		}else{
			task.setId(null);
		}
		
		task.setProgress(json.getDouble("progress"));
		task.setStartIsMilestone(json.getInteger("startIsMilestone"));
		task.setDuration(json.getInteger("duration"));
		task.setLevel(json.getInteger("level"));
		task.setStatus(json.getString("status"));
		task.setStart(json.getDate("start"));
		task.setDescription(json.getString("description"));
		task.setName(json.getString("name"));
		task.setCode(json.getString("code"));
		task.setEndIsMilestone(json.getInteger("endIsMilestone"));
		task.setEnd(json.getDate("end"));
		task.setDelFlag("0");
		task.setProjectId(json.getString("projectId"));
		return task;
	}
	
	/**
	 * 删除任务
	 * @param tasks
	 */
	public void _cmdDelete(JSONObject json){
		
	}
	
	public Project getProject(String id) throws Exception{
		if(StringUtils.isBlank(id)){
			throw new Exception("项目ID不能为空");
		}
		
		Project project = new Project();
		
		Task task = new Task();
		task.setProjectId(id);
		List<Task> tasks = this.select(task, " `code` ASC ");
		
		
		
		project.setTasks(tasks);
		
		return project;
	}
}
