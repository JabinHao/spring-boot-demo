package com.olivine.mapstruct.service.impl;

import com.olivine.mapstruct.domain.Score;
import com.olivine.mapstruct.dto.ScoreDTO;
import com.olivine.mapstruct.mapper.ScoreMapper;
import com.olivine.mapstruct.service.ScoreService;
import com.olivine.mapstruct.utils.convert.ScoreConvertUtil;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Score)表服务实现类
 *
 * @author makejava
 * @since 2021-12-07 18:35:10
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;


    private final ScoreConvertUtil scoreConvertUtil = Mappers.getMapper(ScoreConvertUtil.class);

    @Override
    public List<ScoreDTO> findAll() {

        List<Score> scores = scoreMapper.selectAll();

        return null;
    }

    @Override
    public ScoreDTO findById(Integer id) {

        Score score = scoreMapper.selectByPrimaryKey(id);
        return null;
    }

    @Override
    public void save(ScoreDTO scoreDTO) {

        scoreMapper.insert();
    }

    @Override
    public ScoreDTO updateById(ScoreDTO scoreDTO) {

        scoreMapper.updateByPrimaryKeySelective();
        Score updatedScore = scoreMapper.selectByPrimaryKey(scoreDTO.getId());
        return null;
    }

    @Override
    public void removeById(Integer id) {
        scoreMapper.deleteByPrimaryKey(id);
    }
}

