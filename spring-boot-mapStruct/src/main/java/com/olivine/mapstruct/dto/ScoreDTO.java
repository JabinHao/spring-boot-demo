package com.olivine.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jphao
 * @Date 19:33 2021/12/07
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO extends BaseDTO{
    private static final long serialVersionUID = -4868513412412697125L;

    private Integer id;

    /**
     * 学号
     */
    @JsonProperty("student_id")
    private Integer studentId;

    /**
     * 课程编号
     */
    @JsonProperty("course_id")
    private Integer courseId;

    /**
     * 分数
     */
    private Integer score;
}
