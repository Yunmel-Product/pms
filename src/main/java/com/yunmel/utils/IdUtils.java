/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.utils;

import java.util.UUID;

/**
 * 
 * @description ID生成工具类
 *
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年10月22日
 */
public class IdUtils {
	private static final IdWorker idWorker = new IdWorker(5, 1);
	
	private IdUtils(){}
	
	public static final Long getId() {
		return idWorker.nextId();
	}

	/**
	 * 
	 * @return 15位长度
	 */
	public static final String getUID() {
		String machineId = "a";// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%015d", hashCodeV);
	}
	
	/**
	 * 获取唯一表示符
	 * @return
	 * @author chen
	 * @deprecated 32位 长度
	 */
	public static final String getUUID(){
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(getUID());
		System.out.println(getUID());
	}
}
