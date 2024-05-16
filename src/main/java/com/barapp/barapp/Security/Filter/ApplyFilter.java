package com.barapp.barapp.Security.Filter;

public class ApplyFilter {

    private String requestUrl;

    public ApplyFilter(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Boolean doFilterOne() {
        return this.AdminRoutes();
    }

    private Boolean AdminRoutes ( ) {
        return this.requestUrl.contains("/admin");
    }

}