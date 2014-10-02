package com.blackhawks;

public class Response {

    private byte[] statusLine;
    private byte[] responseHeaderFields;
    private byte[] body;

    private String mediaType;

    public Response() {
        this.mediaType = "text/plain";
    }

    public void setStatusLine(byte[] statusLine) {
        this.statusLine = statusLine;
    }

    public byte[] getStatusLine() {
        return statusLine;
    }

    public void setResponseHeaderFields(byte[] responseHeaderFields) {
        this.responseHeaderFields = responseHeaderFields;
    }

    public byte[] getResponseHeaderFields() {
        return responseHeaderFields;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public byte[] getBody() {
        return body;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
