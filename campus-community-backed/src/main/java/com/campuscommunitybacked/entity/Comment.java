package com.campuscommunitybacked.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private int id;
    private int userId;
    private int blogId;
    private String comment;
    private LocalDateTime createTime;
    private SimpleUser user;
}
