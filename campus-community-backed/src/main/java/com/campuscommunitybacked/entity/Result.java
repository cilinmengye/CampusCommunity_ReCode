package com.campuscommunitybacked.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Boolean success;
    private Integer code;
    private String errorMsg;
    private T data;
    private Integer total;

    //返回成功且带data参数
    public static <E> Result<E> success(Integer code, E data, Integer total) {
        return new Result<>(true, code, null, data, total);
    }

    //返回成功但是无data参数
    public static Result success(Integer code){
        return new Result(true, code, null, null, null);
    }

    //返回失败
    public static Result error(Integer code, String errorMsg) {
        return new Result(false, code, errorMsg, null, null);
    }
}
