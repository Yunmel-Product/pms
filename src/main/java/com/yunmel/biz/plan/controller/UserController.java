package com.yunmel.biz.plan.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunmel.biz.plan.model.User;
import com.yunmel.biz.plan.result.JsonResult;
import com.yunmel.biz.plan.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("goSelectUser")
	public String goSelectUser(Model model,@RequestParam String taskId){
		return "plan/template/selectUser";
	}
	
	@RequestMapping("selectUserList")
	@ResponseBody
	public Map<String, Object> selectUserList(){
		List<User> lists = userService.findAll();
		return JsonResult.toSuccess("获取用户列表成功", lists);
	}
}
