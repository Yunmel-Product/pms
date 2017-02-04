package com.yunmel.biz.plan.model;

import java.util.*;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

/**
* Schedule实体类
* @author yunmel
*/
@SuppressWarnings({ "unused"})
@Table(name="plan_schedule")
public class Schedule extends PlanBaseModel{
	private String discriminator;
	private Date start;
	private Date end;
	private Integer startTime;
	private Long duration;
	private Integer freq;
	private Integer repeatx;
	private Integer onlyWorkingDays;
	private Integer dayOfWeek;
	private Integer weekOfMonth;
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

	public String getDiscriminator(){
		return this.getString("discriminator");
	}
	public void setDiscriminator(String discriminator){
		this.set("discriminator",discriminator);
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getStart(){
		return this.getDate("start");
	}
	public void setStart(Date start){
		this.set("start",start);
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getEnd(){
		return this.getDate("end");
	}
	public void setEnd(Date end){
		this.set("end",end);
	}
	public Integer getStartTime(){
		return this.getInteger("startTime");
	}
	public void setStartTime(Integer startTime){
		this.set("startTime",startTime);
	}
	public Long getDuration(){
		return this.getLong("duration");
	}
	public void setDuration(Long duration){
		this.set("duration",duration);
	}
	public Integer getFreq(){
		return this.getInteger("freq");
	}
	public void setFreq(Integer freq){
		this.set("freq",freq);
	}
	public Integer getRepeatx(){
		return this.getInteger("repeatx");
	}
	public void setRepeatx(Integer repeatx){
		this.set("repeatx",repeatx);
	}
	public Integer getOnlyWorkingDays(){
		return this.getInteger("onlyWorkingDays");
	}
	public void setOnlyWorkingDays(Integer onlyWorkingDays){
		this.set("onlyWorkingDays",onlyWorkingDays);
	}
	public Integer getDayOfWeek(){
		return this.getInteger("dayOfWeek");
	}
	public void setDayOfWeek(Integer dayOfWeek){
		this.set("dayOfWeek",dayOfWeek);
	}
	public Integer getWeekOfMonth(){
		return this.getInteger("weekOfMonth");
	}
	public void setWeekOfMonth(Integer weekOfMonth){
		this.set("weekOfMonth",weekOfMonth);
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
