package com.olivine.mapstruct.controller;


import com.olivine.common.dto.CommonResponse;
import com.olivine.mapstruct.dto.CourseDTO;
import com.olivine.mapstruct.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2021-12-07 18:33:33
 */
@RestController
@RequestMapping("course")
public class CourseController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/get")
    public CommonResponse<List<CourseDTO>> selectAll() {
        return CommonResponse.success(this.courseService.findAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public CommonResponse<CourseDTO> selectOne(@PathVariable Integer id) {
        return CommonResponse.success(this.courseService.findById(id));
    }

    /**
     * 新增数据
     *
     * @param course 实体对象
     * @return 新增结果
     */
    @PostMapping("/save")
    public CommonResponse<Void> insert(@RequestBody CourseDTO course) {

        courseService.save(course);
        return CommonResponse.success();
    }

    /**
     * 修改数据
     *
     * @param course 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public CommonResponse<CourseDTO> update(@RequestBody CourseDTO course) {
        CourseDTO updatedCourseDTO = courseService.update(course);
        return CommonResponse.success(updatedCourseDTO);
    }

    /**
     * 删除数据
     *
     * @param id 课程编号
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public CommonResponse<Void> delete(@PathVariable("id") Integer id) {
        courseService.deleteById(id);
        return CommonResponse.success();
    }
}

