/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.core.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yunmel.utils.Globle;
import com.yunmel.utils.IdUtils;
import com.yunmel.utils.jse.ThreadLocalUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @param <T>
 * @author xuyq - chainisit@126.com
 * @description service 基类
 * @since 1.0 - 2016年7月15日
 */
public abstract class BaseService<T extends BaseEntity> {

    @Autowired
    private BaseMapper<T> baseMapper;

    public int insertSelective(T record) {
        record.setId(IdUtils.get());
        return baseMapper.insertSelective(record);
    }

    /**
     * 根据主键进行更新 只会更新不是null的数据
     *
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(T record) {
        // SysUser user = SysUserUtils.getCacheLoginUser();
        String user = (String) ThreadLocalUtils.get("user");
        record.set("updateBy", user);
        record.set("updateDate", System.currentTimeMillis());
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
     *
     * @param <T extend T>
     */
    public List<T> select(T record) {
        record.set("delFlag", Globle.DEL_FLAG_NORMAL);
        return baseMapper.select(record);
    }

    public List<T> select(T record, String orderSqlStr) {
        Example example = new Example(record.getClass(), false);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("delFlag", Globle.DEL_FLAG_NORMAL);
        for (Map.Entry<String, Object> entry : record.entrySet()) {
            if ("".equals(entry.getValue()))
                continue;
            criteria.andEqualTo(entry.getKey(), entry.getValue());
        }
        example.setOrderByClause(orderSqlStr);
        return baseMapper.selectByExample(example);
    }

    /**
     * 通过主键进行删除,这里最多只会删除一条数据 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
     *
     * @param <T extend T>
     */
    public int deleteByPrimaryKey(Object key) {
        return baseMapper.deleteByPrimaryKey(key);
    }

    /**
     * 根据主键进行查询,必须保证结果唯一 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
     *
     * @param <T extend T>
     */
    public T selectByPrimaryKey(Object key) {
        return baseMapper.selectByPrimaryKey(key);
    }
}