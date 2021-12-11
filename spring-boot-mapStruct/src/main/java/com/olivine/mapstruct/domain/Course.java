package com.olivine.mapstruct.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * course
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    private static final long serialVersionUID = 3126835576387017280L;
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
    private Integer teacherId;

    private Date ctime;

    private Date mtime;

}