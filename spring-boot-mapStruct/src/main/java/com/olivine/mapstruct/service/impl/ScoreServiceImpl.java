package com.olivine.mapstruct.service.impl;

import com.olivine.mapstruct.domain.Score;
import com.olivine.mapstruct.dto.ScoreDTO;
import com.olivine.mapstruct.mapper.ScoreMapper;
import com.olivine.mapstruct.service.ScoreService;
import com.olivine.mapstruct.utils.convert.ScoreConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.olivine.mapstruct.utils.CommonConstants.JSON;

/**
 * (Score)表服务实现类
 *
 * @author jphao
 * @since 2021-12-07 18:35:10
 */
@Slf4j
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;
    private final ScoreConvertUtil scoreConvertUtil;

    public ScoreServiceImpl(ScoreMapper scoreMapper, ScoreConvertUtil scoreConvertUtil) {
        this.scoreMapper = scoreMapper;
        this.scoreConvertUtil = scoreConvertUtil;
    }


    @Override
    public List<ScoreDTO> findAll() {

        List<Score> scores = scoreMapper.selectAll();
        log.info("查询所有成绩信息: {}", JSON.toJson(scores));
        return scoreConvertUtil.scores2ScoreDTOs(scores);
    }

    @Override
    public List<ScoreDTO> findByStudentId(String studentId) {
        final List<Score> scores = scoreMapper.selectByStudentId(studentId);
        final List<ScoreDTO> scoreDTOs = scoreConvertUtil.scores2ScoreDTOs(scores);
        log.info("查询{}同学的成绩信息：{}", studentId, JSON.toJson(scoreDTOs));
        return scoreDTOs;
    }

    @Override
    public ScoreDTO findById(Integer id) {

        Score score = scoreMapper.selectByPrimaryKey(id);
        log.info("查询成绩信息: {}", score);
        return scoreConvertUtil.score2ScoreDTO(score);
    }

    @Override
    public void save(ScoreDTO scoreDTO) {

        final Score score = scoreConvertUtil.scoreDTO2Score(scoreDTO);
        scoreMapper.insert(score);
        log.info("保存成绩信息：{}", scoreDTO);
    }

    @Override
    public ScoreDTO updateById(ScoreDTO scoreDTO) {

        final Score score = scoreConvertUtil.scoreDTO2Score(scoreDTO);
        scoreMapper.updateByPrimaryKeySelective(score);
        Score updatedScore = scoreMapper.selectByPrimaryKey(scoreDTO.getId());
        log.info("更新信息: {}", updatedScore);
        return scoreConvertUtil.score2ScoreDTO(updatedScore);
    }

    @Override
    public void removeById(Integer id) {
        final Score score = scoreMapper.selectByPrimaryKey(id);
        scoreMapper.deleteByPrimaryKey(id);
        log.info("删除成绩信息: {}", score);

    }
}

