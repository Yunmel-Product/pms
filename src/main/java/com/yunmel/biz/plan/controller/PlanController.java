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
			Project project = taskService.getProject(pid);
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
	
}
