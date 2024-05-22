package com.campuscommunitybacked.exception;

import com.campuscommunitybacked.entity.Result;
import com.mysql.cj.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result GlobalExceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.error(400, !e.getMessage().isEmpty() ? e.getMessage() : "操作失败");
    }
}
