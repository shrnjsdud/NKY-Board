package com.nky.board.nkyboard.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Board {
    @Id
    @GeneratedValue
    private Long bno;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(insertable = false,updatable = false, columnDefinition = "datetime default now()")
    private Date inDate;

    @Column(insertable = false, columnDefinition = "int default 0")
    private Long viewCnt;

    @OneToMany(mappedBy = "board",cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    public Board() {
    }

    public Board(Long bno) {
        this.bno = bno;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Long getBno() {
        return bno;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Long getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Long viewCnt) {
        this.viewCnt = viewCnt;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                "comment" + commentList + '\'' +
                '}';
    }
}
