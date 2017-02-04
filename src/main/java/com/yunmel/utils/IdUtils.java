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
	private IdUtils(){}
	public static final String get(){
		return get22uuid();
	}

	private static final IdWorker idWorker = new IdWorker(5, 1);
	public static final long getLong(){
		return idWorker.nextId();
	}

	private static final String getUID() {
		String machineId = "a";// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		return machineId + String.format("%015d", hashCodeV);
	}
	
	/**
	 * 获取唯一表示符
	 * @return
	 * @author chen
	 * @deprecated 32位 长度
	 */
	private static final String getUUID(){
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}

	/**********************以下为22位UUID生成方法******************************************/
	private final static char[] DIGITS64 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static String toIdStr(long l) {
		char[] buf = "00000000000".toCharArray(); // 限定11位长度
		int length = 11;
		long least = 63L; // 0x0000003FL
		do {
			buf[--length] = DIGITS64[(int) (l & least)]; // l & least取低6位
			l >>>= 6;
		} while (l != 0);
		return new String(buf);
	}
	private static final String get22uuid() {
		UUID u = UUID.randomUUID();
		return toIdStr(u.getMostSignificantBits()) + toIdStr(u.getLeastSignificantBits());
	}

}
