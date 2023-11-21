package com.nky.board.nkyboard.service;

import com.nky.board.nkyboard.entity.Board;
import com.nky.board.nkyboard.entity.Comment;
import com.nky.board.nkyboard.entity.CommentDTO;
import com.nky.board.nkyboard.repository.BoardRepository;
import com.nky.board.nkyboard.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    BoardRepository boardRepo;
    @Autowired
    CommentRepository commentRepo;

    @Override
    public List<CommentDTO> getList(Long bno) {
        Board board = boardRepo.findById(bno).orElse(null);
        List<CommentDTO> list = commentRepo.selectList(bno);
        return list;
    }
    @Override
    public Comment read(Long cno){
        return commentRepo.findById(cno).orElse(null);
    }

    @Override
    public Comment write(Comment comment) {
        return commentRepo.save(comment);    }

    @Override
    public void remove(Comment comment){
        commentRepo.delete(comment);
    }

}
