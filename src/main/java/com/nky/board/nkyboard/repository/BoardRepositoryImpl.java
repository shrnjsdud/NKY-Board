package com.nky.board.nkyboard.repository;

import com.nky.board.nkyboard.entity.Board;
import com.nky.board.nkyboard.entity.Criteria;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static com.nky.board.nkyboard.entity.QBoard.board;

import java.util.List;
@Repository
public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory qf;

    public BoardRepositoryImpl(JPAQueryFactory qf) {
        this.qf = qf;
    }

    @Override
    public List<Board> selectList(Criteria criteria) {


        BooleanBuilder builder = new BooleanBuilder();
        if(criteria.getType() != null && criteria.getKeyword() != null) {
            String type = criteria.getType();
            String keyword = criteria.getKeyword();

        if(type.equalsIgnoreCase("T"))
            builder.and(board.title.like("%"+keyword+"%"));
        if(type.equalsIgnoreCase("W"))
            builder.and(board.member.id.like("%"+keyword+"%"));
        }
        Long start = new Long(criteria.getStartIndex());
        Long end = new Long(criteria.getPerPageNum());
        List<Board> list = qf.
                selectFrom(board).
                where(builder).
                offset(start).
                limit(end).
                orderBy(board.bno.desc()).
                fetch();

        Long count = qf.
                select(board.count()).
                from(board).
                where(builder).
                fetchFirst();
        criteria.setTotalPages(count.intValue());

        return list;

    }
}
