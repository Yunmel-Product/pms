package com.yunmel.biz.plan.model;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.yunmel.core.base.BaseEntity;

/**
* Task实体类
* @author yunmel
*/
@SuppressWarnings({ "unused"})
@Table(name="plan_task")
public class Task extends BaseEntity{
	private String code;
	private String name;
	private String typeId;
	private String description;
	private String status;
	private Integer relevancex;
	/**工作进度*/
	private Double progress;
	private String tags;
	/**根据工作记录自动计算进度*/
	private Integer progressByWorklog;
	/**工作完成时长*/
	private Long totalWorklogDone;
	private Long totalWorklogEstimated;
	private String totalCostsDone;
	private String totalCostsEstimated;
	private Integer totalIssues;
	private Integer totalIssuesOpen;
	private Integer totalIssuesScoreOpen;
	private Integer totalIssuesScoreClosed;
	private Long totalEstimatedFromIssues;
	private Integer schedule;
	private Integer duration;
	private Integer forumEntry;
	private String externalCode;
	private String costCenter;
	private String notes;
	private String orderFactor;
	private Integer startIsMilestone;
	private Integer endIsMilestone;
	private String forecasted;
	private String customField1;
	private String customField2;
	private String customField3;
	private String customField4;
	private String customField5;
	private String customField6;
	private String budgetCustomField1;
	private String budgetCustomField2;
	private String budgetCustomField3;
	private String budgetCustomField4;
	private Date lastModified;
	private String lastModifier;
	private String creator;
	private Date creationDate;
	private Integer hidden;
	private Date hiddenOn;
	private String hiddenBy;
	private String ancestorids;
	private String parent;
	private Integer ownerx;
	private Long area;
	private Integer inherit;
	private Integer propagate;
	private String jsonData;
	/**等级*/
	private Integer level;
	private Date start;
	private Date end;
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
	/**项目id*/
	private String projectId;
	/**依赖*/
	private String depends;

	public String getCode(){
		return this.getString("code");
	}
	public void setCode(String code){
		this.set("code",code);
	}
	public String getName(){
		return this.getString("name");
	}
	public void setName(String name){
		this.set("name",name);
	}
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
	public String getStatus(){
		return this.getString("status");
	}
	public void setStatus(String status){
		this.set("status",status);
	}
	public Integer getRelevancex(){
		return this.getInteger("relevancex");
	}
	public void setRelevancex(Integer relevancex){
		this.set("relevancex",relevancex);
	}
	public Double getProgress(){
		return this.getDouble("progress");
	}
	public void setProgress(Double progress){
		this.set("progress",progress);
	}
	public String getTags(){
		return this.getString("tags");
	}
	public void setTags(String tags){
		this.set("tags",tags);
	}
	public Integer getProgressByWorklog(){
		return this.getInteger("progressByWorklog");
	}
	public void setProgressByWorklog(Integer progressByWorklog){
		this.set("progressByWorklog",progressByWorklog);
	}
	public Long getTotalWorklogDone(){
		return this.getLong("totalWorklogDone");
	}
	public void setTotalWorklogDone(Long totalWorklogDone){
		this.set("totalWorklogDone",totalWorklogDone);
	}
	public Long getTotalWorklogEstimated(){
		return this.getLong("totalWorklogEstimated");
	}
	public void setTotalWorklogEstimated(Long totalWorklogEstimated){
		this.set("totalWorklogEstimated",totalWorklogEstimated);
	}
	public String getTotalCostsDone(){
		return this.getString("totalCostsDone");
	}
	public void setTotalCostsDone(String totalCostsDone){
		this.set("totalCostsDone",totalCostsDone);
	}
	public String getTotalCostsEstimated(){
		return this.getString("totalCostsEstimated");
	}
	public void setTotalCostsEstimated(String totalCostsEstimated){
		this.set("totalCostsEstimated",totalCostsEstimated);
	}
	public Integer getTotalIssues(){
		return this.getInteger("totalIssues");
	}
	public void setTotalIssues(Integer totalIssues){
		this.set("totalIssues",totalIssues);
	}
	public Integer getTotalIssuesOpen(){
		return this.getInteger("totalIssuesOpen");
	}
	public void setTotalIssuesOpen(Integer totalIssuesOpen){
		this.set("totalIssuesOpen",totalIssuesOpen);
	}
	public Integer getTotalIssuesScoreOpen(){
		return this.getInteger("totalIssuesScoreOpen");
	}
	public void setTotalIssuesScoreOpen(Integer totalIssuesScoreOpen){
		this.set("totalIssuesScoreOpen",totalIssuesScoreOpen);
	}
	public Integer getTotalIssuesScoreClosed(){
		return this.getInteger("totalIssuesScoreClosed");
	}
	public void setTotalIssuesScoreClosed(Integer totalIssuesScoreClosed){
		this.set("totalIssuesScoreClosed",totalIssuesScoreClosed);
	}
	public Long getTotalEstimatedFromIssues(){
		return this.getLong("totalEstimatedFromIssues");
	}
	public void setTotalEstimatedFromIssues(Long totalEstimatedFromIssues){
		this.set("totalEstimatedFromIssues",totalEstimatedFromIssues);
	}
	public Integer getSchedule(){
		return this.getInteger("schedule");
	}
	public void setSchedule(Integer schedule){
		this.set("schedule",schedule);
	}
	public Integer getDuration(){
		return this.getInteger("duration");
	}
	public void setDuration(Integer duration){
		this.set("duration",duration);
	}
	public Integer getForumEntry(){
		return this.getInteger("forumEntry");
	}
	public void setForumEntry(Integer forumEntry){
		this.set("forumEntry",forumEntry);
	}
	public String getExternalCode(){
		return this.getString("externalCode");
	}
	public void setExternalCode(String externalCode){
		this.set("externalCode",externalCode);
	}
	public String getCostCenter(){
		return this.getString("costCenter");
	}
	public void setCostCenter(String costCenter){
		this.set("costCenter",costCenter);
	}
	public String getNotes(){
		return this.getString("notes");
	}
	public void setNotes(String notes){
		this.set("notes",notes);
	}
	public String getOrderFactor(){
		return this.getString("orderFactor");
	}
	public void setOrderFactor(String orderFactor){
		this.set("orderFactor",orderFactor);
	}
	public Integer getStartIsMilestone(){
		return this.getInteger("startIsMilestone");
	}
	public void setStartIsMilestone(Integer startIsMilestone){
		this.set("startIsMilestone",startIsMilestone);
	}
	public Integer getEndIsMilestone(){
		return this.getInteger("endIsMilestone");
	}
	public void setEndIsMilestone(Integer endIsMilestone){
		this.set("endIsMilestone",endIsMilestone);
	}
	public String getForecasted(){
		return this.getString("forecasted");
	}
	public void setForecasted(String forecasted){
		this.set("forecasted",forecasted);
	}
	public String getCustomField1(){
		return this.getString("customField1");
	}
	public void setCustomField1(String customField1){
		this.set("customField1",customField1);
	}
	public String getCustomField2(){
		return this.getString("customField2");
	}
	public void setCustomField2(String customField2){
		this.set("customField2",customField2);
	}
	public String getCustomField3(){
		return this.getString("customField3");
	}
	public void setCustomField3(String customField3){
		this.set("customField3",customField3);
	}
	public String getCustomField4(){
		return this.getString("customField4");
	}
	public void setCustomField4(String customField4){
		this.set("customField4",customField4);
	}
	public String getCustomField5(){
		return this.getString("customField5");
	}
	public void setCustomField5(String customField5){
		this.set("customField5",customField5);
	}
	public String getCustomField6(){
		return this.getString("customField6");
	}
	public void setCustomField6(String customField6){
		this.set("customField6",customField6);
	}
	public String getBudgetCustomField1(){
		return this.getString("budgetCustomField1");
	}
	public void setBudgetCustomField1(String budgetCustomField1){
		this.set("budgetCustomField1",budgetCustomField1);
	}
	public String getBudgetCustomField2(){
		return this.getString("budgetCustomField2");
	}
	public void setBudgetCustomField2(String budgetCustomField2){
		this.set("budgetCustomField2",budgetCustomField2);
	}
	public String getBudgetCustomField3(){
		return this.getString("budgetCustomField3");
	}
	public void setBudgetCustomField3(String budgetCustomField3){
		this.set("budgetCustomField3",budgetCustomField3);
	}
	public String getBudgetCustomField4(){
		return this.getString("budgetCustomField4");
	}
	public void setBudgetCustomField4(String budgetCustomField4){
		this.set("budgetCustomField4",budgetCustomField4);
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getLastModified(){
		return this.getDate("lastModified");
	}
	public void setLastModified(Date lastModified){
		this.set("lastModified",lastModified);
	}
	public String getLastModifier(){
		return this.getString("lastModifier");
	}
	public void setLastModifier(String lastModifier){
		this.set("lastModifier",lastModifier);
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
	public Integer getHidden(){
		return this.getInteger("hidden");
	}
	public void setHidden(Integer hidden){
		this.set("hidden",hidden);
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getHiddenOn(){
		return this.getDate("hiddenOn");
	}
	public void setHiddenOn(Date hiddenOn){
		this.set("hiddenOn",hiddenOn);
	}
	public String getHiddenBy(){
		return this.getString("hiddenBy");
	}
	public void setHiddenBy(String hiddenBy){
		this.set("hiddenBy",hiddenBy);
	}
	public String getAncestorids(){
		return this.getString("ancestorids");
	}
	public void setAncestorids(String ancestorids){
		this.set("ancestorids",ancestorids);
	}
	public String getParent(){
		return this.getString("parent");
	}
	public void setParent(String parent){
		this.set("parent",parent);
	}
	public Integer getOwnerx(){
		return this.getInteger("ownerx");
	}
	public void setOwnerx(Integer ownerx){
		this.set("ownerx",ownerx);
	}
	public Long getArea(){
		return this.getLong("area");
	}
	public void setArea(Long area){
		this.set("area",area);
	}
	public Integer getInherit(){
		return this.getInteger("inherit");
	}
	public void setInherit(Integer inherit){
		this.set("inherit",inherit);
	}
	public Integer getPropagate(){
		return this.getInteger("propagate");
	}
	public void setPropagate(Integer propagate){
		this.set("propagate",propagate);
	}
	public String getJsonData(){
		return this.getString("jsonData");
	}
	public void setJsonData(String jsonData){
		this.set("jsonData",jsonData);
	}
	public Integer getLevel(){
		return this.getInteger("level");
	}
	public void setLevel(Integer level){
		this.set("level",level);
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
	public String getProjectId(){
		return this.getString("projectId");
	}
	public void setProjectId(String projectId){
		this.set("projectId",projectId);
	}
	public String getDepends(){
		return this.getString("depends");
	}
	public void setDepends(String depends){
		this.set("depends",depends);
	}
}
