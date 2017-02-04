package com.yunmel.biz.plan.model;

import java.util.*;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

/**
* Assignment实体类
* @author yunmel
*/
@SuppressWarnings({ "unused"})
@Table(name="plan_assignment")
public class Assignment extends PlanBaseModel{
	private String description;
	private String userId;
	private String taskId;
	private String roleId;
	private Long wkldone;
	private String creator;
	private Date creationDate;
	/**创建人*/
	private String createBy;
	/**创建时间*/
	private Long createDate;
	/**修改人*/
	private String updateBy;
	/**修改时间*/
	private Long updateDate;
	/**删除标识*/
	private String delFlag;

	public String getDescription(){
		return this.getString("description");
	}
	public void setDescription(String description){
		this.set("description",description);
	}
	public String getUserId(){
		return this.getString("userId");
	}
	public void setUserId(String userId){
		this.set("userId",userId);
	}
	public String getTaskId(){
		return this.getString("taskId");
	}
	public void setTaskId(String taskId){
		this.set("taskId",taskId);
	}
	public String getRoleId(){
		return this.getString("roleId");
	}
	public void setRoleId(String roleId){
		this.set("roleId",roleId);
	}
	public Long getWkldone(){
		return this.getLong("wkldone");
	}
	public void setWkldone(Long wkldone){
		this.set("wkldone",wkldone);
	}
	public String getCreator(){
		return this.getString("creator");
	}
	public void setCreator(String creator){
		this.set("creator",creator);
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getCreationDate(){
		return this.getDate("creationDate");
	}
	public void setCreationDate(Date creationDate){
		this.set("creationDate",creationDate);
	}
	public String getCreateBy(){
		return this.getString("createBy");
	}
	public void setCreateBy(String createBy){
		this.set("createBy",createBy);
	}
	public Long getCreateDate(){
		return this.getLong("createDate");
	}
	public void setCreateDate(Long createDate){
		this.set("createDate",createDate);
	}
	public String getUpdateBy(){
		return this.getString("updateBy");
	}
	public void setUpdateBy(String updateBy){
		this.set("updateBy",updateBy);
	}
	public Long getUpdateDate(){
		return this.getLong("updateDate");
	}
	public void setUpdateDate(Long updateDate){
		this.set("updateDate",updateDate);
	}
	public String getDelFlag(){
		return this.getString("delFlag");
	}
	public void setDelFlag(String delFlag){
		this.set("delFlag",delFlag);
	}
}
