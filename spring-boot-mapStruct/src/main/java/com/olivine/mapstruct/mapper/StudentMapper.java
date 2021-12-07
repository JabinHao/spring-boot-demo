package com.olivine.mapstruct.mapper;

import com.olivine.mapstruct.domain.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByStudentId(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByStudentId(Integer id);

    int updateByStudentIdSelective(Student record);

    int updateByStudentId(Student record);

    List<Student> selectAll();

    Student selectByStudentId(String student_id);
}