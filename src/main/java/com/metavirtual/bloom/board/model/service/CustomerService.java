package com.metavirtual.bloom.board.model.service;

import com.metavirtual.bloom.board.model.dao.CustomerMapper;
import com.metavirtual.bloom.common.exception.board.CustomerInsertException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.AdminCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
/*
    private final CustomerMapper customerMapper;

    @Autowired
    private CustomerService (CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }


    public int selectTotalCount() {

        int result = customerMapper.selectTotalCount();

        return result;
    }

    public List<AdminCommentDTO> findAllCustomerComment(SelectCriteria selectCriteria) {

        List<AdminCommentDTO> customerComment = customerMapper.findAllCustomerList(selectCriteria);
        return customerComment;
    }

    @Transactional
    public void customerNewInsert(AdminCommentDTO newInsert) throws CustomerInsertException {
        int result = customerMapper.customerNewInsert(newInsert);
        if(!(result > 0)) {
            throw new CustomerInsertException("문의글 등록에 실패하였습니다.");
        }
    }

    public AdminCommentDTO customerSelectOne(int boardCode) {

        AdminCommentDTO selectOne = null;

            selectOne = customerMapper.customerSelectOne(boardCode);


        return selectOne;
    }*/
}
