package com.campuscommunitybacked.mapper;

import com.campuscommunitybacked.entity.Follow;
import com.campuscommunitybacked.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from users where account = #{account}")
    User findByAccount(String account);

    @Select("select * from users where id = #{id}")
    User findById(Integer id);

    @Insert("insert into users(account, password, email)" +
            " VALUES (#{account}, #{password}, #{email})")
    void register(String account, String password, String email);

    @Update("update users set introduce = #{introduce} where id = #{id}")
    void updateUserIntroduce(Integer id, String introduce);

    @Update("update users set nickName = #{nickName}, personalizedSignature = #{personalizedSignature}, bgImage = #{bgImage}," +
            "identity = #{identity}, email = #{email}, name = #{name}, grade = #{grade}, major = #{major}, icon = #{icon}, honor = #{honor} " +
            "where id = #{id}")
    void updateUserInfo(User user);

    @Insert("insert into follow values (#{userId}, #{beFollowId})")
    void followById(Integer userId, Integer beFollowId);

    @Update("update users set fans = fans + 1 where id = #{beFollowId}")
    void addUserFollowById(Integer beFollowId);

    @Select("select * from follow where userId = #{userId} and beFollowId = #{beFollowId}")
    Follow judgeFollowById(Integer userId, Integer beFollowId);

    @Delete("delete from follow where userId = #{userId} and beFollowId = #{beFollowId}")
    void removeFollowById(Integer userId, Integer beFollowId);

    @Update("update users set fans = fans - 1 where id = #{beFollowId}")
    void subUserFollowById(Integer beFollowId);
}
