package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.dto.StudentDTO;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.service.StudentService;
import com.redding.rbac.web.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
public class HelloController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    StudentDTO getOne(Integer id) {
        return studentService.getOne(id);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    List<StudentDTO> getAll() {
        return studentService.getAll();
    }

    @RequestMapping("/getAll1")
    @OuterResponseBody
    List<StudentDTO> getAll1() {
        return studentService.getAll();
    }

    @RequestMapping("/testException")
    @OuterResponseBody
    void testException() {
        throw new SPIException(BasicEcode.FAILED);
    }


    @RequestMapping("/testPage")
    @OuterResponseBody
    PageInfo<StudentDTO> testPage() {
        return studentService.pageStudents();
    }

}