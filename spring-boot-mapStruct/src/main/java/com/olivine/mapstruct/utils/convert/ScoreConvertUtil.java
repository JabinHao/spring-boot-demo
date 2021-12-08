package com.olivine.mapstruct.utils.convert;

import com.olivine.mapstruct.domain.Score;
import com.olivine.mapstruct.dto.ScoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

/**
 * @Author jphao
 * @Date 21:48 2021/12/07
 * @Description
 */
@Mapper(componentModel = "spring")
public interface ScoreConvertUtil {

    ScoreConvertUtil INSTANCE = Mappers.getMapper(ScoreConvertUtil.class);

    ScoreDTO score2ScoreDTO(Score score);

    Score scoreDTO2Score(ScoreDTO scoreDTO);

    List<ScoreDTO> scores2ScoreDTOs(Collection<Score> scores);
}
