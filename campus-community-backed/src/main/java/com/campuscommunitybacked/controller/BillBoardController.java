package com.campuscommunitybacked.controller;

import com.campuscommunitybacked.entity.Billboard;
import com.campuscommunitybacked.entity.Result;
import com.campuscommunitybacked.service.BillBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillBoardController {
    @Autowired
    private BillBoardService billBoardService;

    @RequestMapping("/billboard/queryByShow")
    public Result getBillBoardById() {
        Billboard billboard = billBoardService.getBillboardById(1);
        if (billboard != null) {
            return Result.success(200, billboard, 1);
        } else {
            return Result.error(404, "Not have billBoard!");
        }
    }
}
