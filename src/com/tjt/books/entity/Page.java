package com.tjt.books.entity;

import java.util.List;

/**
 * @Author tjt
 * @date 2022/5/22 6:31
 * @Version 1.0
 */
public class Page<T> {
    public static final Integer SIZE = 4;
    private Integer pageNo;
    private Integer pageSize = SIZE;
    private Integer totalRow;
    private Integer totalPage ;
    private List<T> items;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalRow=" + totalRow +
                ", totalPage=" + totalPage +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
