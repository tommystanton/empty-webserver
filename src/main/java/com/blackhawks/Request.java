package com.blackhawks;

public class Request {

    public Request(String requestLine) {

    }

    public String getHttpMethod() {
        return "GET";
    }

    public String getResource() {
        return "/";
    }

}
