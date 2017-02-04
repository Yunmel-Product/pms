package com.yunmel.biz.plan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunmel.biz.plan.mapper.RoleMapper;
import com.yunmel.biz.plan.model.Role;
import com.yunmel.core.base.BaseService;
import com.yunmel.utils.DealParamUtil;
import com.yunmel.utils.Globle;

/**
 * Role 业务管理
 * @author yunmel
 */
@Service("roleService")
public class RoleService extends PlanBaseService<Role>{
	private Logger LOG = LoggerFactory.getLogger(RoleService.class);
	@Resource
	private RoleMapper roleMapper;
	
	/**
	 * Role 保存
	 * @param role
	 * @return 保存成功数
	 */
	public Integer saveRole(Role role) {
	    return role.getId() == null ? this.insertSelective(role)
	        : this.updateByPrimaryKeySelective(role);
  	}
	
	/**
	 * 查询所有的Role
	 * @return List<Role>
	 */
	public List<Role> findAll() {
	    Role record = new Role();
	    record.setDelFlag(Globle.DEL_FLAG_NORMAL);
	    return this.select(record);
  	}
  	
  	/**
	 * 不分页-根据参数查询相关的Role
	 * @param params键值对的查询参数
	 * @return List<Role>
	 */
  	public List<Role> findByParams(Map<String, Object> params) {
	    return roleMapper.findPageInfo(params);
	}
	
	/**
	 * 分页-根据参数查询相关的Role
	 * @param params键值对的查询参数
	 * @return List<Role>
	 */
  	public PageInfo<Role> findPageInfo(Map<String, Object> params) {
	    DealParamUtil.dealParam(params);
	    PageHelper.startPage(params);
	    List<Role> list = this.findByParams(params);
	    return new PageInfo<>(list);
  	}
  	
  	/**
	 * 根据id单个删除Role
	 * @param id 需要删除的id
	 * @return 删除成功数量
	 */
  	public Integer delById(String id) {
	    Role record = new Role();
	    record.setId(id);
	    record.setDelFlag(Globle.DEL_FLAG_DELETE);
	    return this.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 根据id批量删除Role
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
