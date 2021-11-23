package com.olivine.mybatis.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author jphao
 * @date 2021/11/21 22:20
 * @description
 */
@Data
public class UserDO {

    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * uid
     */
    private String uid;
    /**
     * 等级
     */
    private Integer authLevel;
    /**
     * 平台
     */
    private String gamePlatform;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 修改时间
     */
    private Date mtime;
}
