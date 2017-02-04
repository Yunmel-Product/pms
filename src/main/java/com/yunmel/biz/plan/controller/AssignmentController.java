package com.yunmel.biz.plan.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunmel.biz.plan.result.JsonResult;
import com.yunmel.biz.plan.service.AssignmentService;

@Controller
@RequestMapping("assignment")
public class AssignmentController {
	@Resource
	private AssignmentService assignmentService;
	
	@RequestMapping("getTaskUser")
	@ResponseBody
	public Object getTaskUser(@RequestParam String taskId){
		return JsonResult.toSuccess("获取任务人员成功", assignmentService.getTaskUser(taskId));
	}
}
