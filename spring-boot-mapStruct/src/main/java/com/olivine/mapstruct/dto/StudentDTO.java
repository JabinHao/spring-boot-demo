package com.olivine.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author jphao
 * @Date 19:24 2021/12/07
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends BaseDTO{
    private static final long serialVersionUID = -861423382026489535L;
    /**
     * 学号
     */
    @JsonProperty("student_id")
    private String studentId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 各科成绩
     */
    private Map<String, Integer> scores;
}
