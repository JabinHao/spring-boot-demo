package com.olivine.mapstruct.service.impl;

import com.olivine.mapstruct.domain.Teacher;
import com.olivine.mapstruct.dto.TeacherDTO;
import com.olivine.mapstruct.mapper.TeacherMapper;
import com.olivine.mapstruct.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author makejava
 * @since 2021-12-07 18:35:11
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherDTO> findAll() {
        List<Teacher> teachers = teacherMapper.selectAll();
        return null;
    }

    @Override
    public TeacherDTO findById(Integer id) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        return null;
    }

    @Override
    public void save(TeacherDTO teacherDTO) {
        teacherMapper.insert();
    }

    @Override
    public TeacherDTO updateById(TeacherDTO teacherDTO) {

        teacherMapper.updateByPrimaryKeySelective();
        Teacher updatedTeacher = teacherMapper.selectByPrimaryKey(teacherDTO.getId());
        return null;
    }

    @Override
    public void removeById(Integer id) {
        teacherMapper.deleteByPrimaryKey(id);
    }
}

