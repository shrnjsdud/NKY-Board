package com.nky.board.nkyboard.service;

import com.nky.board.nkyboard.entity.Member;

public interface MemberService {
    Member read(String id);

    Member register(Member member);
}
