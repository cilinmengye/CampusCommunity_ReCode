package com.campuscommunitybacked.service.impl;

import com.campuscommunitybacked.entity.Billboard;
import com.campuscommunitybacked.mapper.BillBoardMapper;
import com.campuscommunitybacked.service.BillBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillBoardServiceImpl implements BillBoardService {

    @Autowired
    private BillBoardMapper billBoardMapper;

    @Override
    public Billboard getBillboardById(int id) {
        return billBoardMapper.getBillBoardById(id);
    }
}
