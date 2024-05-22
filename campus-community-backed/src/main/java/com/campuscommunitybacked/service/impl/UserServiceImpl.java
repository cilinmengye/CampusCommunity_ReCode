package com.campuscommunitybacked.service.impl;

import com.campuscommunitybacked.entity.Follow;
import com.campuscommunitybacked.entity.User;
import com.campuscommunitybacked.mapper.UserMapper;
import com.campuscommunitybacked.service.UserService;
import com.campuscommunitybacked.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void register(String account, String password, String email) {
        //加密，使用Md5工具类加密
        String md5Pwd = Md5Util.getPwd(password);
        //添加
        userMapper.register(account, md5Pwd, email);
    }

    @Override
    public void updateUserIntroduce(Integer id, String introduce) {
        //System.out.println(introduce);
        userMapper.updateUserIntroduce(id, introduce);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    @Override
    public void followById(Integer userId, Integer beFollowId) {
        userMapper.followById(userId, beFollowId);
    }

    @Override
    public void addUserFollowById(Integer beFollowId) {
        userMapper.addUserFollowById(beFollowId);
    }

    @Override
    public Follow judgeFollowById(Integer userId, Integer beFollowId) {
        //System.out.println(userId);
        //System.out.println(beFollowId);
        Follow follow = userMapper.judgeFollowById(userId, beFollowId);
        if (follow == null) {
            return follow;
        } else
            return null;
    }

    @Override
    public void removeFollowById(Integer userId, Integer beFollowId) {
        userMapper.removeFollowById(userId, beFollowId);
    }

    @Override
    public void subUserFollowById(Integer beFollowId) {
        userMapper.subUserFollowById(beFollowId);
    }
}
