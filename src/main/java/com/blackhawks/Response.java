package com.blackhawks;

public class Response {

    private String statusLine;
    private byte[] body;

    public void setStatusLine(String statusLine) {
        this.statusLine = statusLine;
    }

    public String getStatusLine() {
        return statusLine;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public byte[] getBody() {
        return body;
    }
}
