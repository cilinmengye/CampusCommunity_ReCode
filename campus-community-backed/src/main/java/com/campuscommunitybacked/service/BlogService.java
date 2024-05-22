package com.campuscommunitybacked.service;

import com.campuscommunitybacked.entity.BlogPost;
import com.campuscommunitybacked.entity.Comment;
import com.campuscommunitybacked.entity.PageBean;

public interface BlogService {
    Integer createBlogPost(BlogPost blogPost, Integer userId);

    PageBean<BlogPost> getBlogPostByCondition(Integer pageNo, Integer size, String tab);

    BlogPost getBlogPostById(Integer id);

    void deleteBlogPostById(Integer id);

    void addComment(Comment comment);

    PageBean<Comment> findCommentByBlogId(Integer blogId);
}
