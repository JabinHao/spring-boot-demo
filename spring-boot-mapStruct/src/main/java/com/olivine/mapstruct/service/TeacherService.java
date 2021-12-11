package com.olivine.mapstruct.service;


import com.olivine.mapstruct.domain.Teacher;
import com.olivine.mapstruct.dto.TeacherDTO;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author makejava
 * @since 2021-12-07 18:35:11
 */
public interface TeacherService{

    List<TeacherDTO> findAll();

    TeacherDTO findById(Integer id);

    void save(TeacherDTO teacherDTO);

    TeacherDTO updateById(TeacherDTO teacherDTO);

    void removeById(Integer id);
}

