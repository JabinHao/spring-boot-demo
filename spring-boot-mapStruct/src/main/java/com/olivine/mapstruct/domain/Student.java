package com.olivine.mapstruct.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * course
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 4641533649629745633L;

    private Integer id;

    /**
     * 学号
     */
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

    private Date ctime;

    private Date mtime;

}