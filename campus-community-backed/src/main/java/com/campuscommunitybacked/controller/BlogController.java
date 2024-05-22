package com.campuscommunitybacked.controller;

import com.campuscommunitybacked.entity.BlogPost;
import com.campuscommunitybacked.entity.PageBean;
import com.campuscommunitybacked.entity.Result;
import com.campuscommunitybacked.service.BlogService;
import com.campuscommunitybacked.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/create")
    public Result createBlogPost(@RequestBody BlogPost blogPost){
        //RequestBody将json数据格式转换为我们的实体类对象
        //在数据库中我的tags是Text类型的，所以保存到数据库的时候需要转化一下
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        Integer blogId =  blogService.createBlogPost(blogPost, userId);
        return Result.success(200, blogId, null);
    }

    @GetMapping
    public Result<List<BlogPost>> getBlogPostByCondition(@RequestParam Integer pageNo, @RequestParam Integer size
    , @RequestParam String tab){
        PageBean<BlogPost>pb = blogService.getBlogPostByCondition(pageNo, size, tab);
        if (pb != null)
            return Result.success(200, pb.getItems(), pb.getTotal());
        else return Result.error(400, "参数错误!");
    }

    //根据id查询帖子
    @GetMapping("/{id}")
    public Result<BlogPost> getBlogPostById(@PathVariable Integer id){
        BlogPost bp = blogService.getBlogPostById(id);
        if (bp != null)
            return Result.success(200, bp, 1);
        else
            return Result.error(400, "查询不到相关帖子");
    }

    @DeleteMapping("/{id}")
    public Result deleteBlogPostById(@PathVariable Integer id){
        blogService.deleteBlogPostById(id);
        return Result.success(200);
    }
}
