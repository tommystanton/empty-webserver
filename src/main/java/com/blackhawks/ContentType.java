package com.blackhawks;

/**
 * Created by devuser on 9/23/2014.
 */
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
        } else {
            //return "application/octet-stream";
            return "404 error";
        }
    }
}
