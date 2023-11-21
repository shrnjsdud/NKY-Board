package com.nky.board.nkyboard.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "member",cascade = CascadeType.REMOVE)
    private List<Board> boardList;
    @OneToMany(mappedBy = "member",cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

}
