package com.nky.board.nkyboard.repository;

import com.nky.board.nkyboard.entity.Comment;
import com.nky.board.nkyboard.entity.CommentDTO;
import com.querydsl.core.Tuple;

import java.util.List;

public interface CommentRepositoryCustom {
    List<CommentDTO> selectList(Long bno);
}
