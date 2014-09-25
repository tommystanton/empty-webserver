package com.blackhawks;

public class ContentType {

    public String returnType(String fileName) {
        if (fileName.endsWith(".htm")) {
            return "text/html";
        } else if (fileName.endsWith(".html") || fileName.endsWith(".txt")) {
            return "text/html";
        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (fileName.endsWith(".gif")) {
            return "image/gif";
        } else if (fileName.endsWith(".png")) {
            return "image/png";
        } else {
            //return "application/octet-stream";
            return "HTTP/1.0 404 Not Found";
        }
    }
}
