package com.blackhawks;

public class Response {

    private Request request;

    public Response(Request request) {
        this.request = request;
    }

    public String getStatusLine() {
        String statusCode = "HTTP/1.1 500";
        String reasonMessage = "Internal Server Error";

        if(request.getResource().equals("/foobar")) {
            statusCode = "HTTP/1.1 404";
            reasonMessage = "Not Found";
        }
        else if(request.getResource().equals("/")) {
            statusCode = "HTTP/1.1 200";
            reasonMessage = "OK";
        }

        return statusCode + " " + reasonMessage;
    }
}
