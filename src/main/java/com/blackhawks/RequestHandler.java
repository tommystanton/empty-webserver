package com.blackhawks;

public class RequestHandler {
    private Router router;

    public RequestHandler(Router router) {
        this.router = router;
    }

    public Response respond(Request request) {
        Response response = new Response(); // TODO Decouple?

        String statusLine = getStatusLine(request);
        response.setStatusLine(statusLine);

        return response;
    }

    public String getStatusLine(Request request) {
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
