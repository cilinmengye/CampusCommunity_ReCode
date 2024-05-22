package com.campuscommunitybacked.controller;

import com.campuscommunitybacked.entity.Follow;
import com.campuscommunitybacked.entity.Result;
import com.campuscommunitybacked.service.UserService;
import com.campuscommunitybacked.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public Result followById(@RequestParam("userId") Integer beFollowId){
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        userService.followById(userId, beFollowId);
        userService.addUserFollowById(beFollowId);
        return Result.success(200);
    }
    @GetMapping("/check")
    public Result<Boolean> judgeFollowById(@RequestParam("userId") Integer beFollowId){
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        Follow follow = userService.judgeFollowById(userId, beFollowId);
        if (follow != null)
            return Result.success(200, true,null);
        else return Result.success(200, false,null);
    }
    @DeleteMapping("/remove")
    public Result removeFollowById(@RequestParam("userId") Integer beFollowId){
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        userService.removeFollowById(userId, beFollowId);
        userService.subUserFollowById(beFollowId);
        return Result.success(200);
    }
}
