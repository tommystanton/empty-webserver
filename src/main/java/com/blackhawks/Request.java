package com.blackhawks;

import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class Request {

    private final String requestLine;
    private String httpMethod;
    private String resource;
    private String httpVersion;

    private String path;

    public static Map<String, String> params;

    public Request(String requestLine) {
        this.requestLine = requestLine;
        this.params = new LinkedHashMap<>();
        parseRequestLine();
        parseResource();
    }

    private void parseResource() {
        String[] parsed = resource.split("\\?");
        path = parsed[0];

        if(parsed.length > 1) {
            String[] pairs = parsed[1].split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                String key = keyValue[0];
                String value = keyValue[1];
                params.put(key, URLDecoder.decode(value));
            }
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

    public String getPath() {
        return path;
    }
}
