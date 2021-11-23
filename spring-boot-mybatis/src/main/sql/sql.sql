CREATE DATABASE IF NOT EXISTS mybatis_demo;

USE mybatis_demo;

CREATE TABLE User(
                     `id` INT NOT NULL AUTO_INCREMENT,
                     `name` VARCHAR(20) NOT NULL COMMENT '姓名',
                     `uid` VARCHAR(40) NOT NULL COMMENT 'uid',
                     `auth_level` INT NOT NULL COMMENT '等级',
                     `game_platform` VARCHAR(10) NOT NULL COMMENT '平台',
                     `ctime` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
                     `mtime` DATETIME NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
                     PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;