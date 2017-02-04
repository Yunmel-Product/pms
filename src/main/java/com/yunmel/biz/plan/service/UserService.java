package com.yunmel.biz.plan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunmel.biz.plan.mapper.UserMapper;
import com.yunmel.biz.plan.model.User;
import com.yunmel.utils.ParamUtils;
import com.yunmel.utils.Globle;

/**
 * User 业务管理
 * @author yunmel
 */
@Service("userService")
public class UserService extends PlanBaseService<User>{
	private Logger LOG = LoggerFactory.getLogger(UserService.class);
	@Resource
	private UserMapper userMapper;
	
	/**
	 * User 保存
	 * @param user
	 * @return 保存成功数
	 */
	public Integer saveUser(User user) {
	    return user.getId() == null ? this.insertSelective(user)
	        : this.updateByPrimaryKeySelective(user);
  	}
	
	/**
	 * 查询所有的User
	 * @return List<User>
	 */
	public List<User> findAll() {
	    User record = new User();
	    record.setDelFlag(Globle.DEL_FLAG_NORMAL);
	    return this.select(record);
  	}
  	
  	/**
	 * 不分页-根据参数查询相关的User
	 * @param params键值对的查询参数
	 * @return List<User>
	 */
  	public List<User> findByParams(Map<String, Object> params) {
	    return userMapper.findPageInfo(params);
	}
	
	/**
	 * 分页-根据参数查询相关的User
	 * @param params键值对的查询参数
	 * @return List<User>
	 */
  	public PageInfo<User> findPageInfo(Map<String, Object> params) {
	    ParamUtils.dealParam(params);
	    PageHelper.startPage(params);
	    List<User> list = this.findByParams(params);
	    return new PageInfo<>(list);
  	}
  	
  	/**
	 * 根据id单个删除User
	 * @param id 需要删除的id
	 * @return 删除成功数量
	 */
  	public Integer delById(String id) {
	    User record = new User();
	    record.setId(id);
	    record.setDelFlag(Globle.DEL_FLAG_DELETE);
	    return this.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 根据id批量删除User
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
