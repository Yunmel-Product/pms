package com.yunmel.biz.plan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.alibaba.fastjson.JSONObject;

@Entity
public class PlanBaseModel extends JSONObject{
	private static final long serialVersionUID = -5912886596088363890L;

	@Id
	private String id;

	@Transient
	private Integer page = 1;

	@Transient
	private Integer rows = 10;

	public String getId() {
		return this.getString("id");
	}

	public void setId(String id) {
		this.put("id", id);
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public PlanBaseModel set(String key, Object value, boolean force) {
	    if (force || value != null) {
	      super.put(key, value);
	    }
	    return this;
	  }

	  public PlanBaseModel set(String key, Object value) {
	    return this.set(key, value, true);
	  }
}
