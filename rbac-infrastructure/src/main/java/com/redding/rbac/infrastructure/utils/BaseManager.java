package com.redding.rbac.infrastructure.utils;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/12 15:06
 */
public interface BaseManager<T> {

    T selectByKey(Object key);

    T selectOne(T entity);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    List<T> select(T entity);

    List<T> selectAll();


    int deleteByExample(Object example);

    int updateByExampleSelective(T entity, Object example);

    int insertSelective(T entity);

    int selectCountByExample(Object example);
}
