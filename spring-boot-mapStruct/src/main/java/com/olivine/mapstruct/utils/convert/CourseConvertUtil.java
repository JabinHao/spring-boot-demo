package com.olivine.mapstruct.utils.convert;

import com.olivine.mapstruct.domain.Course;
import com.olivine.mapstruct.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

/**
 * @Author jphao
 * @Date 21:49 2021/12/07
 * @Description
 */
@Mapper(componentModel = "spring")
public interface CourseConvertUtil {

    CourseConvertUtil INSTANCE = Mappers.getMapper(CourseConvertUtil.class);

    CourseDTO course2CourseDTO(Course course);

    Course courseDTO2Course(CourseDTO courseDTO);

    List<CourseDTO> courses2CourseDTOs(Collection<Course> courses);
}
