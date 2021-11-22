package com.olivine.mybatis.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jphao
 * @date 2021/11/21 22:22
 * @description
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 356139963090723296L;

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
