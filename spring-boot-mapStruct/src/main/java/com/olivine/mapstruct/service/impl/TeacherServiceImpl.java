package com.olivine.mapstruct.service.impl;

import com.olivine.mapstruct.domain.Teacher;
import com.olivine.mapstruct.dto.TeacherDTO;
import com.olivine.mapstruct.mapper.TeacherMapper;
import com.olivine.mapstruct.service.TeacherService;
import com.olivine.mapstruct.utils.CommonConstants;
import com.olivine.mapstruct.utils.convert.TeacherConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author jphao
 * @since 2021-12-07 18:35:11
 */
@Slf4j
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;
    private final TeacherConvertUtil teacherConvertUtil;

    public TeacherServiceImpl(TeacherMapper teacherMapper, TeacherConvertUtil teacherConvertUtil) {
        this.teacherMapper = teacherMapper;
        this.teacherConvertUtil = teacherConvertUtil;
    }

    @Override
    public List<TeacherDTO> findAll() {
        List<Teacher> teachers = teacherMapper.selectAll();
        log.info("查询全部教师信息：{}", CommonConstants.JSON.toJson(teachers));
        return teacherConvertUtil.teachers2TeacherDTOs(teachers);
    }

    @Override
    public TeacherDTO findById(Integer id) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        log.info("查询教师信息：{}", teacher);
        return teacherConvertUtil.teacher2TeacherDTO(teacher);
    }

    @Override
    public void save(TeacherDTO teacherDTO) {

        teacherMapper.insert(teacherConvertUtil.teacherDTO2Teacher(teacherDTO));
        log.info("保存教师信息：{}", teacherDTO);
    }

    @Override
    public TeacherDTO updateById(TeacherDTO teacherDTO) {

        teacherMapper.updateByPrimaryKeySelective(teacherConvertUtil.teacherDTO2Teacher(teacherDTO));
        Teacher updatedTeacher = teacherMapper.selectByPrimaryKey(teacherDTO.getId());
        log.info("更新教师: {}的信息为: {}", teacherDTO.getName(), teacherDTO);
        return teacherConvertUtil.teacher2TeacherDTO(updatedTeacher);
    }

    @Override
    public void removeById(Integer id) {
        final Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        teacherMapper.deleteByPrimaryKey(id);
        log.info("删除教师信息: {}", teacher);
    }
}

