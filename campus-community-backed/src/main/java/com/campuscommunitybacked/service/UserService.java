package com.campuscommunitybacked.service;

import com.campuscommunitybacked.entity.Follow;
import com.campuscommunitybacked.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User findByAccount(String account);

    User findById(Integer id);

    void register(String account, String password, String email);

    void updateUserIntroduce(Integer id, String introduce);

    void updateUserInfo(User user);

    void followById(Integer userId, Integer beFollowId);

    void addUserFollowById(Integer beFollowId);

    Follow judgeFollowById(Integer userId, Integer beFollowId);

    void removeFollowById(Integer userId, Integer beFollowId);

    void subUserFollowById(Integer beFollowId);
}
