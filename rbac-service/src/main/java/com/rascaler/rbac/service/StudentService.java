package com.rascaler.rbac.service;

import com.github.pagehelper.PageInfo;
import com.rascaler.rbac.dao.domain.Student;
import com.rascaler.rbac.service.dto.StudentDTO;
import com.rascaler.rbac.service.utils.IService;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 18:05
 */
public interface StudentService extends IService<Student>{

    List<StudentDTO> getAll();

    /**
     * @param id
     * @return
     */
    StudentDTO getOne(Integer id);


    PageInfo<StudentDTO> pageStudents();
}
