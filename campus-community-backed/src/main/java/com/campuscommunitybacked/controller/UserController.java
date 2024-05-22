package com.campuscommunitybacked.controller;

import com.campuscommunitybacked.entity.Follow;
import com.campuscommunitybacked.entity.Result;
import com.campuscommunitybacked.entity.SimpleUser;
import com.campuscommunitybacked.entity.User;
import com.campuscommunitybacked.service.UserService;
import com.campuscommunitybacked.utils.JwtUtil;
import com.campuscommunitybacked.utils.Md5Util;
import com.campuscommunitybacked.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User userBody) {
        System.out.println(userBody);
        // 查询用户,禁止用户名重复
        User user = userService.findByAccount(userBody.getAccount());
        // 注册
        if (user == null) {
            userService.register(userBody.getAccount(), userBody.getPassword(), userBody.getEmail());
            return Result.success(200);
        } else {
            return Result.error(400, "用户名已经存在!");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody User userBody){
        // 查询用户
        User user = userService.findByAccount(userBody.getAccount());
        //判断密码是否正确
        if(user == null){
            return Result.error(400, "用户名错误");
        }
        if (Md5Util.getPwd(userBody.getPassword()).equals(user.getPassword())){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("account", user.getAccount());
            String token = JwtUtil.genToken(claims);
            //将token保存到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token, 12, TimeUnit.HOURS);
            return Result.success(200, token, null);
        } else {
            return Result.error(400, "密码错误");
        }
    }

    @PostMapping("/logout")
    public Result logout(@RequestHeader("Authorization") String token){
        //删除redis中的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return Result.success(200);
    }


    @GetMapping("/me")
    public Result getSimpleUserInfo(){
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        User user = userService.findById(userId);
        SimpleUser simpleUser = new SimpleUser();
        simpleUser.setId(user.getId());
        simpleUser.setNickName(user.getNickName());
        simpleUser.setIcon(user.getIcon());
        return Result.success(200, simpleUser, null);
    }

    @GetMapping("/info/{id}")
    public Result getUserInfo(@PathVariable("id") Integer userId){
        User user = userService.findById(userId);
        return Result.success(200, user, null);
    }

    @PostMapping("/info/introduce")
    public Result updateUserIntroduce(@RequestBody Map<String, Object> params){
        String introduce = (String) params.get("introduce");
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        //System.out.println(userId);
        //System.out.println(introduce);
        userService.updateUserIntroduce(userId, introduce);
        return Result.success(200, null, null);
    }

    @PostMapping("/info")
    public Result updateUserInfo(@RequestBody User user){
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        user.setId(userId);
        userService.updateUserInfo(user);
        return Result.success(200, null, null);
    }
}
