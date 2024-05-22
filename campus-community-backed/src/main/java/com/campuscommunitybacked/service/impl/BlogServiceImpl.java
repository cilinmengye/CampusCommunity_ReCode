package com.campuscommunitybacked.service.impl;

import com.campuscommunitybacked.entity.*;
import com.campuscommunitybacked.mapper.BlogMapper;
import com.campuscommunitybacked.mapper.UserMapper;
import com.campuscommunitybacked.service.BlogService;
import com.campuscommunitybacked.utils.TransformUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer createBlogPost(BlogPost blogPost, Integer userId) {
        String tagsStr = TransformUtil.listToString(blogPost.getTags());
        blogPost.setTagsStr(tagsStr);
        blogPost.setUserId(userId);
        blogPost.setCreateTime(LocalDateTime.now());
        blogPost.setUpdateTime(LocalDateTime.now());
        blogMapper.createBlogPost(blogPost);
        BlogPost bp =  blogMapper.findLastBlogById(userId);
        return bp.getId();
    }

    @Override
    public PageBean<BlogPost> getBlogPostByCondition(Integer pageNo, Integer size, String tab) {
        PageBean<BlogPost> pageBean = new PageBean<>();
        //1.创建pagebean对象，保存查询数据
        String orderBy;
        if (tab.equals("last")){
            orderBy = "id desc";
        } else if (tab.equals("hot")){
            orderBy = "comments desc";
        } else {
            return null;
        }
        //2.开启分页查询
        PageHelper.startPage(pageNo, size, orderBy);
        //3.调用mapper层代码
        List<BlogPost> bp = blogMapper.getBlogPostByCondition();
        Page<BlogPost> pbp = (Page<BlogPost>) bp;
        pageBean.setItems(pbp.getResult());
        pageBean.setTotal(pbp.getResult().size());
        List<BlogPost> blogPosts = pageBean.getItems();
        for (BlogPost blogPost : blogPosts) {
            User user = userMapper.findById(blogPost.getUserId());
            blogPost.setIcon(user.getIcon());
            blogPost.setNickName(user.getNickName());
        }
        pageBean.setItems(blogPosts);
        return pageBean;
    }

    @Override
    public BlogPost getBlogPostById(Integer id) {
        BlogPost blogPost = blogMapper.getBlogPostById(id);
        //System.out.println(blogPost);
        List<String> tags = TransformUtil.stringToList(blogPost.getTagsStr());
        blogPost.setTags(tags);
        return blogPost;
    }

    @Override
    public void deleteBlogPostById(Integer id) {
        blogMapper.deleteBlogPostById(id);
    }

    @Override
    public void addComment(Comment comment) {
        comment.setCreateTime(LocalDateTime.now());
        blogMapper.addComment(comment);
        blogMapper.updateCommentNumber(comment);
    }

    @Override
    public PageBean<Comment> findCommentByBlogId(Integer blogId) {
        List<Comment> comments = blogMapper.findCommentByBlogId(blogId);
        for (Comment comment : comments) {
            User user = userMapper.findById(comment.getUserId());
            SimpleUser simpleUser = new SimpleUser();
            simpleUser.setNickName(user.getNickName());
            simpleUser.setIcon(user.getIcon());
            simpleUser.setId(user.getId());
            comment.setUser(simpleUser);
        }
        PageBean<Comment> pageBean = new PageBean<>();
        pageBean.setItems(comments);
        pageBean.setTotal(comments.size());
        return pageBean;
    }
}
