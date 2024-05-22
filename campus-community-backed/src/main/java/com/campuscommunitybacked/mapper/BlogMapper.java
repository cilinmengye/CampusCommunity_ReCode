package com.campuscommunitybacked.mapper;

import com.campuscommunitybacked.entity.BlogPost;
import com.campuscommunitybacked.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogMapper {

    @Insert("insert into blogpost(userId, title, images, content, tagsStr, createTime, updateTime) " +
            "values (#{userId}, #{title}, #{images}, #{content} , " +
            "#{tagsStr}, #{createTime}, #{updateTime})")
    void createBlogPost(BlogPost blogPost);

    @Select("select * from blogpost")
    List<BlogPost> getBlogPostByCondition();

    @Select("select * from blogpost where id = #{id}")
    BlogPost getBlogPostById(Integer id);

    @Delete("delete from blogpost where id = #{id}")
    void deleteBlogPostById(Integer id);

    @Insert("insert into comment(userId, blogId, comment, createTime) " +
            "values (#{userId}, #{blogId}, #{comment}, #{createTime})")
    void addComment(Comment comment);

    @Select("select * from comment where blogId = #{blogId}")
    List<Comment> findCommentByBlogId(Integer blogId);

    @Select("select * from blogpost where userId = #{userId} and id = (" +
            "select max(id) from blogpost where userId = #{userId}" +
            ")")
    BlogPost findLastBlogById(Integer userId);

    @Update("update blogpost set comments = (select count(*) from comment where blogId = #{blogId}) where id = #{blogId}")
    void updateCommentNumber(Comment comment);
}
