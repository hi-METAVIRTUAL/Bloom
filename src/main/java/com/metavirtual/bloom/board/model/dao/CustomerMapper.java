package com.metavirtual.bloom.board.model.dao;


import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.AdminCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    int selectTotalCount();

    int customerNewInsert(AdminCommentDTO newInsert);

    List<AdminCommentDTO> findAllCustomerList(SelectCriteria selectCriteria);

    AdminCommentDTO customerSelectOne(int boardCode);
}
