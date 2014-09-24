package com.blackhawks;

public class Request {
    private String httpMethod;
    private String url;
    private String httpVersion;


    public Request(String req) {
        httpMethod = req.split("\\s+")[0];
        url = req.split("\\s+")[1];
        httpVersion = req.split("\\s+")[2];

    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}