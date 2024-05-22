package com.campuscommunitybacked.controller;

import com.campuscommunitybacked.entity.Result;
import com.campuscommunitybacked.utils.AliOssUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/common")
public class CommonController {

    @PostMapping("/upload/users")
    public Result uploadUsersImage(@RequestParam("file") MultipartFile file) throws Exception {
        //System.out.println(file.getOriginalFilename());
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String filePath = "users/"+ UUID.randomUUID().toString() +
                originalFilename.substring(originalFilename.lastIndexOf("."));
        String url = AliOssUtil.uploadImage(filePath, file.getInputStream());
        if (url != null)
            return Result.success(200, url,null);
        else
            return Result.error(400, "图片上传失败");
    }

    @PostMapping("/upload/blogs")
    public Result uploadBlogsImage(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String filePath = "blogs/"+ UUID.randomUUID().toString() +
                originalFilename.substring(originalFilename.lastIndexOf("."));
        String url = AliOssUtil.uploadImage(filePath, file.getInputStream());
        if (url != null)
            return Result.success(200, url,null);
        else
            return Result.error(400, "图片上传失败");
    }
}
