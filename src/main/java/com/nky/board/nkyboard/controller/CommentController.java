package com.nky.board.nkyboard.controller;

import com.nky.board.nkyboard.entity.Board;
import com.nky.board.nkyboard.entity.Comment;
import com.nky.board.nkyboard.entity.Criteria;
import com.nky.board.nkyboard.entity.Member;
import com.nky.board.nkyboard.repository.CommentRepository;
import com.nky.board.nkyboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping("/list/{bno}")
    public String commentList(@PathVariable("bno") Long bno, Model model){
        model.addAttribute("comments",commentService.getList(bno));
        return "commentList";
    }


    @RequestMapping("/write/{bno}")
    @ResponseBody
    public String commentWrite(@PathVariable("bno") Long bno,@RequestBody Comment comment, RedirectAttributes rttr, HttpServletRequest request){
        System.out.println("comment.board = " + comment);
        System.out.println("comment.member = " + comment.getMember());
        Member member = new Member();
        member.setId((String)request.getSession().getAttribute("id"));
        comment.setMember(member);
        comment.setBoard(new Board(bno));

        Comment cmt = commentService.write(comment);
        System.out.println("cmt = " + cmt);
        rttr.addAttribute("bno",bno);
        return "ok";
    }

    @RequestMapping("/remove/{cno}")
    @ResponseBody
    public String commentRemove(@PathVariable("cno") Long cno){
        Comment comment = commentService.read(cno);
        commentService.remove(comment);
        return "ok";
    }
}
