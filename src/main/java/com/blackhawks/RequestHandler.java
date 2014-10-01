package com.blackhawks;

public class RequestHandler {
    private Router router;

    public RequestHandler(Router router) {
        this.router = router;
    }

    public Response respond(Request request) {
        String path = request.getPath();

        Response response = new Response(); // TODO Decouple?

        byte[] statusLine = getStatusLine(request);
        response.setStatusLine(statusLine);

        if(router.isResourceExistent(path)) {
            byte[] body = router.executeRoute(path);
            response.setBody(body);
        }
        else {
            response.setBody("".getBytes());
        }

        return response;
    }

    public byte[] getStatusLine(Request request) {
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

        String statusLine = statusCode + " " + reasonMessage;

        return statusLine.getBytes();
    }
}
