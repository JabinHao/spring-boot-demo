package com.olivine.mapstruct.service.impl;

import com.olivine.mapstruct.domain.Course;
import com.olivine.mapstruct.dto.CourseDTO;
import com.olivine.mapstruct.mapper.CourseMapper;
import com.olivine.mapstruct.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * (Course)表服务实现类
 *
 * @author makejava
 * @since 2021-12-07 18:33:43
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = courseMapper.selectAll();
        return null;
    }

    @Override
    public CourseDTO findById(Integer id) {
        Course course = courseMapper.selectByPrimaryKey(id);
        return null;
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        courseMapper.updateByPrimaryKey();
        Course updatedCourse = courseMapper.selectByPrimaryKey(courseDTO.getId());
        return null;
    }

    @Override
    public void save(CourseDTO course) {
        courseMapper.insert();
    }

    @Override
    public void deleteById(Integer id) {
        courseMapper.deleteByPrimaryKey(id);
    }
}

