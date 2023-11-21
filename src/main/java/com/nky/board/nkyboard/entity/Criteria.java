package com.nky.board.nkyboard.entity;

import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class Criteria {
    private int pageNum;
    private int perPageNum;
    private int totalPages;
    private String type;
    private String keyword;

    public Criteria() {
        this.pageNum = 1;
        this.perPageNum = 10;
    }
    public Criteria(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getQueryString(){

        return UriComponentsBuilder.newInstance()
                .queryParam("pageNum",pageNum)
                .queryParam("type",type)
                .queryParam("keyword",keyword)
                .build().toString();
    }

    public String getQueryString(int page){

        return UriComponentsBuilder.newInstance()
                .queryParam("pageNum",page)
                .queryParam("type",type)
                .queryParam("keyword",keyword)
                .build().toString();
    }

    public int getStartIndex(){
        return (pageNum-1)*perPageNum;
    }


}
