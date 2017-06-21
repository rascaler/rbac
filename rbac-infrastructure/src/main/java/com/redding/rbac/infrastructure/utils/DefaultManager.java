package com.redding.rbac.infrastructure.utils;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/5/12 15:06
 */
public class DefaultManager <T> implements BaseManager<T> {
    @Autowired
    protected MyMapper<T> mapper;

    @Autowired
    protected SqlSession sqlSession;

    public Mapper<T> getMapper() {
        return mapper;
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int deleteByKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int delete(T entity){
        return mapper.delete(entity);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }

    public List<T> selectAll() {
        return mapper.selectAll();
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    public T selectFirst(T entity) {
        return mapper.selectFirst(entity);
    }

    public T selectFirstByExample(Example example) {
        return mapper.selectFirstByExample(example);
    }


    public int updateByExampleSelective(T entity, Object example) {
        return mapper.updateByExampleSelective(entity, example);
    }


    public int insertSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }
}
