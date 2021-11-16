package com.olivine.mybatis.mapper;


import com.olivine.mybatis.entity.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-15 01:17:08
 */
public interface UserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserDO queryById(Integer id);

    /**
     * 通过 uid 查询用户
     *
     * @param uid 用户uid
     * @return 用户
     */
    UserDO quaryByUid(Integer uid);


    /**
     * 查询用户列表
     *
     * @return 所有用户
     */
    List<UserDO> quaryAll();


    /**
     * 查询指定行数据
     *
     * @param userDO 查询条件
     * @return 对象列表
     */
    List<UserDO> queryAllByLimit(UserDO userDO);

    /**
     * 统计总行数
     *
     * @param userDO 查询条件
     * @return 总行数
     */
    long count(UserDO userDO);

    /**
     * 新增数据
     *
     * @param userDO 实例对象
     * @return 影响行数
     */
    int insert(UserDO userDO);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserDO> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserDO> entities);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(UserDO user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

