package com.campuscommunitybacked.controller;

import com.campuscommunitybacked.entity.Comment;
import com.campuscommunitybacked.entity.PageBean;
import com.campuscommunitybacked.entity.Result;
import com.campuscommunitybacked.service.BlogService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    BlogService blogService;

    @PostMapping
    public Result addComment(@RequestBody Comment comment) {
        blogService.addComment(comment);
        return Result.success(200);
    }
    @GetMapping
    public Result<List<Comment>> findCommentByBlogId(@RequestParam Integer blogId) {
        PageBean<Comment> pbc =  blogService.findCommentByBlogId(blogId);
        return Result.success(200, pbc.getItems(), pbc.getTotal());
    }
}
