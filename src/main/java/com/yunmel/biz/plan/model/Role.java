package com.yunmel.biz.plan.model;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.yunmel.core.base.BaseEntity;

/**
* Role实体类
* @author yunmel
*/
@SuppressWarnings({ "unused"})
@Table(name="plan_role")
public class Role extends BaseEntity{
	private String name;
	private String description;
	private Date creationDate;
	private String creator;
	private String lastModifier;
	private Date lastModified;
	private String code;
	private Integer companyId;
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

	public String getName(){
		return this.getString("name");
	}
	public void setName(String name){
		this.set("name",name);
	}
	public String getDescription(){
		return this.getString("description");
	}
	public void setDescription(String description){
		this.set("description",description);
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getCreationDate(){
		return this.getDate("creationDate");
	}
	public void setCreationDate(Date creationDate){
		this.set("creationDate",creationDate);
	}
	public String getCreator(){
		return this.getString("creator");
	}
	public void setCreator(String creator){
		this.set("creator",creator);
	}
	public String getLastModifier(){
		return this.getString("lastModifier");
	}
	public void setLastModifier(String lastModifier){
		this.set("lastModifier",lastModifier);
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getLastModified(){
		return this.getDate("lastModified");
	}
	public void setLastModified(Date lastModified){
		this.set("lastModified",lastModified);
	}
	public String getCode(){
		return this.getString("code");
	}
	public void setCode(String code){
		this.set("code",code);
	}
	public Integer getCompanyId(){
		return this.getInteger("companyId");
	}
	public void setCompanyId(Integer companyId){
		this.set("companyId",companyId);
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
