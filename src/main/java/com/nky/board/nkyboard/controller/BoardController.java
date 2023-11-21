package com.nky.board.nkyboard.controller;

import com.nky.board.nkyboard.entity.Board;
import com.nky.board.nkyboard.entity.Criteria;
import com.nky.board.nkyboard.entity.Member;
import com.nky.board.nkyboard.entity.PageMaker;
import com.nky.board.nkyboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/list")
    public String boardList(Model model,Criteria criteria){

        List<Board> list = boardService.getList(criteria);
        model.addAttribute("list",list);
        model.addAttribute("page",new PageMaker(criteria));
        return "boardList";}

    @GetMapping("/write")
    public String boardWriteForm(Model model,Criteria criteria){
        model.addAttribute("criteria",criteria);
        return "boardWrite";

    }

    @PostMapping("/write")
    public String boardWrite(Board board, Criteria criteria, HttpServletRequest request){
        System.out.println("board = " + board);
        Member member = new Member();
        member.setId((String)request.getSession().getAttribute("id"));
        board.setMember(member);
        boardService.write(board);
        return "redirect:/board/list"+criteria.getQueryString();
    }

    @RequestMapping("/read")
    public String boardRead(Long bno, Model model,Criteria criteria){
        Board board = boardService.read(bno);
        model.addAttribute("board",board);
        model.addAttribute("criteria",criteria);
        return "boardContent";

    }
    @RequestMapping("/modify")
    public String boardModify(Board board, RedirectAttributes rttr,Criteria criteria){
        System.out.println("board = " + board);
        boardService.modify(board);
        rttr.addAttribute("bno",board.getBno());
        return "redirect:/board/read"+criteria.getQueryString();
    }

    @RequestMapping("/remove")
    public String boardRemove(Long bno,Criteria criteria){
        boardService.delete(bno);
        return "redirect:/board/list"+criteria.getQueryString();
    }



}
