package com.olivine.mapstruct.service;


import com.olivine.mapstruct.dto.StudentDTO;

import java.io.Serializable;
import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2021-12-07 18:35:11
 */
public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findById(Serializable id);

    StudentDTO findWithScoreById(String id);

    void save(StudentDTO studentDTO);

    StudentDTO updateById(StudentDTO studentDTO);

    void removeById(String id);
}

