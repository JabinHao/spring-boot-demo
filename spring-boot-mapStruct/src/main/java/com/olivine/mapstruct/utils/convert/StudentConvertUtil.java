package com.olivine.mapstruct.utils.convert;

import com.olivine.mapstruct.domain.Score;
import com.olivine.mapstruct.domain.Student;
import com.olivine.mapstruct.dto.StudentDTO;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author jphao
 * @Date 21:49 2021/12/07
 * @Description
 */
@Mapper(componentModel = "spring")
public abstract class StudentConvertUtil {

//    public static final StudentConvertUtil INSTANCE = Mappers.getMapper(StudentConvertUtil.class);

    public abstract Student studentDTO2Student(StudentDTO studentDTO);

    public abstract StudentDTO student2StudentDTO(Student student);

    public abstract List<StudentDTO> students2StudentDTOs(Collection<Student> students);

    public StudentDTO student2StudentDTO(Student student, List<Score> scores){

        final StudentDTO studentDTO = student2StudentDTO(student);
        // 重复时取第二个
        final Map<String, Integer> scoreMap = scores.parallelStream().collect(Collectors.toMap(score -> score.getId().toString(), Score::getScore, (k1, k2) -> k1));

        studentDTO.setScores(scoreMap);
        return studentDTO;
    }

}
