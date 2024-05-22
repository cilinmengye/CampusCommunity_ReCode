package com.campuscommunitybacked.mapper;

import com.campuscommunitybacked.entity.Billboard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BillBoardMapper {
    @Select("select * from billboard where id = #{id}")
    public Billboard getBillBoardById(Integer id);
}
