package com.olivine.mapstruct.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import .entity.Score;
import .service.ScoreService;
import com.olivine.common.dto.CommonResponse;
import com.olivine.mapstruct.domain.Score;
import com.olivine.mapstruct.dto.ScoreDTO;
import org.springframework.web.bind.annotation.*;
import com.olivine.mapstruct.service.ScoreService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static org.junit.platform.commons.function.Try.success;

/**
 * (Score)表控制层
 *
 * @author makejava
 * @since 2021-12-07 18:35:10
 */
@RestController
@RequestMapping("score")
public class ScoreController {
    /**
     * 服务对象
     */
    @Resource
    private ScoreService scoreService;

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/get")
    public CommonResponse<List<ScoreDTO>> selectAll() {
        return CommonResponse.success(this.scoreService.findAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public CommonResponse<ScoreDTO> selectOne(@PathVariable Integer id) {
        return CommonResponse.success(this.scoreService.findById(id));
    }

    /**
     * 新增数据
     *
     * @param scoreDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/save")
    public CommonResponse<Void> insert(@RequestBody ScoreDTO scoreDTO) {
        this.scoreService.save(scoreDTO);
        return CommonResponse.success();
    }

    /**
     * 修改数据
     *
     * @param scoreDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResponse<ScoreDTO> update(@RequestBody ScoreDTO scoreDTO) {
        return CommonResponse.success(this.scoreService.updateById(scoreDTO));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/delete/{id}")
    public CommonResponse<Void> delete(@PathVariable("id") Integer id) {

        this.scoreService.removeById(id);
        return CommonResponse.success();
    }
}
