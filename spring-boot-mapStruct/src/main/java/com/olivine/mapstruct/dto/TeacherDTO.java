package com.olivine.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jphao
 * @Date 19:34 2021/12/07
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO extends BaseDTO{
    private static final long serialVersionUID = -4697880167460635696L;

    /**
     * 教师编号
     */
    private Integer id;

    /**
     * 教师姓名
     */
    private String name;
}
