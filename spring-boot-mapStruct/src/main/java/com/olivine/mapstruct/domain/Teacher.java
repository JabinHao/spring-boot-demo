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
public class Teacher implements Serializable {
    private static final long serialVersionUID = -387513722962716344L;
    /**
     * 教师编号
     */
    private Integer id;

    /**
     * 教师姓名
     */
    private String name;

    private Date ctime;

    private Date mtime;

}