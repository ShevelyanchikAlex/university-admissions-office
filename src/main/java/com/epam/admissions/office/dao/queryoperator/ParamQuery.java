package com.epam.admissions.office.dao.queryoperator;

public class ParamQuery {
    private String query;
    private Object[] params;

    public ParamQuery() {
    }

    public ParamQuery(String query, Object... params) {
        this.query = query;
        this.params = params;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
