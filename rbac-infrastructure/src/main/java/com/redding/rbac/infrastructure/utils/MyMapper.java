package com.redding.rbac.infrastructure.utils;

import com.redding.rbac.infrastructure.utils.provider.MySelectProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * tk.mybatis数据持久层接口
 * 提供必须的增删改查功能
 * Created by Leven on 2017-03-10.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

    @SelectProvider(
            type = MySelectProvider.class,
            method = "dynamicSQL"
    )
    T selectFirst(T entity);


    @SelectProvider(
            type = MySelectProvider.class,
            method = "dynamicSQL"
    )
    T selectFirstByExample(Example example);

    @SelectProvider(
            type = MySelectProvider.class,
            method = "dynamicSQL"
    )
    List<T> selectLimit(@Param("entity") T entity, @Param("limit") int limit);

    @SelectProvider(
            type = MySelectProvider.class,
            method = "dynamicSQL"
    )
    List<T> selectLimitByExample(@Param("example") Object example, @Param("limit") int limit);
}
