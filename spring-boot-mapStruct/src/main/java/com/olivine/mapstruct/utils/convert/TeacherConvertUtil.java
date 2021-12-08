package com.olivine.mapstruct.utils.convert;

import com.olivine.mapstruct.domain.Teacher;
import com.olivine.mapstruct.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author jphao
 * @Date 21:48 2021/12/07
 * @Description
 */
@Mapper(componentModel = "spring")
public interface TeacherConvertUtil {

    TeacherConvertUtil INSTANCE = Mappers.getMapper(TeacherConvertUtil.class);

    TeacherDTO teacher2TeacherDTO(Teacher teacher);

    Teacher teacherDTO2Teacher(TeacherDTO teacherDTO);

    List<TeacherDTO> teachers2TeacherDTOs(List<Teacher> teachers);
}
