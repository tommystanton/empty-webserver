package com.blackhawks;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;

public class RequestHandler {
    private Router router;

    public RequestHandler(Router router) {
        this.router = router;
    }

    public Response respond(Request request) throws IOException {
        String path = request.getPath();

        Response response = new Response(); // TODO Decouple?

        byte[] statusLine = getStatusLine(request);
        response.setStatusLine(statusLine);

        if (router.isResourceExistent(path)) {
            byte[] body = router.executeRoute(request, response);

            String responseHeaders = StringUtils.join(
                constructResponseHeaders(response),
                "\r\n"
            );

            response.setResponseHeaderFields(responseHeaders.getBytes());
            response.setBody(body);
        }
        else {
            String responseHeaders = StringUtils.join(
                constructResponseHeaders(response),
                "\r\n"
            );
            response.setResponseHeaderFields(responseHeaders.getBytes());
            response.setBody("".getBytes());
        }

        return response;
    }

    private String[] constructResponseHeaders(Response response) {
        String mimeType = response.getMediaType();

        String[] responseHeaders = new String[]{
            "Content-Type: " + mimeType + "; charset=UTF-8"
            // TODO Content-Length
        };

        return responseHeaders;
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
