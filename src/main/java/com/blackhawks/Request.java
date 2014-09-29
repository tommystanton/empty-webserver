package com.blackhawks;

import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class Request {

    private final String requestLine;
    private String httpMethod;
    private String resource;
    private String httpVersion;

    public static Map<String, String> params = new LinkedHashMap<>();

    public Request(String requestLine) {
        this.requestLine = requestLine;
        parseRequestLine();
        parseResource();
    }

    private void parseResource() {
        String[] parsed = resource.split("\\?");
        if(parsed.length > 1) {
            parsed = parsed[1].split("=");
            String key = parsed[0];
            String value = parsed[1];

            params.put(key, URLDecoder.decode(value));
        }
    }

    public Map<String, String> getParams() {
        return params;
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
