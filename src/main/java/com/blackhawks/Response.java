package com.blackhawks;

public class Response {

    private byte[] statusLine;
    private byte[] responseHeaderFields;
    private byte[] body;

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
}
