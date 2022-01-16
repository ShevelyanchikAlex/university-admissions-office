package com.epam.admissions.office.dao.queryoperator;

public class ParametrizedQuery {
    private String query;
    private Object[] params;

    public ParametrizedQuery(){}

    public ParametrizedQuery(String query, Object... params) {
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
