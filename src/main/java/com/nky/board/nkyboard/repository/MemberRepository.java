package com.nky.board.nkyboard.repository;

import com.nky.board.nkyboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
}
