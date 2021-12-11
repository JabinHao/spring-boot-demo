package com.olivine.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author jphao
 * @Date 19:34 2021/12/07
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO extends BaseDTO{
    private static final long serialVersionUID = 33932473706497503L;

    /**
     * 课程编号
     */
    private Integer id;

    /**
     * 课程名
     */
    private String name;

    /**
     * 教师编号
     */
    @JsonProperty("teacher_id")
    private Integer teacherId;

    private Date ctime;

    private Date mtime;
}
