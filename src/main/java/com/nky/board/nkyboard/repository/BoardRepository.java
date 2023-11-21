package com.nky.board.nkyboard.repository;

import com.nky.board.nkyboard.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>,BoardRepositoryCustom{
}
