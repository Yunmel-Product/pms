package com.yunmel.biz.plan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunmel.biz.plan.mapper.TypeMapper;
import com.yunmel.biz.plan.model.Type;
import com.yunmel.core.base.BaseService;
import com.yunmel.utils.DealParamUtil;
import com.yunmel.utils.Globle;

/**
 * Type 业务管理
 * @author yunmel
 */
@Service("typeService")
public class TypeService extends PlanBaseService<Type>{
	private Logger LOG = LoggerFactory.getLogger(TypeService.class);
	@Resource
	private TypeMapper typeMapper;
	
	/**
	 * Type 保存
	 * @param type
	 * @return 保存成功数
	 */
	public Integer saveType(Type type) {
	    return type.getId() == null ? this.insertSelective(type)
	        : this.updateByPrimaryKeySelective(type);
  	}
	
	/**
	 * 查询所有的Type
	 * @return List<Type>
	 */
	public List<Type> findAll() {
	    Type record = new Type();
	    record.setDelFlag(Globle.DEL_FLAG_NORMAL);
	    return this.select(record);
  	}
  	
  	/**
	 * 不分页-根据参数查询相关的Type
	 * @param params键值对的查询参数
	 * @return List<Type>
	 */
  	public List<Type> findByParams(Map<String, Object> params) {
	    return typeMapper.findPageInfo(params);
	}
	
	/**
	 * 分页-根据参数查询相关的Type
	 * @param params键值对的查询参数
	 * @return List<Type>
	 */
  	public PageInfo<Type> findPageInfo(Map<String, Object> params) {
	    DealParamUtil.dealParam(params);
	    PageHelper.startPage(params);
	    List<Type> list = this.findByParams(params);
	    return new PageInfo<>(list);
  	}
  	
  	/**
	 * 根据id单个删除Type
	 * @param id 需要删除的id
	 * @return 删除成功数量
	 */
  	public Integer delById(String id) {
	    Type record = new Type();
	    record.setId(id);
	    record.setDelFlag(Globle.DEL_FLAG_DELETE);
	    return this.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 根据id批量删除Type
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
