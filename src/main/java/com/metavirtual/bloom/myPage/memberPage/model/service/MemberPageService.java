package com.metavirtual.bloom.myPage.memberPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public interface MemberPageService {

    public void modifyMemberInfo(MemberDTO member, UserDTO user);

    public void deleteMyPost(BoardDTO board, MemberDTO member);

    public void deleteMyComment(MemberCommentDTO comment);
}
