package com.olivine.mapstruct.service;


import com.olivine.mapstruct.dto.CourseDTO;

import java.io.Serializable;
import java.util.List;

/**
 * (Course)表服务接口
 *
 * @author makejava
 * @since 2021-12-07 18:33:42
 */
public interface CourseService {

    List<CourseDTO> findAll();

    CourseDTO findById(Integer id);

    CourseDTO update(CourseDTO course);

    void save(CourseDTO course);

    void deleteById(Integer id);
}

