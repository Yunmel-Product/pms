package com.yunmel.biz.plan.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Project {
	private Long serverTimeOffset = 3600000L;
	private int selectedRow;
	
	private boolean cannotCloseTaskIfIssueOpen = true;
	private boolean canWriteOnParent = true;
	private boolean canAddIssue = true;
	private boolean notifyStatusAndDateChanges = true;
	private boolean canWrite = true;
	private boolean ok = false;
	
	private List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
	private List<Task> deletedTaskIds = new ArrayList<Task>();
	private List<User> resources = new ArrayList<User>();
	private List<Role> roles = new ArrayList<Role>();
	
	public int getSelectedRow() {
		return selectedRow;
	}
	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public List<Task> getDeletedTaskIds() {
		return deletedTaskIds;
	}
	public void setDeletedTaskIds(List<Task> deletedTaskIds) {
		this.deletedTaskIds = deletedTaskIds;
	}
	public Long getServerTimeOffset() {
		return serverTimeOffset;
	}
	public void setServerTimeOffset(Long serverTimeOffset) {
		this.serverTimeOffset = serverTimeOffset;
	}
	public boolean isCannotCloseTaskIfIssueOpen() {
		return cannotCloseTaskIfIssueOpen;
	}
	public void setCannotCloseTaskIfIssueOpen(boolean cannotCloseTaskIfIssueOpen) {
		this.cannotCloseTaskIfIssueOpen = cannotCloseTaskIfIssueOpen;
	}
	public boolean isCanWriteOnParent() {
		return canWriteOnParent;
	}
	public void setCanWriteOnParent(boolean canWriteOnParent) {
		this.canWriteOnParent = canWriteOnParent;
	}
	public boolean isCanAddIssue() {
		return canAddIssue;
	}
	public void setCanAddIssue(boolean canAddIssue) {
		this.canAddIssue = canAddIssue;
	}
	public boolean isNotifyStatusAndDateChanges() {
		return notifyStatusAndDateChanges;
	}
	public void setNotifyStatusAndDateChanges(boolean notifyStatusAndDateChanges) {
		this.notifyStatusAndDateChanges = notifyStatusAndDateChanges;
	}
	public List<Map<String, Object>> getTasks() {
		return tasks;
	}
	public void setTasks(List<Map<String, Object>> tasks) {
		this.tasks = tasks;
	}
	public List<User> getResources() {
		return resources;
	}
	public void setResources(List<User> resources) {
		this.resources = resources;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public boolean isCanWrite() {
		return canWrite;
	}
	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}
	
}
