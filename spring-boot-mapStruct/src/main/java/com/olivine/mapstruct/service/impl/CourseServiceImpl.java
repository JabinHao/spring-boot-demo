package com.olivine.mapstruct.service.impl;

import com.olivine.mapstruct.domain.Course;
import com.olivine.mapstruct.dto.CourseDTO;
import com.olivine.mapstruct.mapper.CourseMapper;
import com.olivine.mapstruct.service.CourseService;
import com.olivine.mapstruct.utils.convert.CourseConvertUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Course)表服务实现类
 *
 * @author jphao
 * @since 2021-12-07 18:33:43
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;
    private final CourseConvertUtil courseConvertUtil;

    public CourseServiceImpl(CourseMapper courseMapper, CourseConvertUtil courseConvertUtil) {
        this.courseMapper = courseMapper;
        this.courseConvertUtil = courseConvertUtil;
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = courseMapper.selectAll();
        return courseConvertUtil.courses2CourseDTOs(courses);
    }

    @Override
    public CourseDTO findById(Integer id) {
        Course course = courseMapper.selectByPrimaryKey(id);
        return courseConvertUtil.course2CourseDTO(course);
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        courseMapper.updateByPrimaryKey(courseConvertUtil.courseDTO2Course(courseDTO));
        Course updatedCourse = courseMapper.selectByPrimaryKey(courseDTO.getId());
        return courseConvertUtil.course2CourseDTO(updatedCourse);
    }

    @Override
    public void save(CourseDTO course) {
        courseMapper.insertSelective(courseConvertUtil.courseDTO2Course(course));
    }

    @Override
    public void deleteById(Integer id) {
        courseMapper.deleteByPrimaryKey(id);
    }
}

