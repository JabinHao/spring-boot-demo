package com.olivine.mybatis.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author jphao
 * @Date 19:50 2021/11/16
 * @Description
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 581139963090723296L;

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
    @JsonProperty("auth_level")
    private Integer authLevel;
    /**
     * 平台
     */
    @JsonProperty("game_platform")
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
