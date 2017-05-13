package com.redding.rbac.infrastructure.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * tk.mybatis数据持久层接口
 * 提供必须的增删改查功能
 * Created by Leven on 2017-03-10.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
