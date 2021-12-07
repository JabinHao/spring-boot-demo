package com.olivine.mapstruct.service.impl;

import com.olivine.mapstruct.domain.Student;
import com.olivine.mapstruct.dto.StudentDTO;
import com.olivine.mapstruct.mapper.StudentMapper;
import com.olivine.mapstruct.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2021-12-07 18:35:11
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDTO> findAll() {
        List<Student> students = studentMapper.selectAll();
        return null;
    }

    @Override
    public StudentDTO findById(Serializable id) {

        Student student = studentMapper.selectByStudentId((String) id);
        return null;
    }

    @Override
    public void save(StudentDTO studentDTO) {

        studentMapper.insert();
    }

    @Override
    public StudentDTO updateById(StudentDTO studentDTO) {

        studentMapper.updateByStudentIdSelective();
        final Student updatedStudent = studentMapper.selectByStudentId(studentDTO.getStudentId());
        return null;
    }

    @Override
    public void removeById(String id) {
        studentMapper.deleteByStudentId(id)
    }
}

