package com.yunmel.biz.plan.model;

import javax.persistence.Table;

import com.yunmel.core.base.BaseEntity;

/**
* Type实体类
* @author yunmel
*/
@SuppressWarnings({ "unused"})
@Table(name="plan_type")
public class Type extends BaseEntity{
	private String typeId;
	private String description;
	private String type;
	private String color;
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

	public String getTypeId(){
		return this.getString("typeId");
	}
	public void setTypeId(String typeId){
		this.set("typeId",typeId);
	}
	public String getDescription(){
		return this.getString("description");
	}
	public void setDescription(String description){
		this.set("description",description);
	}
	public String getType(){
		return this.getString("type");
	}
	public void setType(String type){
		this.set("type",type);
	}
	public String getColor(){
		return this.getString("color");
	}
	public void setColor(String color){
		this.set("color",color);
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
