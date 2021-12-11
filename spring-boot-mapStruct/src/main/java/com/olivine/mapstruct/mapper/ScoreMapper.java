package com.olivine.mapstruct.mapper;

import com.olivine.mapstruct.domain.Score;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    List<Score> selectByStudentId(String studentId);

//    @MapKey("course_name")
    List<Map<String, Object>> selectWithCourseByStudentId(String studentId);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    List<Score> selectAll();
}