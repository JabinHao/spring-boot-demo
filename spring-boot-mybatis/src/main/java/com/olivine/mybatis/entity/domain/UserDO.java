package com.olivine.mybatis.entity.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-11-15 01:17:12
 */
public class UserDO implements Serializable {
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(Integer authLevel) {
        this.authLevel = authLevel;
    }

    public String getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(String gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

}

