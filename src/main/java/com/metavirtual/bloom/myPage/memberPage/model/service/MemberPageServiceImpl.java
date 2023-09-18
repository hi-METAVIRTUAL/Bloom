package com.metavirtual.bloom.myPage.memberPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.myPage.memberPage.model.dao.MemberPageMapper;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class MemberPageServiceImpl implements MemberPageService{

    private final MemberPageMapper mapper;
    public MemberPageServiceImpl(MemberPageMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void modifyMemberInfo(MemberDTO member, UserDTO user){
        int result = mapper.modifyMemberInfo(member, user);

        if(!(result>0)){
            System.out.println("❌회원 정보 수정 실패❌");
        }
    }

    @Override
    public void deleteMyPost(BoardDTO board, MemberDTO member) {

    }

    @Override
    public void deleteMyComment(MemberCommentDTO comment) {

    }

}
