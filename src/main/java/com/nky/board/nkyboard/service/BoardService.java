package com.nky.board.nkyboard.service;

import com.nky.board.nkyboard.entity.Board;
import com.nky.board.nkyboard.entity.Criteria;
import com.nky.board.nkyboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    List<Board> getList(Criteria criteria);
    Board write(Board board);
    Board read(Long bno);
    Board modify(Board board);
    void delete(Long bno);
}
