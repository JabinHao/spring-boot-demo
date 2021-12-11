package com.olivine.mapstruct.utils.convert;

import com.google.common.collect.ImmutableMap;
import com.olivine.mapstruct.domain.Score;
import com.olivine.mapstruct.domain.Student;
import com.olivine.mapstruct.dto.StudentDTO;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.HashMap;
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

    public StudentDTO student2StudentDTO(Student student, List<Map<String, Object>> scores){
        if ( student == null) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentId( student.getStudentId() );
        studentDTO.setName( student.getName() );
        studentDTO.setAge( student.getAge() );
        studentDTO.setGender( student.getGender() );

        if ( scores != null ) {
            Map<String, Integer> scoreMap = scores.parallelStream()
                    .map(m -> ImmutableMap.of( (String) m.get("course_name"), (Integer) m.get("score")))
//                    .map(m -> {
//                        Map<String, Integer> map = new HashMap<>();
//                        map.put(m.get("course_name"), Integer.valueOf(String.valueOf(m.get("score"))));
//                        return map;
//                    })
                    .flatMap(map -> map.entrySet().stream())
                    .filter(e -> e.getKey() != null)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a));

//            final List<Map<String, Integer>> mapList = scores.parallelStream()
//                    .map(m -> {
//                        Map<String, Integer> map = new HashMap<>();
//                        map.put(m.get("course_name"), new Integer(m.get("score")));
//                        return map;
//                    }).collect(Collectors.toList());
//
//            Map<String, Integer> scoreMap = mapList.parallelStream().flatMap(map -> map.entrySet().stream())
//                    .filter(e -> e.getKey() != null)
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a));
            studentDTO.setScores( new HashMap<String, Integer>( scoreMap ) );
        }

        return studentDTO;
    }
//    public StudentDTO student2StudentDTO(Student student, List<Score> scores){
//
//        final StudentDTO studentDTO = student2StudentDTO(student);
//        // 重复时取第二个
//        final Map<String, Integer> scoreMap = scores.parallelStream().collect(Collectors.toMap(score -> score.getId().toString(), Score::getScore, (k1, k2) -> k1));
//
//        studentDTO.setScores(scoreMap);
//        return studentDTO;
//    }

}
