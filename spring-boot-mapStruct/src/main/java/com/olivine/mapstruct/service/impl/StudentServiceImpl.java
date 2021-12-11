package com.olivine.mapstruct.service.impl;

import com.olivine.mapstruct.domain.Student;
import com.olivine.mapstruct.dto.StudentDTO;
import com.olivine.mapstruct.mapper.ScoreMapper;
import com.olivine.mapstruct.mapper.StudentMapper;
import com.olivine.mapstruct.service.StudentService;
import com.olivine.mapstruct.utils.convert.StudentConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static com.olivine.mapstruct.utils.CommonConstants.JSON;

/**
 * (Student)表服务实现类
 *
 * @author jphao
 * @since 2021-12-07 18:35:11
 */
@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final ScoreMapper scoreMapper;
    private final StudentConvertUtil studentConvertUtil;

    public StudentServiceImpl(StudentMapper studentMapper, ScoreMapper scoreMapper, StudentConvertUtil studentConvertUtil) {
        this.studentMapper = studentMapper;
        this.scoreMapper = scoreMapper;
        this.studentConvertUtil = studentConvertUtil;
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> students = studentMapper.selectAll();
        final List<StudentDTO> studentDTOs = studentConvertUtil.students2StudentDTOs(students);
        log.info("查询所有学生信息: {}", JSON.toJson(studentDTOs));
        return studentDTOs;
    }

    @Override
    public StudentDTO findById(Serializable id) {

        Student student = studentMapper.selectByStudentId((String) id);
        log.info("查询学生信息: {}", JSON.toJson(student));
        return studentConvertUtil.student2StudentDTO(student);
    }

    @Override
    public StudentDTO findWithScoreById(String id) {
        final Student student = studentMapper.selectByStudentId(id);
        final List<Map<String, Object>> scores = scoreMapper.selectWithCourseByStudentId(id);
        final StudentDTO studentDTO = studentConvertUtil.student2StudentDTO(student, scores);
        log.info("查询学生及成绩信息：{}", studentDTO);
        return studentDTO;
    }

    @Override
    public void save(StudentDTO studentDTO) {
        final Student student = studentConvertUtil.studentDTO2Student(studentDTO);
        studentMapper.insertSelective(student);
        log.info("保存学生信息: {}", JSON.toJson(studentDTO));
    }

    @Override
    public StudentDTO updateById(StudentDTO studentDTO) {

        studentMapper.updateByStudentIdSelective(studentConvertUtil.studentDTO2Student(studentDTO));
        final Student updatedStudent = studentMapper.selectByStudentId(studentDTO.getStudentId());
        log.info("更新: {}同学的信息: {}", studentDTO.getStudentId(), JSON.toJson(studentDTO));
        return studentConvertUtil.student2StudentDTO(updatedStudent);
    }

    @Override
    public void removeById(String id) {
        final Student student = studentMapper.selectByStudentId(id);
        studentMapper.deleteByStudentId(id);
        log.info("删除学生信息: {}", JSON.toJson(student));
    }
}

