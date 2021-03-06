/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.core.base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.alibaba.fastjson.JSONObject;

@Entity
public class BaseEntity extends JSONObject {
	private static final long serialVersionUID = -6259412242789016371L;
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
	
	public BaseEntity set(String key, Object value, boolean force) {
	    if (force || value != null) {
	      super.put(key, value);
	    }
	    return this;
	  }

	  public BaseEntity set(String key, Object value) {
	    return this.set(key, value, true);
	  }

}
