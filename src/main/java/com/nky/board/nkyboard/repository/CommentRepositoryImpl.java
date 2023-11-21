package com.nky.board.nkyboard.repository;

import com.nky.board.nkyboard.entity.Comment;
import com.nky.board.nkyboard.entity.CommentDTO;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import static com.nky.board.nkyboard.entity.QComment.comment;
import java.util.List;
@Repository
public class CommentRepositoryImpl implements CommentRepositoryCustom{

    private final JPAQueryFactory qf;

    public CommentRepositoryImpl(JPAQueryFactory qf) {
        this.qf = qf;
    }

    public List<CommentDTO> selectList(Long bno){
        StringPath aliasQuantity = Expressions.stringPath("pcno");


        List<CommentDTO> list = qf.select(Projections.bean(CommentDTO.class,comment.cno,comment.board.bno.as("bno"),comment.pcno.coalesce(comment.cno).as("pcno")
                        ,comment.pcommenter,comment.content,comment.member.id.as("writer"),comment.inDate)).
                from(comment).
                where(comment.board.bno.eq(bno)).
                orderBy(aliasQuantity.asc(),comment.cno.asc()).fetch();

        return list;
    };
}
