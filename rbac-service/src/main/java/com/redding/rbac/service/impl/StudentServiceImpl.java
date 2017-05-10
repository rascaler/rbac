package com.redding.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.dao.domain.Student;
import com.redding.rbac.dao.utils.MyMapper;
import com.redding.rbac.service.StudentService;
import com.redding.rbac.service.dto.StudentDTO;
import com.redding.rbac.service.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 18:05
 */
@Service
public class StudentServiceImpl extends BaseService<Student> implements StudentService{

    @Autowired
    private MyMapper mapper;

    @Override
    public List<StudentDTO> getAll() {
        return BeanMapper.mapList(mapper.selectAll(), StudentDTO.class);
    }

    @Override
    public StudentDTO getOne(Integer id) {
        return BeanMapper.map(mapper.selectByPrimaryKey(id), StudentDTO.class) ;
    }

    @Override
    public PageInfo<StudentDTO> pageStudents() {
        PageHelper.startPage(1,10);
        List<Student> students = this.selectAll();
        PageInfo temp = new PageInfo(students);
        temp.setList(BeanMapper.mapList(temp.getList(),StudentDTO.class));
        return temp;
    }


}
