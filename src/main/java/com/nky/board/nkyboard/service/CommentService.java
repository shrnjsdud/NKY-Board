package com.nky.board.nkyboard.service;

import com.nky.board.nkyboard.entity.Comment;
import com.nky.board.nkyboard.entity.CommentDTO;
import com.nky.board.nkyboard.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CommentService {
   List<CommentDTO> getList(Long bno);

   Comment read(Long cno);
   Comment write(Comment comment);
    void remove(Comment comment);

}
