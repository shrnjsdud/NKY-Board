package com.nky.board.nkyboard.repository;

import com.nky.board.nkyboard.entity.Board;
import com.nky.board.nkyboard.entity.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepositoryCustom {

    List<Board> selectList(Criteria criteria);
}
