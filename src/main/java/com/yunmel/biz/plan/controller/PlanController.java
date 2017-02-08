package com.yunmel.biz.plan.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunmel.biz.plan.model.Project;
import com.yunmel.biz.plan.result.JsonResult;
import com.yunmel.biz.plan.service.TaskService;

@Controller
@RequestMapping("plan")
public class PlanController {
	@Resource
	private TaskService taskService;
	
	@RequestMapping
	public String planSet(Model m,HttpServletRequest request){
		String pid = request.getParameter("projectId");
		m.addAttribute("projectId", pid);
		return "plan/gantt";
	} 
	
	@RequestMapping("getGanttData")
	@ResponseBody
	public Map<String, Object> getGanttData(HttpServletRequest request){
		try {
			String pid = request.getParameter("projectId");
			//Project project = taskService.getProject(pid);
			Project project = taskService.getGanttDataByProject(pid);
			return JsonResult.toSuccess("获取数据成功", project);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.toSuccess("获取数据失败", null);
		}
	}
	
	@RequestMapping("saveGanttData")
	@ResponseBody
	public Object saveGanttData(@RequestParam String json){
		
		try {
			taskService._cmdSave(json);
			return JsonResult.toSuccess("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.toSuccess("保存失败,系统异常", null);
		}
	}

	//////////////////////////////////////  begin 移动端接口 begin  //////////////////////////////////////////

    /**
     * 获取用户负责的任务
     * @param userId
     * @return
     */
	@RequestMapping("getTaskByUserId")
	@ResponseBody
	public Object getTaskByUserId(@RequestParam String userId){
		try{
			return JsonResult.toSuccess("查询用户任务成功", taskService.getUserTasks(userId));
		}catch (Exception e){
			e.printStackTrace();
			return JsonResult.toError("查询用户任务失败，系统异常",null);
		}
	}

    /**
     * 上报任务工作进度
     * @param taskId
     * @param progress
     * @return
     */
	public Object reportTaskProgress(@RequestParam  String taskId,@RequestParam Double progress){
        try{
            taskService.reportTaskProgress(taskId, progress);
            return JsonResult.toSuccess("上报任务进度成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.toSuccess(e.getMessage() == null?"上报任务进度失败，系统异常":e.getMessage(),null);
        }
    }
}
