package com.nky.board.nkyboard.service;

import com.nky.board.nkyboard.entity.Board;
import com.nky.board.nkyboard.entity.Criteria;
import com.nky.board.nkyboard.repository.BoardRepository;
import com.nky.board.nkyboard.repository.BoardRepositoryCustom;
import com.nky.board.nkyboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepo;


    @Override
    public List<Board> getList(Criteria criteria) {
        return boardRepo.selectList(criteria);
    }
    public Board write(Board board){return boardRepo.save(board);};

    @Transactional
    public Board read(Long bno){

        Board board = boardRepo.findById(bno).orElse(null);
        board.setViewCnt(board.getViewCnt()+1);
        boardRepo.save(board);
        return board;}

    public Board modify(Board modify_board){
        Board board = boardRepo.findById(modify_board.getBno()).orElse(null);
        if(board == null) return null;
        board.setContent(modify_board.getContent());
        return boardRepo.save(board);};
    public void delete(Long bno){boardRepo.deleteById(bno);};
}
