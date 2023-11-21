package com.nky.board.nkyboard.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long cno;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bno",nullable = false)
    private Board board;
    private Long pcno;
    private String pcommenter;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id",nullable = false)
    private Member member;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(insertable = false,updatable = false, columnDefinition = "datetime default now()")
    private Date inDate;

    public Comment() {
    }
    public Comment(Long cno) {
        this.cno = cno;
    }

    public Long getCno() {
        return cno;
    }

    public void setCno(Long cno) {
        this.cno = cno;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Long getPcno() {
        return pcno;
    }

    public void setPcno(Long pcno) {
        this.pcno = pcno;
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

    public String getPcommenter() {
        return pcommenter;
    }

    public void setPcommenter(String pcommenter) {
        this.pcommenter = pcommenter;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cno=" + cno +
                ", pcno=" + pcno +
                ", pcommenter='" + pcommenter + '\'' +
                ", content='" + content + '\'' +
                ", inDate=" + inDate +
                '}';
    }
}
