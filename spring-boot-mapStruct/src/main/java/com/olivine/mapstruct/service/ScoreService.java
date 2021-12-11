package com.olivine.mapstruct.service;


import com.olivine.mapstruct.dto.ScoreDTO;

import java.util.List;

/**
 * (Score)表服务接口
 *
 * @author makejava
 * @since 2021-12-07 18:35:10
 */
public interface ScoreService {

    List<ScoreDTO> findAll();

    List<ScoreDTO> findByStudentId(String studentId);

    ScoreDTO findById(Integer id);

    void save(ScoreDTO scoreDTO);

    ScoreDTO updateById(ScoreDTO scoreDTO);

    void removeById(Integer id);
}

