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
public class Score implements Serializable {
    private static final long serialVersionUID = -4774537166173943182L;

    private Integer id;

    /**
     * 学号
     */
    private Integer studentId;

    /**
     * 课程编号
     */
    private int courseId;

    /**
     * 分数
     */
    private Integer score;

    private Date ctime;

    private Date mtime;

}