package com.olivine.mapstruct.controller;


import com.olivine.common.dto.CommonResponse;
import com.olivine.mapstruct.dto.TeacherDTO;
import com.olivine.mapstruct.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Teacher)表控制层
 *
 * @author makejava
 * @since 2021-12-07 18:35:11
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/get")
    public CommonResponse<List<TeacherDTO>> selectAll() {
        return CommonResponse.success(this.teacherService.findAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public CommonResponse<TeacherDTO> selectById(@PathVariable Integer id) {
        return CommonResponse.success(this.teacherService.findById(id));
    }

    /**
     * 新增数据
     *
     * @param teacherDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/save")
    public CommonResponse<Void> insert(@RequestBody TeacherDTO teacherDTO) {
        this.teacherService.save(teacherDTO);
        return CommonResponse.success();
    }

    /**
     * 修改数据
     *
     * @param teacherDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public CommonResponse<TeacherDTO> update(@RequestBody TeacherDTO teacherDTO) {
        return CommonResponse.success(this.teacherService.updateById(teacherDTO));
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete/{id}")
    public CommonResponse<Void> delete(@PathVariable("id") Integer id) {
        this.teacherService.removeById(id);
        return CommonResponse.success();
    }
}

