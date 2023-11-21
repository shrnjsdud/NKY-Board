package com.nky.board.nkyboard.controller;

import com.nky.board.nkyboard.entity.Criteria;
import com.nky.board.nkyboard.entity.Member;
import com.nky.board.nkyboard.service.MemberService;
import com.nky.board.nkyboard.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.script.ScriptEngine;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String memberLoginForm(@CookieValue(name = "id", required = false)String id, @ModelAttribute Criteria criteria,Model model){
        model.addAttribute("id",id);
        return "memberLogin";
    }
    @PostMapping("/login")
    public String memberLogin(String id, String password, boolean remember, RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response){
        Member member = memberService.read(id);
        if(member == null) {
            rttr.addFlashAttribute("msg","ID 와 일치하는 회원이 없습니다.");
            System.out.println("ID 와 일치하는 회원이 없습니다.");
            return "redirect:/member/login";
        }

        if(!member.getPassword().equals(password)){
            rttr.addFlashAttribute("msg","비밀번호를 다시 확인해주세요");
            System.out.println("비밀번호를 다시 확인해주세요");
            return "redirect:/member/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("id",member.getId());

        if(remember) {

            Cookie cookie = new Cookie("id", id); // ctrl+shift+o 자동 import
            System.out.println("cookie 생성");
            response.addCookie(cookie);
        } else {

            Cookie cookie = new Cookie("id", id); // ctrl+shift+o 자동 import
            cookie.setMaxAge(0); // 쿠키를 삭제
            System.out.println("cookie 삭제");
            response.addCookie(cookie);
        }


        System.out.println("login 성공");
        return "redirect:/board/list";
    }
    @GetMapping("/logout")
    public String memberLogout(HttpServletRequest request){

        request.getSession().invalidate();

        return "redirect:/board/list";
    }


    @GetMapping("/register")
    public String memberRegisterForm(Criteria criteria){
        System.out.println(criteria.getQueryString());

        return "memberRegister";
    }
    @PostMapping("/register")
    public String memberRegister(Member member, RedirectAttributes rttr){
        memberService.register(member);
        rttr.addFlashAttribute("msg","회원가입에 성공했습니다. 로그인 해주세요");
        return "redirect:/member/login";
    }

    @GetMapping("/check")
    @ResponseBody
    public String memberIdCheck(String id){
        System.out.println("#### id_check ####");
        Member member = memberService.read(id);
        if(member == null) return "non-exist";
        return "exist";
    }


}
