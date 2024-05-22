package com.campuscommunitybacked.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class BlogPost {
    private Integer id;
    private Integer userId;
    private String nickName;
    private String icon;
    private String title;
    private String images;
    private String content;
    private Integer liked;
    private Integer comments;
    private String tagsStr;
    private List<String> tags;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
