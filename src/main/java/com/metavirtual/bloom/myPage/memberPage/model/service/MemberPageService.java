package com.metavirtual.bloom.myPage.memberPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.common.exception.myPage.DeleteException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

import java.util.List;

public interface MemberPageService {

    public void modifyMemberInfo(MemberDTO member, UserDTO user) throws ModifyInfoException;

    public boolean selectMemberByNickname(String nickname);

    public int selectTotalCount();

    public List<BoardDTO> selectPostList(SelectCriteria selectCriteria);

    public void deleteMyPost(int boardCode) throws DeleteException;

    public void deleteMyComment(int commentCode) throws DeleteException;

    public void deleteMyReview(int bookingCode) throws DeleteException;
}
