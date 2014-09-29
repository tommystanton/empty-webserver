package com.blackhawks;

public class Response {
    public String getStatusLine(int httpCode) {
        String statusCode = "HTTP/1.1 500";
        String reasonMessage = "Internal Server Error";

        if(httpCode == 404) {
            statusCode = "HTTP/1.1 404";
            reasonMessage = "Not Found";
        }
        else if(httpCode == 200) {
            statusCode = "HTTP/1.1 200";
            reasonMessage = "OK";
        }

        return statusCode + " " + reasonMessage;
    }
}
