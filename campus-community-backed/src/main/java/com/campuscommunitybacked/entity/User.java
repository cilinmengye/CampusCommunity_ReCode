package com.campuscommunitybacked.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String account;
    private String password; //@JsonIgnore可以让最终返回json的实体类数据时，忽略返回password
    private String nickName;
    private String personalizedSignature;
    private String introduce;
    private String bgImage;
    private String identity;
    private String name;
    private Integer grade;
    private String major;
    private String icon;
    private String honor;
    private Integer fans;
    private Integer goods;
    private String email;
}
