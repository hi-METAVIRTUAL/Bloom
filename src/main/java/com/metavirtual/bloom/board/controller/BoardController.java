
package com.metavirtual.bloom.board.controller;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberBoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.board.model.service.BoardService;
import com.metavirtual.bloom.common.exception.board.BoardDeleteException;
import com.metavirtual.bloom.common.exception.board.BoardModifyException;
import com.metavirtual.bloom.common.exception.board.BoardPostingException;
import com.metavirtual.bloom.common.exception.board.CommentPostingException;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    /*전체 게시글 조회 메서드*/
    @GetMapping(value = "/searchList")
    public ModelAndView searchAllList(@RequestParam(required = false) String searchSelect,
                                         @RequestParam(required = false) String searchValue, @RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                         ModelAndView mv) {

        /* 검색 조건을 객체에 담아 전송 */
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchSelect", searchSelect);
        searchMap.put("searchValue", searchValue);

        System.out.println("검색조건 : " + searchMap);

        int totalBoardCount = boardService.selectTotalCount(searchMap);

        System.out.println("총 게시물 수 : " + totalBoardCount);

        int limitPerPage = 10;

        int buttonAmount = 5;

        SelectCriteria selectCriteria;

        if(searchSelect != null && !"".equals(searchSelect)) {
            selectCriteria = Paging.getSelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, searchSelect, searchValue);
        } else {
            selectCriteria = Paging.getSelectCriteria (pageNo, totalBoardCount, limitPerPage, buttonAmount);
        }

        List<BoardDTO> boardList = boardService.findAllBoard(selectCriteria);

        mv.addObject("boardList", boardList);
        mv.addObject("selectCriteria", selectCriteria);

        System.out.println("가져온 게시글 리스트? : " + boardList);
        System.out.println("조회리스트에 따른 페이징 처리는? : " + selectCriteria);
        mv.setViewName("board/boardPagingTest");

        return mv;
    }

    /* 게시글 상세 조회 */

    @GetMapping("/boardSelectOne")
    public String boardSelectOne (HttpServletRequest request, Model model) {

        int boardCode = Integer.valueOf(request.getParameter("boardCode"));
        BoardDTO selectOne = boardService.boardSelectOne(boardCode);
        System.out.println("디테일 가져오는지? : " + selectOne);

        model.addAttribute("board", selectOne);

    /* 댓글 조회 */
/*

        List<MemberCommentDTO> commentList = boardService.searchAllComment(boardCode);
        model.addAttribute("commentList", commentList);

*/

        return "board/boardSelectOne";
    }

    /* 게시글 등록 화면*/
    @GetMapping("/boardPosting")
    public String boardContentPosting() {
        return "board/boardInsert";
    }

    /* 게시글 등록 메서드 */
    @PostMapping("/boardPosting")
    public String boardContentPosting(@ModelAttribute MemberBoardDTO newPosting, RedirectAttributes rttr) throws BoardPostingException {

        System.out.println("파라미터 값? : " + newPosting);
        boardService.boardNewPosting(newPosting);

        rttr.addFlashAttribute("successMessage", "게시글 등록에 성공하였습니다");
        return "redirect:/board/searchList";
    }

    /* 게시글 수정 화면 */

    /* 게시글 수정 메서드 */
    @PostMapping("/boardModify")
    public String boardModify(@ModelAttribute MemberBoardDTO modifyBoard, RedirectAttributes rttr) throws BoardModifyException {

        System.out.println("파라미터 값? : " + modifyBoard);
        boardService.boardModify(modifyBoard);


        rttr.addFlashAttribute("successMessage", "게시글 수정에 성공하였습니다");
        return "redirect:/board/boardSelectOne";
    }

    /* 게시글 삭제 메서드 */
    @PostMapping("/boardDelete")
    public String boardDelete(@ModelAttribute MemberBoardDTO deleteBoard, RedirectAttributes rttr) throws BoardDeleteException {

        System.out.println("요청도달?? : " + deleteBoard);
        boardService.boardDelete(deleteBoard);

        rttr.addFlashAttribute("successMessage", "게시글 삭제에 성공하였습니다");
        return "redirect:/board/boardSelectOne";
    }


    /* 댓글 등록 메서드 */
    @PostMapping("/commentPosting")
    public List<MemberCommentDTO> commentNewPosting(@RequestBody MemberCommentDTO newComment) throws CommentPostingException {

        List<MemberCommentDTO> commentList = boardService.commentNewPosting(newComment);

        return commentList;
    }


    @GetMapping("/singo")
    public String singo() {
        return "board/singo";
    }

    @GetMapping("/singoResult")
    public String singojupsu() {
        return "board/singoResult";
    }

    @GetMapping("/gomin")
    public String gominSangdamSo() {
        return "board/gominMain";
    }

    @GetMapping("/gominInsert")
    public String gominInsert() {
        return "board/gominInsert";
    }


    @GetMapping("/gominselectone")
    public String gominselectone() {
        return "/board/gominSelectOne";
    }

    @GetMapping("/gominwait")
    public String gominwait() {
        return "/board/gominWait";
    }

    @GetMapping("/center")
    public String center() {
        return "/board/customerCenter";
    }

    @GetMapping("/customerInsert")
    public String centerInsert() {
        return "/board/customerInsert";
    }

    @GetMapping("/customerSelectOne")
    public String centerSelectOne() {
        return "/board/customerSelectOne";
    }

}

