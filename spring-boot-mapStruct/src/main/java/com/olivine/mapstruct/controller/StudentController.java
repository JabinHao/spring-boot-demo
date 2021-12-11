package com.olivine.mapstruct.controller;


import com.olivine.common.dto.CommonResponse;
import com.olivine.mapstruct.dto.StudentDTO;
import com.olivine.mapstruct.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2021-12-07 18:35:10
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/get")
    public CommonResponse<List<StudentDTO>> selectAll() {
        return CommonResponse.success(this.studentService.findAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public CommonResponse<StudentDTO> getById(@PathVariable Serializable id) {
        return CommonResponse.success(this.studentService.findById(id));
    }

    @GetMapping("/get/info/{id}")
    public CommonResponse<StudentDTO> getInfoById(@PathVariable("id") String id){
        final StudentDTO studentDTO = this.studentService.findWithScoreById(id);
        if (studentDTO == null)
            return CommonResponse.empty();
        return CommonResponse.success(studentDTO);
    }

    /**
     * 新增数据
     *
     * @param studentDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/save")
    public CommonResponse<Void> save(@RequestBody StudentDTO studentDTO) {
        this.studentService.save(studentDTO);
        return CommonResponse.success();
    }

    /**
     * 修改数据
     *
     * @param studentDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public CommonResponse<StudentDTO> update(@RequestBody StudentDTO studentDTO) {
        return CommonResponse.success(this.studentService.updateById(studentDTO));
    }

    /**
     * 删除数据
     *
     * @param id 学号
     * @return 删除结果
     */
    @DeleteMapping("/delete/{id}")
    public CommonResponse<Void> delete(@PathVariable("id") String id) {
        this.studentService.removeById(id);
        return CommonResponse.success();
    }
}

