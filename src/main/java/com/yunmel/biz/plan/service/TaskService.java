package com.yunmel.biz.plan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunmel.biz.plan.mapper.TaskMapper;
import com.yunmel.biz.plan.model.Assignment;
import com.yunmel.biz.plan.model.Project;
import com.yunmel.biz.plan.model.Task;
import com.yunmel.biz.plan.model.User;
import com.yunmel.core.base.BaseService;
import com.yunmel.utils.Globle;
import com.yunmel.utils.IdUtils;
import com.yunmel.utils.ParamUtils;

/**
 * Task 业务管理
 * @author yunmel
 */
@Service("taskService")
public class TaskService extends BaseService<Task>{
	private Logger LOG = LoggerFactory.getLogger(TaskService.class);
	@Resource
	private TaskMapper taskMapper;
	@Resource
	private UserService userService;
	@Resource
	private AssignmentService assignmentService;
	
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
	 * @param params 键值对的查询参数
	 * @return List<Task>
	 */
  	public List<Task> findByParams(Map<String, Object> params) {
	    return taskMapper.findPageInfo(params);
	}
	
	/**
	 * 分页-根据参数查询相关的Task
	 * @param params 键值对的查询参数
	 * @return List<Task>
	 */
  	public PageInfo<Task> findPageInfo(Map<String, Object> params) {
	    ParamUtils.dealParam(params);
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
		List<String> dTasks = JSON.parseArray(json.getString("deletedTaskIds"), String.class);
		if(dTasks.size()>0){
			//删除
			_cmdDelete(dTasks);
		}
		
		JSONArray jTasks = json.getJSONArray("tasks");
		
		List<String> needCheckAss = new ArrayList<String>(); //所有需要检查的操作人
		List<Assignment> needSaveAss = new ArrayList<>(); //所有需要保存的操作人
		
		List<String> allTaskId = new ArrayList<>(); //所有的任务ID
		
		for(Iterator it = jTasks.iterator();it.hasNext();){
			JSONObject jTask = (JSONObject) it.next();
			Task task = transTask(jTask);
			
			allTaskId.add(task.getId());
			
			//组装操作人的数据，方便保存
			JSONArray assJ = jTask.getJSONArray("assigs");
			for(Iterator assIt = assJ.iterator();assIt.hasNext();){
				JSONObject assO = (JSONObject) assIt.next();
				String id = (String) assO.get("id");
				
				if(id.trim().startsWith("tmp_")){
					String resourceId = (String) assO.get("resourceId");
					Integer effort = (Integer) assO.get("effort");
					String roleId = (String) assO.get("roleId");
					Assignment ass = new Assignment();
					ass.setId(IdUtils.get());
					ass.setUserId(resourceId);
					ass.setRoleId(roleId);
					ass.setTaskId(task.getId());
					needSaveAss.add(ass);
				}else{
					needCheckAss.add(id);
				}
			}
			
			this.saveTask(task);
		}
		
		
		//处理操作人
		List<Assignment> assS = assignmentService.getAssByTaskIds(allTaskId);
		
		List<String> needDelAss = new ArrayList<>();
		
		for(Iterator<Assignment> itAss = assS.iterator();itAss.hasNext();){
			Assignment ass = itAss.next();
			String dbId = ass.getId();
			boolean needdel = true;
			for(Iterator<String> it = needCheckAss.iterator();it.hasNext();){
				if(dbId.equals(it.next())){
					needdel = false;
				}
			}
			
			if(needdel){
				needDelAss.add(dbId);
			}
		}
		
		//删除操作人
		if(needDelAss.size()>0){
			String[] delIds = new String[needDelAss.size()];
			assignmentService.delByIds(needDelAss.toArray(delIds));
		}
		if(needSaveAss.size()>0){
			assignmentService.saveAssList(needSaveAss);
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
	 * @param ids
	 */
	public void _cmdDelete(List<String> ids){
		//1 删除 操作人表 使用list参数
		assignmentService.deleteByTaskIds(ids);
		
		//2 删除任务表 使用array参数
		String[] delid = new String[ids.size()];
		this.delByIds(ids.toArray(delid));
	}
	
	public Project getGanttDataByProject(String projectId){
		Project project = new Project();
		
		List<Map<String, Object>> tasks = taskMapper.getGanttDataByProject(projectId);
		List<String> allUser = new ArrayList<String>(); //所有task用到的人员
		
		for(Iterator<Map<String, Object>> it = tasks.iterator();it.hasNext();){
			Map<String,Object> temp = it.next();
			
			List<Map<String,Object>> assigs = new ArrayList<>(); //当前task的操作人
			if(temp.containsKey("assigs") && temp.get("assigs") != null){
				String str = (String) temp.get("assigs");
				String[] tS = str.split(",");
				for(String sid: tS){
					String[] iu = sid.split("@");
					Map<String,Object> assM = new HashMap<>();
					assM.put("id", iu[0]);
					assM.put("resourceId", iu[1]);
					assM.put("effort", 0);
					
					assigs.add(assM);
					allUser.add(iu[1]);
				}
			}
			temp.put("assigs", assigs);
			
			temp.put("canAddIssue", true);
			temp.put("canWrite", true);
			
			//设置任务颜色
			if(temp.containsKey("status") && temp.get("status") != null){
				String status = (String) temp.get("status");
				temp.put("statusColor", getStatusColor(status));
			}
			
			//设置工时
			if(temp.containsKey("totalWorklogDone") && temp.get("totalWorklogDone")!=null){
				Long time = (Long) temp.get("totalWorklogDone");
				temp.put("totalWorklog", time);
			}
			
		}
		
		/**
		 * 下面2选1
		 */
		//查询特定的用户
		//List<User> allUsers = userService.getUserByUserIds(allUser);
		
		//查询所有用户
		List<User> allUsers = userService.findAll();
		
		project.setTasks(tasks);
		project.setResources(allUsers);
		
		return project;
	}
	
	private String getStatusColor(String status){
	     String color = "#666666";
	    if ("STATUS_ACTIVE".equals(status))
	       color = "#3BBF67";
	     else if ("STATUS_SUSPENDED".equals(status))
	       color = "#F9C154";
	    else if ("STATUS_DONE".equals(status))
	       color = "#6EBEF4";
	     else if ("STATUS_FAILED".equals(status))
	       color = "#763A96";
	     else if ("STATUS_UNDEFINED".equals(status)) {
	       color = "#dededf";}
	       return color;
	}

	/**
	 *
	 * @param userId
	 * @return
	 */
	public List<Map<String,Object>> getUserTasks(String userId){
        return taskMapper.getUserTasks(userId);
	}

	public void reportTaskProgress(String taskId, Double progress) throws Exception{
        if(progress>100){
            throw new Exception("任务进度不能大于100");
        }

        Task task = this.selectByPrimaryKey(taskId);

        if(task != null){
            task.setProgress(progress);
            this.saveTask(task);
        }
    }
}
