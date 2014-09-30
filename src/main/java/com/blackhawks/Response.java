package com.blackhawks;

public class Response {

    private Request request;
    private Router router;

    public Response(Request request, Router router) {
        this.request = request;
        this.router = router;
    }

    public String getStatusLine() {
        String path = request.getPath();
        String statusCode;
        String reasonMessage;

        if(router.isResourceExistent(path)) {
            statusCode = "HTTP/1.1 200";
            reasonMessage = "OK";
        }
        else {
            statusCode = "HTTP/1.1 404";
            reasonMessage = "Not Found";
        }

        return statusCode + " " + reasonMessage;
    }
}
