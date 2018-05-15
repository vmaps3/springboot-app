package com.wangsong.common.model;

public class GetEasyUIData {
    private Object rows;
    private int total;

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public GetEasyUIData(Object rows, int total) {
        super();
        this.rows = rows;
        this.total = total;
    }

    public GetEasyUIData() {

    }
}
