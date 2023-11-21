package com.nky.board.nkyboard.repository;

import com.nky.board.nkyboard.entity.Comment;
import com.nky.board.nkyboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long>,CommentRepositoryCustom {


}