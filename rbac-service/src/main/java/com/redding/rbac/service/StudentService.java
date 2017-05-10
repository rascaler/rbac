package com.redding.rbac.service;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.dto.StudentDTO;
import com.redding.rbac.dao.domain.Student;
import com.redding.rbac.service.utils.IService;

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
