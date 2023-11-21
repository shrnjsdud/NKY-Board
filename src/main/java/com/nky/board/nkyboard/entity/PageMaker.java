package com.nky.board.nkyboard.entity;

import lombok.Data;

@Data
public class PageMaker {
    private Criteria criteria;
    private int startPage;
    private int endPage;
    private int pageCnt;
    private int naviNum;
    private boolean prev;
    private boolean next;

    public PageMaker(){}

    public PageMaker(Criteria criteria) {
        this.criteria = criteria;
        this.naviNum = 5;
        pageMaker();
    }
    void pageMaker(){
        pageCnt = (int)Math.ceil(criteria.getTotalPages()/(double)criteria.getPerPageNum());
        endPage = (int)(Math.ceil(criteria.getPageNum()/(double)naviNum)*naviNum);
        startPage = endPage - naviNum +1;
        if(endPage > pageCnt){endPage = pageCnt;}
        prev = (startPage == 1)? false:true;
        next = (endPage == pageCnt)? false: true;

    }




}
