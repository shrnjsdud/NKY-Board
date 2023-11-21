package com.nky.board.nkyboard.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class CommentDTO {

    private Long cno;
    private Long bno;
    private Long pcno;
    private String pcommenter;
    private String content;
    private String writer;
    private Date inDate;

}
