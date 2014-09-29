package com.blackhawks;

public class Request {

    private final String requestLine;
    private String httpMethod;
    private String resource;
    private String httpVersion;

    public Request(String requestLine) {
        this.requestLine = requestLine;
        parseRequestLine();
    }

    private void parseRequestLine() {
        String[] parsed = requestLine.split("\\s+");
        httpMethod = parsed[0];
        resource = parsed[1];
        httpVersion = parsed[2];
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getResource() {
        return resource;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}
